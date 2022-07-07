package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pt_type")
@Getter
@Setter
@NoArgsConstructor
public class PtType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_type_id")
    private int ptTypeId;

    @Embedded
    private Info info;

    public PtType (String code){
        this.info = new Info(code);
    }

}
