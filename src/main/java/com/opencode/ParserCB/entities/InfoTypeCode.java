package com.opencode.ParserCB.entities;

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

    private String code;

    private String name;
}
