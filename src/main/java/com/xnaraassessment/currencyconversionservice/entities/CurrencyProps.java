package com.xnaraassessment.currencyconversionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencyprops")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyProps {

    @Id
    @Column(name = "cpid")
    private Long id;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "decimal_places")
    private Integer decimalPlaces;

    private String symbol;
}
