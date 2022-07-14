package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "participant_status")
@Data @NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "participant_status_id"))
public class ParticipantStatus extends Handbook{

    public ParticipantStatus(String code, String name){
        super(code, name);
    }

    public ParticipantStatus(String code){
        super(code);
    }
}
