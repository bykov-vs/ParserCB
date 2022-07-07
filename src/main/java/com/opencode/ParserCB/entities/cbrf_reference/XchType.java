package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "xch_type")
@Getter
@Setter
@NoArgsConstructor
public class XchType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xch_type_id")
    private int xchTypeId;

    @Embedded
    private Info info;

    public XchType (String code){
        this.info = new Info(code);
    }

}
