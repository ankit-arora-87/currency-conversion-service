package com.xnaraassessment.currencyconversionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "currencyrate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {

    @Id
    @Column(name = "crid")
    private Long id;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "is_base")
    private Integer isBase;

    @Column(name = "rate_modifier")
    private Double rateModifier;

}
