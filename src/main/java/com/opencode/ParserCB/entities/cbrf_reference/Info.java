package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Info {

    private String code;

    private String name;
}
