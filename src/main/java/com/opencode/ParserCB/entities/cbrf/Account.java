package com.opencode.ParserCB.entities.cbrf;

import com.opencode.ParserCB.entities.cbrf_reference.AccountStatus;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    private String account;

    private String ck;

    private String accCbrbic;

    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bic_directory_entry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regulation_account_type_id")
    private RegulationAccountType regulationAccountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_rstr_list_id")
    private AccRstrList accRstrList;
}
