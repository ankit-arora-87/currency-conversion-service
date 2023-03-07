package com.xnaraassessment.currencyconversionservice.repository;

import com.xnaraassessment.currencyconversionservice.entities.CurrencyProps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyPropsRepository extends JpaRepository<CurrencyProps, Long> {
    Optional<CurrencyProps> findByCurrencyCode(String target_code);
}
