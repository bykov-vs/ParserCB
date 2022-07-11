package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rstr")
@Getter
@Setter
@NoArgsConstructor
public class Rstr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rstr")
    private int rstrId;

    @Embedded
    private Info info;

    public Rstr (String code){
        this.info = new Info(code);
    }

    public Rstr(String code, String name) {
        this.info = new Info(code, name);
    }

}
