package com.opencode.ParserCB.entities.cbrf_reference;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "change_type")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "change_type_id"))
public class ChangeType extends Handbook{

    public ChangeType(String code, String name){
        super(code, name);
    }

    public ChangeType(String code){
        super(code);
    }
}
