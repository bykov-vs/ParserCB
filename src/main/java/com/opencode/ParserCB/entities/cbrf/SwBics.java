package com.opencode.ParserCB.entities.cbrf;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "swbics")
@Getter
@Setter
@NoArgsConstructor
public class SwBics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_type_id")
    private int changeTypeId;

    @JacksonXmlProperty(localName = "SWBIC", isAttribute = true)
    private String swBic;

    @JacksonXmlProperty(localName = "DefaultSWBIC", isAttribute = true)
    private int defaultSwBic;

    @OneToOne
    @JoinColumn(name = "bic_directory_entry_id")
    private BicDirectoryEntry bicDirectoryEntry;
}
