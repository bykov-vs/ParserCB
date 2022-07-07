package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.opencode.ParserCB.entities.cbrf_reference.CreationReason;
import com.opencode.ParserCB.entities.cbrf_reference.InfoTypeCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @JsonProperty("EDNo")
    private String edNo;

    @JsonProperty("EDDate")
    @Temporal(TemporalType.DATE)
    private Date edDate;

    @JsonProperty("EDAuthor")
    private String edAuthor;

    @JsonProperty("CreationDateTime")
    private LocalDateTime creationDateTime;

    @JsonProperty("BusinessDay")
    @Temporal(TemporalType.DATE)
    private Date businessDay;

    @JsonProperty("DirectoryVersion")
    private int directoryVersion;

    private int edReceiver;

    @JsonProperty("CreationReason")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creation_reason_id")
    private CreationReason creationReason;

    @JsonProperty("InfoTypeCode")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_type_code_id")
    private InfoTypeCode infoTypeCode;

    @Transient
    @JacksonXmlElementWrapper(localName="BICDirectoryEntry")
    private ArrayList<BicDirectoryEntry> bicDirectoryEntries = new ArrayList<>();

}
