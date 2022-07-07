package com.opencode.ParserCB.entities.cbrf_reference;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "change_type")
@Getter
@Setter
@NoArgsConstructor
public class ChangeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_type_id")
    private int changeTypeId;

    @Embedded
    private Info info;

    public ChangeType (String code){
        this.info = new Info(code);
    }

}
