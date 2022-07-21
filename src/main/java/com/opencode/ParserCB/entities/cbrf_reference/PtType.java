package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pt_type")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "pt_type_id"))
public class PtType extends Handbook{
    public PtType(String code, String name){
        super(code, name);
    }

    public PtType(String code){
        super(code);
    }
}
