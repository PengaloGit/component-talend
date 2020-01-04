package com.company.talend.components.service;


import com.company.talend.components.processor.ComponentProcessorConfiguration;
import com.company.talend.components.processor.Error;
import org.talend.sdk.component.api.service.Service;

import java.sql.*;

@Service
public class DataBaseManager {

   private Connection c;
   private PreparedStatement ps;
    public DataBaseManager(ComponentProcessorConfiguration configuration) {
        String url="jdbc:postgresql://"+configuration.getHost()+":"+configuration.getPort()+"/"+configuration.getDatabase();
        try {
            c = DriverManager.getConnection(url, configuration.getUser(), configuration.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DataBaseManager() {
    }

    // you can put logic here you can reuse in components
    public void LogInDBErrors(Error error) throws SQLException {
        ps = c.prepareCall("INSERT INTO workflowErrors (file,row,workflowerror)  VALUES (?,?,?)");
        ps.setString(1,error.getFileName());
        ps.setString(2,error.getRow());
        ps.setString(3,error.getWorkflowError());
        ps.execute();
    }

    public void LogInDBException(Error error) throws SQLException{
        ps = c.prepareCall("INSERT INTO runtimeErrors (file,row,runtimeerror)  VALUES (?,?,?)");
        ps.setString(1,error.getFileName());
        ps.setString(2,error.getRow());
        ps.setString(3,error.getRuntimeError());
        ps.execute();
    }

    public void StoreDBSuccess(String file) throws SQLException{
        ps = c.prepareCall("INSERT INTO acceptedFiles (file)  VALUES (?)");
        ps.setString(1,file);
        ps.execute();
    }
    public void StoreDBRejected(String file) throws SQLException{
        ps = c.prepareCall("INSERT INTO RejectedFiles (file)  VALUES (?)");
        ps.setString(1,file);
        ps.execute();
    }

}