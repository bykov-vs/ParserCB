package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "acc_rstr")
@Getter
@Setter
@NoArgsConstructor
public class AccRstr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_rstr_id")
    private int accRstrId;

    @Embedded
    private Info info;

    public AccRstr (String s){
        this.info = new Info(s);
    }
}
