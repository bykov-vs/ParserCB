package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "srvcs")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "srvcs_id"))
public class Srvcs extends Handbook{

    public Srvcs(String code, String name) {
        super(code, name);
    }

    public Srvcs(String code){
        super(code);
    }
}
