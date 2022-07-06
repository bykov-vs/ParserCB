package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "srvcs")
@Getter
@Setter
@NoArgsConstructor
public class Srvcs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "srvcs_id")
    private int srvcsId;

    @Embedded
    private Info info;
}
