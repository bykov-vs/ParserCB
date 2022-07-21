package com.opencode.ParserCB.entities.cbrf_reference;

import lombok.*;

import javax.persistence.*;


@Data
@MappedSuperclass
@NoArgsConstructor
public class Handbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected int id;

    @Column
    protected @NonNull String code;

    @Column(length = 1000)
    protected @NonNull String name;

    public Handbook(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Handbook(String code) {
        this.code = code;
    }
}
