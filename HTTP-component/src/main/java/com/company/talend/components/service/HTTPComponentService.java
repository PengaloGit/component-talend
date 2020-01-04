package com.company.talend.components.service;

import com.company.talend.components.processor.Error;
import com.company.talend.components.processor.HttpProcessorConfiguration;
import org.talend.sdk.component.api.service.Service;

@Service
public class HTTPComponentService {
    private Http httpRequest;

    public HTTPComponentService() {
    }

    public HTTPComponentService(HttpProcessorConfiguration  configuration) {
        httpRequest=new Http(configuration.getUrl());
    }

    public void sendToServer(Error error)throws Exception{
       if(error.getRuntimeError()!=null || error.getWorkflowError()!=null)
        httpRequest.sendPost(error);
    }


}