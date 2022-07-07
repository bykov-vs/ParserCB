package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.opencode.ParserCB.entities.cbrf_reference.ChangeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bic_directory_entry")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class BicDirectoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bic_directory_entry_id")
    private int bicDirectoryEntryId;

    @JacksonXmlProperty(localName = "BIC", isAttribute = true)
    private String bic;

    @JacksonXmlProperty(localName = "ParticipantInfo")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_info_id")
    private ParticipantInfo participantInfoId;

    @OneToOne
    @JoinColumn(name = "ed_id")
    private Ed807 ed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "change_type_id")
    private ChangeType changeType;
}
