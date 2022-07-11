package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "creation_reason")
@Getter
@Setter
@NoArgsConstructor
public class CreationReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creation_reason_id")
    private int creationReasonId;

    @Embedded
    private Info info;

    public CreationReason (String code){
        this.info = new Info(code);
    }

    public CreationReason(String code, String name) {
        this.info = new Info(code, name);
    }
}
