package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Info {

    private String code;

    @Column(length = 1000)
    private String name;

    public Info(String code) {
        this.code = code;
    }
    public Info(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
