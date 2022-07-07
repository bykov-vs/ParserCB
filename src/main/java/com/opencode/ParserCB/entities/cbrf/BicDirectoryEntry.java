package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.opencode.ParserCB.entities.cbrf_reference.ChangeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

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

    @JsonProperty("BIC")
    private String bic;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_info_id")
    @JacksonXmlElementWrapper(localName="ParticipantInfo")
    private ParticipantInfo participantInfo;

    @OneToOne
    @JoinColumn(name = "ed_id")
    private Ed807 ed;

    @JsonProperty("ChangeType")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "change_type_id")
    private ChangeType changeType;

    @Transient
    @JacksonXmlElementWrapper(localName="Accounts")
    private ArrayList<Account> accounts = new ArrayList<>();
}
