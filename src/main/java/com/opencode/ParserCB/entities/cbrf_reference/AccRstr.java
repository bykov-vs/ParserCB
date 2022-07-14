package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "acc_rstr")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "acc_rstr_id"))
public class AccRstr extends Handbook{

    public AccRstr(String code, String name){
        super(code, name);
    }

    public AccRstr(String code){
        super(code);
    }
}
