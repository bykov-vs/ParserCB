package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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
@JacksonXmlRootElement(localName = "ED807")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ed807 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ed_id")
    private int edId;

    @JacksonXmlProperty(localName = "xmlns", isAttribute = true)
    private String xmlns;

    @JacksonXmlProperty(localName = "EDNo", isAttribute = true)
    private String edNo;

    @JacksonXmlProperty(localName = "EDDate", isAttribute = true)
    @Temporal(TemporalType.DATE)
    private Date edDate;

    @JacksonXmlProperty(localName = "EDAuthor", isAttribute = true)
    private String edAuthor;

    @JacksonXmlProperty(localName = "CreationDateTime", isAttribute = true)
    private LocalDateTime creationDateTime;

    @JacksonXmlProperty(localName = "BusinessDay", isAttribute = true)
    @Temporal(TemporalType.DATE)
    private Date businessDay;

    @JacksonXmlProperty(localName = "DirectoryVersion", isAttribute = true)
    private int directoryVersion;

    @JacksonXmlProperty(localName = "EDReceiver", isAttribute = true)
    private int edReceiver;

    @JacksonXmlProperty(localName = "CreationReason", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creation_reason_id")
    private CreationReason creationReason;

    @JacksonXmlProperty(localName = "InfoTypeCode", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_type_code_id")
    private InfoTypeCode infoTypeCode;

    @Transient
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BICDirectoryEntry")
    private ArrayList<BicDirectoryEntry> bicDirectoryEntries = new ArrayList<>();
}
