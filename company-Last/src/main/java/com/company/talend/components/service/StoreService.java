package com.company.talend.components.service;

import com.company.talend.components.processor.ComponentProcessorConfiguration;
import com.company.talend.components.processor.Error;
import org.talend.sdk.component.api.service.Service;

import java.sql.SQLException;

@Service
public class StoreService {
      private DataBaseManager db;
      private int compteur;

    public StoreService(ComponentProcessorConfiguration configuration) {
        db=new DataBaseManager(configuration);
        compteur=0;
    }

    public StoreService() {
    }

    public void store(Error error){
        try {
        if(error.getWorkflowError()!=null){
            db.LogInDBErrors(error);
            compteur++;
           }
        if(error.getRuntimeError()!=null){
             db.LogInDBException(error);
            compteur++;
           }
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFile(String file){
        try {
            if(compteur==0){
                db.StoreDBSuccess(file);
            }
            else{
                db.StoreDBRejected(file);
            }
        }
          catch (SQLException e) {
            e.printStackTrace();
        }
    }

}