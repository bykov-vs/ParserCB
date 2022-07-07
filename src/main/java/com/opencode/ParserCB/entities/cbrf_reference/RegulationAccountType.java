package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "regulation_account_type")
@Getter
@Setter
@NoArgsConstructor
public class RegulationAccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regulation_account_type_id")
    private int regulationAccountTypeId;

    @Embedded
    private Info info;

    public RegulationAccountType (String code){
        this.info = new Info(code);
    }

}
