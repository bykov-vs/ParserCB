package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rstr")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "rstr_id"))
public class Rstr extends Handbook{

    public Rstr(String code, String name) {
        super(code, name);
    }

    public Rstr(String code){
        super(code);
    }
}
