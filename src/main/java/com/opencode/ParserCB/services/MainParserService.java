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
            System.out.println(e.getMessage());
            System.out.println("====================");
            e.printStackTrace();
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
}
