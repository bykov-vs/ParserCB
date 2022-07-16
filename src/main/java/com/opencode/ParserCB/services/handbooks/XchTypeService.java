package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.XchType;
import com.opencode.ParserCB.repositories.HandbookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XchTypeService {
    private final HandbookRepo<XchType> xchTypeRepo;

    public XchTypeService(HandbookRepo<XchType> xchTypeRepo) {
        this.xchTypeRepo = xchTypeRepo;
    }

    public void save(XchType xchType) {
        xchTypeRepo.save(xchType);
    }

    public void update(XchType xchType) {
        xchTypeRepo.save(xchType);
    }

    /*public XchType find(int id) throws AccountNotFoundException {
        return xchTypeRepo.findById(id).orElseThrow(AccountNotFoundException::new);
    }*/

    public List<XchType> findAll(){

        List<XchType> list = xchTypeRepo.findAll();
        System.out.println(list.getClass());

        return list;
    }

    public void delete(XchType xchType) {
        xchTypeRepo.delete(xchType);
    }

    public XchType findByCode(String code) {
        return xchTypeRepo.findByCode(code);
    }
}
