package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.*;
import com.opencode.ParserCB.services.handbooks.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DefaultServiceFactory {

    public DefaultService<?> getService(Object object){
/*
        if (object instanceof AccountStatus){
            return new AccountStatusService();
        }
        if (object instanceof AccRstr){
            return new AccRstrService();
        }
        if (object instanceof ChangeType){
            return new ChangeTypeService();
        }
        if (object instanceof CreationReason){
            return new CreationReasonService();
        }
        if (object instanceof InfoTypeCode){
            return new InfoTypeCodeService();
        }
        if (object instanceof ParticipantStatus){
            return new ParticipantStatusService();
        }
        if (object instanceof PtType){
            return new PtTypeService();
        }
        if (object instanceof RegulationAccountType){
            return new RegulationAccountTypeService();
        }
        if (object instanceof Rstr){
            return new RstrService();
        }
        if (object instanceof Srvcs){
            return new SrvcsService();
        }
        if (object instanceof XchType){
            return new XchTypeService();
        }
*/
       return null;
    }
}
