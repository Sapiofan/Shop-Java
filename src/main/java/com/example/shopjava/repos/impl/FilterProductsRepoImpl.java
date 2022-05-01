package com.example.shopjava.repos.impl;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;
import com.example.shopjava.repos.FilterProductsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

@Repository
public class FilterProductsRepoImpl implements FilterProductsRepo {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger("log");

    @Override
    public List<Phone> filterPhones(Set<String> filters, Map<String, List<String>> fullFilters) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Phone> query = cb.createQuery(Phone.class);
//        Root<Phone> phone = query.from(Phone.class);
//
//        Path<String> seriesPath = phone.get("series");
//        Path<String> builtMemoryPath = phone.get("built_in_memory");
//
//        List<Predicate> predicatesSeries = new ArrayList<>();
//        for (String s : filters) {
//            predicatesSeries.add(cb.like(seriesPath, s));
//        }
//
//        List<Predicate> predicatesBuiltMemory = new ArrayList<>();
//        for (String m : filters) {
//            predicatesBuiltMemory.add(cb.like(builtMemoryPath, m));
//        }
//
//        Predicate seriesP = cb.or(predicatesSeries.toArray(new Predicate[predicatesSeries.size()]));
//
//        Predicate BuiltMemoryP = cb.or(predicatesBuiltMemory.toArray(new Predicate[predicatesSeries.size()]));
//
//        Predicate finalPredicate = cb.and(seriesP, BuiltMemoryP);
//
//        query.select(phone)
//                .where(finalPredicate);



        String init, query = init = "select p from Phone p where";
        for(Map.Entry<String, List<String>> entry : fullFilters.entrySet()){
            List<String> list = entry.getValue();
            String key = entry.getKey().toLowerCase().replace('-','_');
            key = key.replace(' ','_');
            for (String filter : filters) {
                for (String s : list) {
                    if(filter.equals(s)){
                        query += " p." + key + "='" + filter + "' or";
                    }
                }
            }
            if(!init.equals(query)) {
                query = query.substring(0, query.length() - 2) + " and";
            }
        }
        if(init.equals(query)){
            query = "select p from Phone p";
        }
        else {
            query = query.substring(0, query.length() - 5);
        }
        log.info(query);

        return (List<Phone>) entityManager.createQuery(query).getResultList();
    }
}
