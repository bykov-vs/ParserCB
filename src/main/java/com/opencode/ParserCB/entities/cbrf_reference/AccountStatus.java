package com.opencode.ParserCB.entities.cbrf_reference;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account_status")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "account_status_id"))
public class AccountStatus extends Handbook{

    public AccountStatus(String code, String name){
        super(code, name);
    }

    public AccountStatus(String code){
        super(code);
    }
}
