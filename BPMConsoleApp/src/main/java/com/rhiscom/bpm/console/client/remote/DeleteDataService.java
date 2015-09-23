package com.rhiscom.bpm.console.client.remote;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DeleteDataServiceImpl")
public interface DeleteDataService extends RemoteService {
    void deleteData(Date fecha) throws Exception;
}
