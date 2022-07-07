package com.opencode.ParserCB.entities.cbrf_reference;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account_status")
@Getter
@Setter
@NoArgsConstructor
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_status_id")
    private int accountStatusId;

    @Embedded
    private Info info;

    public AccountStatus (String code){
        this.info = new Info(code);
    }

}
