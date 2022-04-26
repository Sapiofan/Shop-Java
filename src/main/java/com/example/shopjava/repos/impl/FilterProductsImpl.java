package com.example.shopjava.repos.impl;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.repos.FilterProducts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FilterProductsImpl implements FilterProducts {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Phone> filterPhones(Set<String> series, Set<String> built_in_memory) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> query = cb.createQuery(Phone.class);
        Root<Phone> phone = query.from(Phone.class);

        Path<String> seriesPath = phone.get("series");
        Path<String> builtMemoryPath = phone.get("built_in_memory");

        List<Predicate> predicatesSeries = new ArrayList<>();
        for (String s : series) {
            predicatesSeries.add(cb.like(seriesPath, s));
        }

        List<Predicate> predicatesBuiltMemory = new ArrayList<>();
        for (String m : built_in_memory) {
            predicatesBuiltMemory.add(cb.like(builtMemoryPath, m));
        }

        Predicate seriesP = cb.or(predicatesSeries.toArray(new Predicate[predicatesSeries.size()]));

        Predicate BuiltMemoryP = cb.or(predicatesBuiltMemory.toArray(new Predicate[predicatesSeries.size()]));

        Predicate finalPredicate = cb.and(seriesP, BuiltMemoryP);

        query.select(phone)
                .where(finalPredicate);

        return entityManager.createQuery(query)
                .getResultList();
    }
}
