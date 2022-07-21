package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "creation_reason")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "creation_reason_id"))
public class CreationReason extends Handbook {

    public CreationReason(String code, String name){
        super(code, name);
    }

    public CreationReason(String code){
        super(code);
    }
}
