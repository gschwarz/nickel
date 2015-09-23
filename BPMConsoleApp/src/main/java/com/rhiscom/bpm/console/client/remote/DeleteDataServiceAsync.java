package com.rhiscom.bpm.console.client.remote;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteDataServiceAsync {

    void deleteData(Date fecha, AsyncCallback<Void> callback);

}
