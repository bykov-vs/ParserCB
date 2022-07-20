package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.InfoTypeCode;
import com.opencode.ParserCB.repositories.handbooks.InfoTypeCodeRepo;
import com.opencode.ParserCB.services.exceptions.InfoTypeCodeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoTypeCodeService {
    private final InfoTypeCodeRepo infoTypeCodeRepo;

    public InfoTypeCodeService(InfoTypeCodeRepo infoTypeCodeRepo) {
        this.infoTypeCodeRepo = infoTypeCodeRepo;
    }

    public void save(InfoTypeCode infoTypeCode) {
        infoTypeCodeRepo.save(infoTypeCode);
    }

    public void update(InfoTypeCode infoTypeCode) {
        infoTypeCodeRepo.save(infoTypeCode);
    }

    public InfoTypeCode find(int id) throws InfoTypeCodeNotFoundException {
        return infoTypeCodeRepo.findById(id).orElseThrow(InfoTypeCodeNotFoundException::new);
    }

    public List<InfoTypeCode> findAll(){
        return infoTypeCodeRepo.findAll();
    }

    public void delete(InfoTypeCode infoTypeCode) {
        infoTypeCodeRepo.delete(infoTypeCode);
    }

    public InfoTypeCode findByCode(String code) {
        return infoTypeCodeRepo.findByCode(code);
    }
}
