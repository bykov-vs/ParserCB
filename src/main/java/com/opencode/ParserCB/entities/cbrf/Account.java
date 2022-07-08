package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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

    @JacksonXmlProperty(localName = "Account", isAttribute = true)
    private String account;

    @JacksonXmlProperty(localName = "CK", isAttribute = true)
    private String ck;

    @JacksonXmlProperty(localName = "AccountCBRBIC", isAttribute = true)
    private String accCbrbic;

    @JacksonXmlProperty(localName = "DateIn", isAttribute = true)
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @JacksonXmlProperty(localName = "DateOut", isAttribute = true)
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bic_directory_entry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    @JacksonXmlProperty(localName = "AccountStatus", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @JacksonXmlProperty(localName = "RegulationAccountType", isAttribute = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regulation_account_type_id")
    private RegulationAccountType regulationAccountType;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "AccRstrList")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_rstr_list_id")
    private AccRstrList accRstrList;
}
