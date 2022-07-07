package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("Account")
    private String account;

    @JsonProperty("ck")
    private String ck;

    @JsonProperty("AccountCBRBIC")
    private String accCbrbic;

    @JsonProperty("DateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @JsonProperty("DateOut")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bic_directory_entry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    @JsonProperty("AccountStatus")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @JsonProperty("RegulationAccountType")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regulation_account_type_id")
    private RegulationAccountType regulationAccountType;

    @JsonProperty("AccRstrList")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_rstr_list_id")
    private AccRstrList accRstrList;
}
