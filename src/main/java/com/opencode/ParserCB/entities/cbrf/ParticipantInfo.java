package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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
@JsonIgnoreProperties(ignoreUnknown=true)
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_info_id")
    private int participantInfoID;

    @JacksonXmlProperty(localName = "NameP", isAttribute = true)
    private String nameP;

    @JacksonXmlProperty(localName = "EndName", isAttribute = true)
    private String endName;

    @JacksonXmlProperty(localName = "CntrCd", isAttribute = true)
    private String cntrCd;

    @JacksonXmlProperty(localName = "Rgn", isAttribute = true)
    private int rgn;

    @JacksonXmlProperty(localName = "Ind", isAttribute = true)
    private String ind;

    @JacksonXmlProperty(localName = "Tnp", isAttribute = true)
    private String tnp;

    @JacksonXmlProperty(localName = "Nnp", isAttribute = true)
    private String nnp;

    @JacksonXmlProperty(localName = "Adr", isAttribute = true)
    private String adr;

    @JacksonXmlProperty(localName = "DateIn", isAttribute = true)
    private Date dateIn;

    @JacksonXmlProperty(localName = "DateOut", isAttribute = true)
    private Date dateOut;

    @JacksonXmlProperty(localName = "UID", isAttribute = true)
    private String uid;

    @JacksonXmlProperty(localName = "PrntBic", isAttribute = true)
    private int prntBic;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "RstrList")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rstr_list_id")
    private RstrList rstrList;

    @JacksonXmlProperty(localName = "PtType", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pt_type_id")
    private PtType ptType;

    @JacksonXmlProperty(localName = "XchType", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "xch_list_id")
    private XchType xchType;

    @JacksonXmlProperty(localName = "Srvcs", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "srvcs_id")
    private Srvcs srvcs;

    @JacksonXmlProperty(localName = "ParticipantStatus", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_status_id")
    private ParticipantStatus participantStatus;
}
