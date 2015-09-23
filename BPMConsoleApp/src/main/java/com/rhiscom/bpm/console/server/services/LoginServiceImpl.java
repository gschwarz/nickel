package com.rhiscom.bpm.console.server.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhiscom.bpm.console.client.remote.LoginService;
import com.rhiscom.bpm.console.shared.model.dto.OperatorDTO;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public OperatorDTO loginService(String name, String password) throws Exception {
	UserServiceImpl userService = null;
	try {
	    userService = new UserServiceImpl();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	OperatorDTO op = null;
	try {
	    op = userService.searchOperator(name);
	    System.out.println("OPERATOR :" + op.getUser() );
	} catch (Exception e) {
	    e.printStackTrace();
	   try {
	       	op = userService.searchOperator(name);
		System.out.println("OPERATOR try 2 :" + op.getUser() );
	   }
	   catch (Exception ex) {
	       ex.printStackTrace();
	   }
	}
	if (password.compareToIgnoreCase(op.getPassword()) == 0) {
	    System.out.println("PASSWORD CORRECTA");
	    storeUserInSession(op);
	} else {
	    System.out.println("PASSWORD INCORRECTA");
	    OperatorDTO dto = new OperatorDTO();
	    dto.setLoggedIn(false);
	   return dto;
	}
	return op;
    }

    @Override
    public OperatorDTO loginFromSessionServer() {
	return getUserAlreadyFromSession();
    }

    @Override
    public void logout() {
	deleteUserFromSession();
    }

    private OperatorDTO getUserAlreadyFromSession() {
	OperatorDTO user = null;
	HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
	HttpSession session = httpServletRequest.getSession();
	Object userObj = session.getAttribute("user");
	if (userObj != null && userObj instanceof OperatorDTO) {
	    user = (OperatorDTO) userObj;
	}
	return user;
    }

    private void storeUserInSession(OperatorDTO user) {
	HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
	HttpSession session = httpServletRequest.getSession(true);
	user.setLoggedIn(true);
	user.setSessionId(user.getUser());
	session.setAttribute("user", user);
    }

    private void deleteUserFromSession() {
	HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
	HttpSession session = httpServletRequest.getSession();
	session.removeAttribute("user");
    }

}