package com.opencode.ParserCB.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencode.ParserCB.entities.cbrf.*;
import com.opencode.ParserCB.entities.cbrf_reference.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class MainParserService {

    @Autowired
    private  InfoTypeCodeService infoTypeCodeService;

    @Autowired
    private ChangeTypeService changeTypeService;

    @Autowired
    private CreationReasonService creationReasonService;
    @Autowired
    private AccountStatusService accountStatusService;

    @Autowired
    private AccRstrListService accRstrListService;

    @Autowired
    private AccRstrService accRstrService;

    @Autowired
    private RegulationAccountTypeService regulationAccountTypeService;

    @Autowired
    private RstrListService rstrListService;

    @Autowired
    private PtTypeService ptTypeService;

    @Autowired
    private XchTypeService xchTypeService;

    @Autowired
    private SrvcsService srvcsService;

    @Autowired
    private RstrService rstrService;

    @Autowired
    private ParticipantInfoService participantInfoService;

    @Autowired
    private ParticipantStatusService participantStatusService;
    @Autowired
    private Ed807Service ed807Service;

    @Autowired
    private BicDirectoryEntryService bicDirectoryEntryService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SwBicsService swBicsService;

    public void parseFile(InputStream file) throws IOException {
        try {
            System.out.println();

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            Ed807 ed807 = xmlMapper.readValue(file, Ed807.class);

            CreationReason creationReason = creationReasonService.findByCode(ed807.getCreationReason().getInfo().getCode());
            InfoTypeCode infoTypeCode = infoTypeCodeService.findByCode(ed807.getInfoTypeCode().getInfo().getCode());

            ed807.setCreationReason(creationReason);
            ed807.setInfoTypeCode(infoTypeCode);
            ed807Service.save(ed807);

            ArrayList<BicDirectoryEntry> bicDirectoryEntries = ed807.getBicDirectoryEntries();

            for (BicDirectoryEntry entry : bicDirectoryEntries) {
                entry.setEd(ed807);

                ChangeType changeType = entry.getChangeType();
                if (changeType != null){
                    entry.setChangeType(changeTypeService.findByCode(changeType
                            .getInfo()
                            .getCode()));
                }
                //Сохранение ParticipantInfo, привязанного к данному БИК
                ParticipantInfo participantInfo = entry.getParticipantInfo();

                ParticipantStatus participantStatus = participantStatusService.findByCode(participantInfo
                        .getParticipantStatus()
                        .getInfo()
                        .getCode());
                Srvcs srvcs = srvcsService.findByCode(participantInfo
                        .getSrvcs()
                        .getInfo()
                        .getCode());
                XchType xchType = xchTypeService.findByCode(participantInfo
                        .getXchType()
                        .getInfo()
                        .getCode());
                PtType ptType = ptTypeService.findByCode(participantInfo
                        .getPtType()
                        .getInfo()
                        .getCode());

                RstrList rstrList = participantInfo.getRstrList();

                if (rstrList != null) {
                    Rstr rstr = rstrService.findByCode(rstrList
                            .getRstr()
                            .getInfo()
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
                            .getInfo()
                            .getCode());
                    RegulationAccountType regulationAccountType = regulationAccountTypeService.findByCode(acc
                            .getRegulationAccountType()
                            .getInfo()
                            .getCode());

                    AccRstrList accRstrList = acc.getAccRstrList();
                    if (accRstrList != null){
                        AccRstr accRstr = accRstrService.findByCode(accRstrList.
                                getAccRstr().
                                getInfo().
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
                accountStatus.setInfo(new Info(code, name));
                accountStatusService.save(accountStatus);
            }else accountStatusService.save(new AccountStatus(code, name));
        }
        if(handbook.equals("AccRstr")){
            AccRstr accRstr = accRstrService.findByCode(prevValue);
            if (accRstr != null) {
                accRstr.setInfo(new Info(code, name));
                accRstrService.save(accRstr);
            } else accRstrService.save(new AccRstr(code, name));
        }
        if(handbook.equals("ChangeType")) {
            ChangeType changeType = changeTypeService.findByCode(prevValue);
            if (changeType != null){
                changeType.setInfo(new Info(code, name));
                changeTypeService.save(changeType);
            } else changeTypeService.save(new ChangeType(code, name));
        }
        if(handbook.equals("CreationReason")) {
            CreationReason creationReason = creationReasonService.findByCode(prevValue);
            if (creationReason != null) {
                creationReason.setInfo(new Info(code, name));
                creationReasonService.save(creationReason);
            } else creationReasonService.save(new CreationReason(code, name));
        }
        if(handbook.equals("InfoTypeCode")) {
            InfoTypeCode infoTypeCode = infoTypeCodeService.findByCode(prevValue);
            if (infoTypeCode != null) {
                infoTypeCode.setInfo(new Info(code, name));
                infoTypeCodeService.save(infoTypeCode);
            } else infoTypeCodeService.save(new InfoTypeCode(code, name));
        }
        if(handbook.equals("ParticipantStatus")) {
            ParticipantStatus participantStatus = participantStatusService.findByCode(prevValue);
            if (participantStatus != null) {
                participantStatus.setInfo(new Info(code, name));
                participantStatusService.save(participantStatus);
            } else participantStatusService.save(new ParticipantStatus(code, name));
        }
        if(handbook.equals("PtType")){
            PtType ptType = ptTypeService.findByCode(prevValue);
            if (ptType != null) {
                ptType.setInfo(new Info(code, name));
                ptTypeService.save(ptType);
            } else ptTypeService.save(new PtType(code, name));
        }
        if(handbook.equals("RegulationAccountType")) {
            RegulationAccountType regulationAccountType = regulationAccountTypeService.findByCode(prevValue);
            if (regulationAccountType != null) {
                regulationAccountType.setInfo(new Info(code, name));
                regulationAccountTypeService.save(regulationAccountType);
            } else regulationAccountTypeService.save(new RegulationAccountType(code, name));
        }
        if(handbook.equals("Rstr")){
            Rstr rstr  = rstrService.findByCode(prevValue);
            if (rstr != null) {
                rstr.setInfo(new Info(code, name));
                rstrService.save(rstr);
            } else rstrService.save(new Rstr(code, name));
        }
        if(handbook.equals("Srvcs")){
            Srvcs srvcs = srvcsService.findByCode(prevValue);
            if (srvcs != null) {
                srvcs.setInfo(new Info(code, name));
                srvcsService.save(srvcs);
            } else srvcsService.save(new Srvcs(code, name));
        }
        if(handbook.equals("XchType")){
            XchType xchType = xchTypeService.findByCode(prevValue);
            if (xchType != null) {
                xchType.setInfo(new Info(code, name));
                xchTypeService.save(xchType);
            } else  xchTypeService.save(new XchType(code, name));
        }
    }
}
