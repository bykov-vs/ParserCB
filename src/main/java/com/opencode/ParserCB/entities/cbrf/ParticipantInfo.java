package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencode.ParserCB.entities.cbrf_reference.ParticipantStatus;
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

    @JsonProperty("NameP")
    private String nameP;

    @JsonProperty("EndName")
    private String endName;

    @JsonProperty("CntrCd")
    private String cntrCd;

    @JsonProperty("Rgn")
    private int rgn;

    @JsonProperty("Ind")
    private String ind;

    @JsonProperty("Tnp")
    private String tnp;

    @JsonProperty("Nnp")
    private String nnp;

    @JsonProperty("Adr")
    private String adr;

    @JsonProperty("DateIn")
    private Date dateIn;

    @JsonProperty("DateOut")
    private Date dateOut;

    @JsonProperty("UID")
    private String uid;

    @JsonProperty("PrntBic")
    private int prntBic;

    @JsonProperty("RstrList")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rstr_list_id")
    private RstrList rstrList;

    @JsonProperty("PtType")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pt_type_id")
    private PtType ptType;

    @JsonProperty("XchType")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "xch_list_id")
    private XchType xchType;

    @JsonProperty("Srvcs")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "srvcs_id")
    private Srvcs srvcs;

    @JsonProperty("ParticipantStatus")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_status_id")
    private ParticipantStatus participantStatus;

}
