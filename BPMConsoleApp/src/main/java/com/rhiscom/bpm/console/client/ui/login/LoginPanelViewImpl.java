package com.rhiscom.bpm.console.client.ui.login;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.rhiscom.bpm.console.client.ClientFactory;
import com.rhiscom.bpm.console.client.event.LoginEvent;
import com.rhiscom.bpm.console.client.remote.LoginService;
import com.rhiscom.bpm.console.shared.ApplicationContext;
import com.rhiscom.bpm.console.shared.Authentication;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class LoginPanelViewImpl extends Composite {

    // Presenter presenter;
    private ClientFactory clientFactory;
    private EventBus bus;
    private static LoginPanelViewImplUiBinder uiBinder = GWT.create(LoginPanelViewImplUiBinder.class);
    
    private static final LoginImageResources imageResources = GWT.create(LoginImageResources.class);
    
    interface LoginPanelViewImplUiBinder extends UiBinder<Widget, LoginPanelViewImpl> {
    }

    @UiField
    Button button;
    @UiField
    Label lblError;
    @UiField
    TextBox Username;

    @UiField(provided = true)
    PasswordTextBox password;

    public LoginPanelViewImpl(final ClientFactory clientFactory, EventBus eventBus) {
	this.clientFactory = clientFactory;
	this.bus = eventBus;
	
	Username = new TextBox();
	Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand () {
	        public void execute () {
	            Username.setFocus(true);
	        }
	    });
	
	password = new PasswordTextBox();
	password.addKeyDownHandler(new KeyDownHandler() {

	    @Override
	    public void onKeyDown(KeyDownEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
		    button.click();
		    button.setEnabled(false);
		}

	    }

	});
	initWidget(uiBinder.createAndBindUi(this));
	lblError.setVisible(false);
    }

    @UiHandler("button")
    void onClick(ClickEvent e) {
	button.setEnabled(false);
	
	//se le da false para que no tenga auto-hide cuando se hace clic afuera
	final PopupPanel loadingPanel = new PopupPanel(false);
	loadingPanel.setWidget(new Image(imageResources.getLoadingIcon()));
	//TODO no puede ser que estemos modificando el zindex a mano
	loadingPanel.getElement().getStyle().setZIndex(6);
	loadingPanel.setGlassEnabled(true);
	loadingPanel.center();
	loadingPanel.show();
	
	
	try {
	    LoginService.Util.getInstance().loginService(getUsername(), getPassword(),
		    new AsyncCallback<OperatorDTO>() {
			@Override
			public void onSuccess(OperatorDTO result) {

			    if (result.isLoggedIn()) {

				String sessionID = result.getSessionId();
				final long DURATION = 1000 * 60 * 60 * 24 * 1;
				Date expires = new Date(System.currentTimeMillis() + DURATION);
				Cookies.setCookie("sid", sessionID, expires, null, "/", false);

				Authentication auth = new Authentication();

				auth.setUser(getUsername());
				auth.setPass(getPassword());
				auth.setStatus(true);
				auth.setOperator(result);

				ApplicationContext.setAuth(auth);

				bus.fireEvent(new LoginEvent());

				setVisible(false);

			
			    } 
			    else if(!result.isLoggedIn()) {
				lblError.setVisible(true);
				lblError.setText("Contrase\u00F1a incorrecta");
				button.setEnabled(true);
			    }
			    
			    
			    else {
				lblError.setVisible(true);
				lblError.setText("Usuario no existe");
				button.setEnabled(true);
			    }
			    loadingPanel.hide();
			}

			@Override
			public void onFailure(Throwable caught) {
			    lblError.setVisible(true);
			    lblError.setText("Usuario no existe");
			    loadingPanel.hide();
			    button.setEnabled(true);
			}
		    });
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

    }

    public String getUsername() {
	return Username.getText();
    }

    public String getPassword() {
	return password.getText();
    }

}
