package com.opencode.ParserCB.entities.cbrf;

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
public class BicDirectoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bic_directory_entry_id")
    private int bicDirectoryEntryId;

    private String bic;
/*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_info_id")
    private int participantInfoId;
*/
    @OneToOne
    @JoinColumn(name = "ed_id")
    private Ed807 ed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "change_type_id")
    private ChangeType changeType;
}
