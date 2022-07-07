package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("RstrDate")
    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    @JsonProperty("Rstr")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rstr_id")
    private Rstr rstr;
}
