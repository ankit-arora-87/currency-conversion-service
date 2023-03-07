package com.xnaraassessment.currencyconversionservice.specification;

import com.xnaraassessment.currencyconversionservice.entities.CurrencyRate;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class CurrencyConversionSpecification {

//    public static Specification<User> betweenSalaryRange(Double minSalary, Double maxSalary) {
//        return new Specification<User>() {
//            @Override
//            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Predicate salaryPredicate = cb.between(root.get("salary"), minSalary, maxSalary-1);
//                return salaryPredicate;
//            }
//        };
//    }

    public static Specification<CurrencyRate> currencyWithBase(String currencyCode, Integer isBase) {
        return new Specification<CurrencyRate>() {
            @Override
            public Predicate toPredicate(Root<CurrencyRate> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate currencyCodePredicate = cb.equal(root.get("currencyCode"),currencyCode);
                Predicate isBasePredicate = cb.equal(root.get("isBase"), isBase);
                return cb.and(currencyCodePredicate, isBasePredicate);
            }
        };
    }




}
