package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "info_type_code")
@Getter
@Setter
@NoArgsConstructor
public class InfoTypeCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_type_code_id")
    private int infoTypeCodeId;

    @Embedded
    private Info info;

    public InfoTypeCode (String code){
        this.info = new Info(code);
    }

    public InfoTypeCode(String code, String name) {
        this.info = new Info(code, name);
    }
}
