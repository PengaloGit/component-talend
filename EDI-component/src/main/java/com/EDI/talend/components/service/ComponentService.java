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
        String startDate = defaultInput.getString("DateDepart");
        String endDate = defaultInput.getString("DateLivraison");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(!sdf.parse(startDate).before(sdf.parse(endDate))){
            errors.setWorkflowError("invalid date error");
        }

    }


}
