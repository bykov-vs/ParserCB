package com.opencode.ParserCB.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencode.ParserCB.entities.cbrf.*;
import com.opencode.ParserCB.entities.cbrf_reference.*;
import com.opencode.ParserCB.services.handbooks.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class MainParserService {

    private final InfoTypeCodeService infoTypeCodeService;

    private final ChangeTypeService changeTypeService;

    private final CreationReasonService creationReasonService;

    private final AccountStatusService accountStatusService;

    private final AccRstrListService accRstrListService;

    private final AccRstrService accRstrService;

    private final RegulationAccountTypeService regulationAccountTypeService;

    private final RstrListService rstrListService;

    private final PtTypeService ptTypeService;

    private final XchTypeService xchTypeService;

    private final SrvcsService srvcsService;

    private final RstrService rstrService;

    private final ParticipantInfoService participantInfoService;

    private final ParticipantStatusService participantStatusService;

    private final Ed807Service ed807Service;

    private final BicDirectoryEntryService bicDirectoryEntryService;

    private final AccountService accountService;

    private final SwBicsService swBicsService;


    public List<Ed807> getEdFiles(){
        return ed807Service.findAll();
    }

    public void parseFile(InputStream file) throws IOException {
        try {
            System.out.println();

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            Ed807 ed807 = xmlMapper.readValue(file, Ed807.class);

            CreationReason creationReason = creationReasonService.findByCode(ed807
                    .getCreationReason()
                    .getCode());
            InfoTypeCode infoTypeCode = infoTypeCodeService.findByCode(ed807
                    .getInfoTypeCode()
                    .getCode());

            ed807.setCreationReason(creationReason);
            ed807.setInfoTypeCode(infoTypeCode);
            ed807Service.save(ed807);

            ArrayList<BicDirectoryEntry> bicDirectoryEntries = ed807.getBicDirectoryEntries();

            for (BicDirectoryEntry entry : bicDirectoryEntries) {
                entry.setEd(ed807);

                ChangeType changeType = entry.getChangeType();
                if (changeType != null){
                    entry.setChangeType(changeTypeService.findByCode(changeType
                            .getCode()));
                }
                //Сохранение ParticipantInfo, привязанного к данному БИК
                ParticipantInfo participantInfo = entry.getParticipantInfo();

                ParticipantStatus participantStatus = participantStatusService.findByCode(participantInfo
                        .getParticipantStatus()
                        .getCode());
                Srvcs srvcs = srvcsService.findByCode(participantInfo
                        .getSrvcs()
                        .getCode());
                XchType xchType = xchTypeService.findByCode(participantInfo
                        .getXchType()
                        .getCode());
                PtType ptType = ptTypeService.findByCode(participantInfo
                        .getPtType()
                        .getCode());

                RstrList rstrList = participantInfo.getRstrList();

                if (rstrList != null) {
                    Rstr rstr = rstrService.findByCode(rstrList
                            .getRstr()
                            .getCode());

                    rstrList.setRstr(rstr);
                    rstrListService.save(rstrList);
                    participantInfo.setRstrList(rstrList);
                }

                participantInfo.setParticipantStatus(participantStatus);
                participantInfo.setSrvcs(srvcs);
                participantInfo.setXchType(xchType);
                participantInfo.setPtType(ptType);

                participantInfoService.save(participantInfo);
                bicDirectoryEntryService.save(entry);

                //Сохранение SWBIC, привязанного к данному БИК
                SwBics swBics = entry.getSwBics();
                if (swBics != null) {
                    swBics.setBicDirectoryEntry(entry);
                    swBicsService.save(swBics);
                }

                //Сохранение всех аккаунтов, привязанных к данному БИК
                for (Account acc : entry.getAccounts()) {
                    acc.setBicDirectoryEntry(entry);

                    AccountStatus accountStatus = accountStatusService.findByCode(acc.getAccountStatus()
                            .getCode());
                    RegulationAccountType regulationAccountType = regulationAccountTypeService.findByCode(acc
                            .getRegulationAccountType()
                            .getCode());

                    AccRstrList accRstrList = acc.getAccRstrList();
                    if (accRstrList != null){
                        AccRstr accRstr = accRstrService.findByCode(accRstrList.
                                getAccRstr().
                                getCode());
                        accRstrList.setAccRstr(accRstr);
                        accRstrListService.save(accRstrList);
                        acc.setAccRstrList(accRstrList);
                    }

                    acc.setRegulationAccountType(regulationAccountType);
                    acc.setAccountStatus(accountStatus);
                    accountService.save(acc);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<?> getInfoHandbook(String handbook){
        if(handbook.equals("AccountStatus")) return accountStatusService.findAll();
        if(handbook.equals("AccRstr")) return accRstrService.findAll();
        if(handbook.equals("ChangeType")) return changeTypeService.findAll();
        if(handbook.equals("CreationReason")) return creationReasonService.findAll();
        if(handbook.equals("InfoTypeCode")) return infoTypeCodeService.findAll();
        if(handbook.equals("ParticipantStatus")) return participantStatusService.findAll();
        if(handbook.equals("PtType")) return ptTypeService.findAll();
        if(handbook.equals("RegulationAccountType")) return regulationAccountTypeService.findAll();
        if(handbook.equals("Rstr")) return rstrService.findAll();
        if(handbook.equals("Srvcs")) return srvcsService.findAll();
        if(handbook.equals("XchType")) return xchTypeService.findAll();

        return null;
    }

    public void deleteHandbookEntity(String handbook, String code){
        if(handbook.equals("AccountStatus")) accountStatusService.delete(accountStatusService.findByCode(code));
        if(handbook.equals("AccRstr"))  accRstrService.delete(accRstrService.findByCode(code));
        if(handbook.equals("ChangeType"))  changeTypeService.delete(changeTypeService.findByCode(code));
        if(handbook.equals("CreationReason"))  creationReasonService.delete(creationReasonService.findByCode(code));
        if(handbook.equals("InfoTypeCode"))  infoTypeCodeService.delete(infoTypeCodeService.findByCode(code));
        if(handbook.equals("ParticipantStatus"))  participantStatusService.delete(participantStatusService.findByCode(code));
        if(handbook.equals("PtType"))  ptTypeService.delete(ptTypeService.findByCode(code));
        if(handbook.equals("RegulationAccountType"))  regulationAccountTypeService.delete(regulationAccountTypeService.findByCode(code));
        if(handbook.equals("Rstr"))  rstrService.delete(rstrService.findByCode(code));
        if(handbook.equals("Srvcs"))  srvcsService.delete(srvcsService.findByCode(code));
        if(handbook.equals("XchType"))  xchTypeService.delete(xchTypeService.findByCode(code));
    }
    public void saveHandbookEntity(String code, String name, String handbook, String prevValue){
        if(handbook.equals("AccountStatus")){
            AccountStatus accountStatus = accountStatusService.findByCode(prevValue);
            if (accountStatus != null){
                accountStatus.setName(name);
                accountStatus.setCode(code);
                accountStatusService.save(accountStatus);
            }else accountStatusService.save(new AccountStatus(code, name));
        }
        if(handbook.equals("AccRstr")){
            AccRstr accRstr = accRstrService.findByCode(prevValue);
            if (accRstr != null) {
                accRstr.setName(name);
                accRstr.setCode(code);
                accRstrService.save(accRstr);
            } else accRstrService.save(new AccRstr(code, name));
        }
        if(handbook.equals("ChangeType")) {
            ChangeType changeType = changeTypeService.findByCode(prevValue);
            if (changeType != null){
                changeType.setName(name);
                changeType.setCode(code);
                changeTypeService.save(changeType);
            } else changeTypeService.save(new ChangeType(code, name));
        }
        if(handbook.equals("CreationReason")) {
            CreationReason creationReason = creationReasonService.findByCode(prevValue);
            if (creationReason != null) {
                creationReason.setName(name);
                creationReason.setCode(code);
                creationReasonService.save(creationReason);
            } else creationReasonService.save(new CreationReason(code, name));
        }
        if(handbook.equals("InfoTypeCode")) {
            InfoTypeCode infoTypeCode = infoTypeCodeService.findByCode(prevValue);
            if (infoTypeCode != null) {
                infoTypeCode.setName(name);
                infoTypeCode.setCode(code);
                infoTypeCodeService.save(infoTypeCode);
            } else infoTypeCodeService.save(new InfoTypeCode(code, name));
        }
        if(handbook.equals("ParticipantStatus")) {
            ParticipantStatus participantStatus = participantStatusService.findByCode(prevValue);
            if (participantStatus != null) {
                participantStatus.setName(name);
                participantStatus.setCode(code);
                participantStatusService.save(participantStatus);
            } else participantStatusService.save(new ParticipantStatus(code, name));
        }
        if(handbook.equals("PtType")){
            PtType ptType = ptTypeService.findByCode(prevValue);
            if (ptType != null) {
                ptType.setName(name);
                ptType.setCode(code);
                ptTypeService.save(ptType);
            } else ptTypeService.save(new PtType(code, name));
        }
        if(handbook.equals("RegulationAccountType")) {
            RegulationAccountType regulationAccountType = regulationAccountTypeService.findByCode(prevValue);
            if (regulationAccountType != null) {
                regulationAccountType.setName(name);
                regulationAccountType.setCode(code);
                regulationAccountTypeService.save(regulationAccountType);
            } else regulationAccountTypeService.save(new RegulationAccountType(code, name));
        }
        if(handbook.equals("Rstr")){
            Rstr rstr  = rstrService.findByCode(prevValue);
            if (rstr != null) {
                rstr.setName(name);
                rstr.setCode(code);
                rstrService.save(rstr);
            } else rstrService.save(new Rstr(code, name));
        }
        if(handbook.equals("Srvcs")){
            Srvcs srvcs = srvcsService.findByCode(prevValue);
            if (srvcs != null) {
                srvcs.setName(name);
                srvcs.setCode(code);
                srvcsService.save(srvcs);
            } else srvcsService.save(new Srvcs(code, name));
        }
        if(handbook.equals("XchType")){
            XchType xchType = xchTypeService.findByCode(prevValue);
            if (xchType != null) {
                xchType.setName(name);
                xchType.setCode(code);
                xchTypeService.save(xchType);
            } else  {
                xchTypeService.save(new XchType(code, name));
            }
        }
    }

    public List<String> getListOfHandbooks(){
        ArrayList<String> options = new ArrayList<>();
        options.add("AccountStatus");
        options.add("AccRstr");
        options.add("ChangeType");
        options.add("CreationReason");
        options.add("InfoTypeCode");
        options.add("ParticipantStatus");
        options.add("PtType");
        options.add("RegulationAccountType");
        options.add("Rstr");
        options.add("Srvcs");
        options.add("XchType");

        return options;
    }
}
