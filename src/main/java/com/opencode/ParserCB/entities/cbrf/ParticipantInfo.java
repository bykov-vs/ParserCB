package com.opencode.ParserCB.entities.cbrf;

import com.opencode.ParserCB.entities.cbrf_reference.PtType;
import com.opencode.ParserCB.entities.cbrf_reference.Srvcs;
import com.opencode.ParserCB.entities.cbrf_reference.XchType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "participant_info")
@Getter
@Setter
@NoArgsConstructor
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_info_id")
    private int participantInfoID;

    private String name;

    private String endName;

    private String cntrCd;

    private int rgn;

    private String ind;

    private String tnp;

    private String nnp;

    private String adr;

    private Date dateIn;

    private Date dateOut;

    private String uid;

    private int prntBic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rstr_list_id")
    private RstrList rstrList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pt_type_id")
    private PtType ptType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "xch_list_id")
    private XchType xchType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "srvcs_id")
    private Srvcs srvcs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_status_id")
    private ParticipantInfo participantInfo;

}
