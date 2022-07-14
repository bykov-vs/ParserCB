package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "info_type_code")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "info_type_code_id"))
public class InfoTypeCode extends Handbook{

    public InfoTypeCode(String code, String name){
        super(code, name);
    }

    public InfoTypeCode(String code){
        super(code);
    }
}
