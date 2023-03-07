package com.xnaraassessment.currencyconversionservice.repository;

import com.xnaraassessment.currencyconversionservice.entities.CurrencyRate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    boolean exists (Specification whereSpec);

    Optional<CurrencyRate> findByCurrencyCode(String target_code);
}
