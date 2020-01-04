package com.EDI.talend.components.service;

import com.EDI.talend.components.processor.Error;
import com.EDI.talend.components.processor.TEDIComponentProcessor;
import com.EDI.talend.components.processor.TEDIComponentProcessorConfiguration;
import org.talend.sdk.component.api.record.Record;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ComponentService {

    public void fileTreatment(Record defaultInput, Error errors)  throws Exception{
        //Here goes the treatment code
        
        //Setting Error
        errors.setWorkflowError("my error");
        }

    }


}
