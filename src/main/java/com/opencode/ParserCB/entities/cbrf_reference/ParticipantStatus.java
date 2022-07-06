package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "participant_status")
@Getter
@Setter
@NoArgsConstructor
public class ParticipantStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_status_id")
    private int participantStatusId;

    @Embedded
    private Info info;
}
