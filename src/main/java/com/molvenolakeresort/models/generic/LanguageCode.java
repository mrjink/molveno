package com.molvenolakeresort.models.generic;

import javax.persistence.*;
import java.util.Locale;

@Entity(name="Languagecode")
@Table(name="languagecode", uniqueConstraints = @UniqueConstraint(columnNames = { "locale", "language" }))
public class LanguageCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String locale;
    private String language;

    public LanguageCode() {}
    public LanguageCode(String locale, String language)
    {
        this.locale = locale;
        this.language = language;
    }
    public LanguageCode(Locale locale)
    {
        this.locale = locale.toString();
        this.language = locale.getLanguage();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
