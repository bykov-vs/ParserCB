package com.opencode.ParserCB.entities.cbrf_reference;

public class HandbookEntityFactory {

    public static Handbook getHandbookEntity(String typeHandbook, String code, String name) {
        switch (typeHandbook) {
            case "AccountStatus":
                return new AccountStatus(code, name);
            case "AccRstr":
                return new AccRstr(code, name);
            case "changeType":
                return new ChangeType(code, name);
            case "CreationReason":
                return new CreationReason(code, name);
            case "InfoTypeCode":
                return new InfoTypeCode(code, name);
            case "ParticipantStatus":
                return new ParticipantStatus(code, name);
            case "PtType":
                return new PtType(code, name);
            case "RegulationAccountType":
                return new RegulationAccountType(code, name);
            case "Rstr":
                return new Rstr(code, name);
            case "Srvcs":
                return new Srvcs(code, name);
            case "XchType":
                return new XchType(code, name);
            default:
                return null;
        }
    }
}
