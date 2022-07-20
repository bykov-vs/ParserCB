package com.opencode.ParserCB.repositories.handbooks;

import org.springframework.context.ApplicationContext;


public class HandbookRepositoryFactory {

    public static HandbookRepo<?> getRepository(ApplicationContext context, String typeRepo) {
        switch (typeRepo) {
            case "AccountStatus":
                return context.getBean(AccountStatusRepo.class);
            case "AccRstr":
                return context.getBean(AccRstrRepo.class);
            case "ChangeType":
                return context.getBean(ChangeTypeRepo.class);
            case "CreationReason":
                return context.getBean(CreationReasonRepo.class);
            case "InfoTypeCode":
                return context.getBean(InfoTypeCodeRepo.class);
            case "ParticipantStatus":
                return context.getBean(ParticipantStatusRepo.class);
            case "PtType":
                return context.getBean(PtTypeRepo.class);
            case "RegulationAccountType":
                return context.getBean(RegulationAccountTypeRepo.class);
            case "Rstr":
                return context.getBean(RstrRepo.class);
            case "Srvcs":
                return context.getBean(SrvcsRepo.class);
            case "XchType":
                return context.getBean(XchTypeRepo.class);
            default:
                return null;
        }

    }
}
