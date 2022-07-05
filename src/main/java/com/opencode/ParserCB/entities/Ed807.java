package com.opencode.ParserCB.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ed807")
@Getter
@Setter
@NoArgsConstructor
public class Ed807 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ed_id")
    private int edId;

    private String xmlns;

    private String edNo;

    @Temporal(TemporalType.DATE)
    private Date edDate;

    private String edAuthor;
    
    private LocalDateTime creationDateTime;

    @Temporal(TemporalType.DATE)
    private Date businessDay;

    private int directoryVersion;

    @JoinColumn(name = "creation_reason_id")
    private int creationReasonId;

    @JoinColumn(name = "info_type_code_id")
    private int infoTypeCodeId;

    private int edReceiver;
}
