package com.opencode.ParserCB.entities.cbrf;

import com.opencode.ParserCB.entities.cbrf_reference.Rstr;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rstr_list")
@Getter
@Setter
@NoArgsConstructor
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rstr_list_id")
    private int rstrListId;

    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rstr_id")
    private Rstr rstr;
}
