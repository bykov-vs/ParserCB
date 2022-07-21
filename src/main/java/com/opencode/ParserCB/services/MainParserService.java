package com.opencode.ParserCB.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencode.ParserCB.entities.cbrf.*;
import com.opencode.ParserCB.entities.cbrf_reference.*;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class MainParserService {

    private final ApplicationContext context;

    private final AccRstrListService accRstrListService;

    private final ParticipantInfoService participantInfoService;

    private final Ed807Service ed807Service;

    private final BicDirectoryEntryService bicDirectoryEntryService;

    private final AccountService accountService;

    private final RstrListService rstrListService;

    private final SwBicsService swBicsService;



    public List<Ed807> getEdFiles(){
        return ed807Service.findAll();
    }

    public void parseFile(InputStream file) throws IOException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());

            Ed807 ed807 = xmlMapper.readValue(file, Ed807.class);

            HandbookService<Handbook> handbookService;

            handbookService = new HandbookService<>(context, "CreationReason");
            CreationReason creationReason = (CreationReason) handbookService.findByCode(ed807
                    .getCreationReason()
                    .getCode());

            handbookService = new HandbookService<>(context, "InfoTypeCode");
            InfoTypeCode infoTypeCode = (InfoTypeCode) handbookService.findByCode(ed807
                    .getInfoTypeCode()
                    .getCode());

            ed807.setCreationReason(creationReason);
            ed807.setInfoTypeCode(infoTypeCode);
            ed807Service.save(ed807);

            ArrayList<BicDirectoryEntry> bicDirectoryEntries = ed807.getBicDirectoryEntries();

            HandbookService<ChangeType> changeTypeHandbookService = new HandbookService<>(context,
                    "ChangeType");
            HandbookService<ParticipantStatus> participantStatusHandbookService = new HandbookService<>(context,
                    "ParticipantStatus");
            HandbookService<Srvcs> srvcsHandbookService = new HandbookService<>(context,
                    "Srvcs");
            HandbookService<XchType> xchTypeHandbookService = new HandbookService<>(context,
                    "XchType");
            HandbookService<PtType> ptTypeHandbookService = new HandbookService<>(context,
                    "PtType");
            HandbookService<Rstr> rstrHandbookService = new HandbookService<>(context,
                    "Rstr");
            HandbookService<AccountStatus> accountStatusHandbookService = new HandbookService<>(context,
                    "AccountStatus");
            HandbookService<RegulationAccountType> regulationAccountTypeHandbookService = new HandbookService<>(context,
                    "RegulationAccountType");
            HandbookService<AccRstr> accRstrHandbookService = new HandbookService<>(context,
                    "AccRstr");

            for (BicDirectoryEntry entry : bicDirectoryEntries) {
                entry.setEd(ed807);

                ChangeType changeType = entry.getChangeType();
                if (changeType != null){
                    entry.setChangeType(changeTypeHandbookService.findByCode(changeType
                            .getCode()));
                }
                //Сохранение ParticipantInfo, привязанного к данному БИК
                ParticipantInfo participantInfo = entry.getParticipantInfo();

                ParticipantStatus participantStatus = participantStatusHandbookService.findByCode(participantInfo
                        .getParticipantStatus()
                        .getCode());
                Srvcs srvcs = srvcsHandbookService.findByCode(participantInfo
                        .getSrvcs()
                        .getCode());
                XchType xchType = xchTypeHandbookService.findByCode(participantInfo
                        .getXchType()
                        .getCode());
                PtType ptType = ptTypeHandbookService.findByCode(participantInfo
                        .getPtType()
                        .getCode());

                RstrList rstrList = participantInfo.getRstrList();

                if (rstrList != null) {
                    Rstr rstr = rstrHandbookService.findByCode(rstrList
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

                    AccountStatus accountStatus = accountStatusHandbookService.findByCode(acc.getAccountStatus()
                            .getCode());
                    RegulationAccountType regulationAccountType = regulationAccountTypeHandbookService.findByCode(acc
                            .getRegulationAccountType()
                            .getCode());

                    AccRstrList accRstrList = acc.getAccRstrList();
                    if (accRstrList != null){
                        AccRstr accRstr = accRstrHandbookService.findByCode(accRstrList.
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

    public List<? extends Handbook> getInfoHandbook(String handbook){
        HandbookService<Handbook> handbookService = new HandbookService<>(context, handbook);
        return handbookService.findAll();
    }

    public void deleteHandbookEntity(String handbook, String code){
        HandbookService<Handbook> handbookService = new HandbookService<>(context, handbook);
        handbookService.delete(handbookService.findByCode(code));
    }
    public void saveHandbookEntity(String code, String name, String handbook, String prevValue){
        HandbookService<Handbook> handbookService = new HandbookService<>(context, handbook);
        Handbook record = handbookService.findByCode(code);

        if (record != null){
            record.setCode(prevValue);
            record.setName(name);

            handbookService.save(record);
        }else {
            handbookService.save(HandbookEntityFactory.getHandbookEntity(handbook, code, name));
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
