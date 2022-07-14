package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "xch_type")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "xch_type_id"))
public class XchType extends Handbook{

    public XchType(String code, String name){
        super(code, name);
    }

    public XchType(String code){
        super(code);
    }
}
