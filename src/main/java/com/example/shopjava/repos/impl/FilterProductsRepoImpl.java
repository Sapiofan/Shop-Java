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
                String[] arr1 = query.split(" ");
                String[] arr2 = Arrays.copyOfRange(arr1, 0, arr1.length - 1);
                query = String.join(" ", arr2) + " and";
            }
        }
        if(init.equals(query)){
            query = "select p from Phone p";
        }
        else {
            String[] arr1 = query.split(" ");
            String[] arr2 = Arrays.copyOfRange(arr1, 0, arr1.length - 1);
            query = String.join(" ", arr2);
        }
        log.info(query);

        return entityManager.createQuery(query).getResultList();
    }
}
