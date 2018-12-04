package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.LanguageCode;
import com.molvenolakeresort.models.generic.LanguageString;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageCodeRepository extends JpaRepository<LanguageCode, Long> {
}
