package com.opencode.ParserCB.entities.cbrf;

import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acc_rstr_list")
@Getter
@Setter
@NoArgsConstructor
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_rstr_list_id")
    private int accRstrListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_rstr_id", nullable = false)
    private AccRstr accRstr;

    @Temporal(TemporalType.DATE)
    private Date accRstrDate;

    private int successorBic;
}
