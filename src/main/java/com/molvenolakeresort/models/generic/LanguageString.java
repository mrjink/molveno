package com.molvenolakeresort.models.generic;
import javax.persistence.*;

@Entity(name = "Languagestring")
@Table(name = "languagestring")
public class LanguageString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countrycode_id")
    private LanguageCode countryCode;
}

