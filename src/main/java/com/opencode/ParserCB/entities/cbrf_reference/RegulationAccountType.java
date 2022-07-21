package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "regulation_account_type")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "regulation_account_type_id"))
public class RegulationAccountType extends Handbook {

    public RegulationAccountType(String code, String name) {
        super(code, name);
    }

    public RegulationAccountType(String code){
        super(code);
    }
}
