package com.example.shopjava.repos.impl;

import com.example.shopjava.entities.product.Laptop;
import com.example.shopjava.entities.product.Phone;
import com.example.shopjava.entities.product.Watch;
import com.example.shopjava.repos.FilterProductsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class FilterProductsRepoImpl implements FilterProductsRepo {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger("log");

    @Override
    public List<Phone> filterPhones(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max) {
        String query = generateQuery("Phone", filters, fullFilters, min, max);
        log.info(query);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Laptop> filterLaptops(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max) {
        String query = generateQuery("Laptop", filters, fullFilters, min, max);
        log.info(query);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Watch> filterWatches(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max) {
        String query = generateQuery("Watch", filters, fullFilters, min, max);
        log.info(query);

        return entityManager.createQuery(query).getResultList();
    }

    private String generateQuery(String table, Set<String> filters, Map<String, List<String>> fullFilters,
                                 Integer min, Integer max) {
        String temp, init, query = init = temp = "select p from " + table + " p where (p.price between " + min + " and " + max + ") and (";
        if (filters != null) {
            for (Map.Entry<String, List<String>> entry : fullFilters.entrySet()) {
                List<String> list = entry.getValue();
                Collections.replaceAll(list, "Yes", "true");
                String key = entry.getKey().toLowerCase().replace('-', '_');
                key = key.replace(' ', '_');
                for (String filter : filters) {
                    for (String s : list) {
                        if (filter.equals(s)) {
                            query += " p." + key + "='" + filter + "' or";
                        }
                    }
                }
                if (!init.equals(query) && !temp.equals(query)) {
                    String[] arr1 = query.split(" ");
                    String[] arr2 = Arrays.copyOfRange(arr1, 0, arr1.length - 1);
                    query = String.join(" ", arr2) + ") and (";
                    temp = query;
                }
                Collections.replaceAll(list, "true", "Yes");
            }
        }
        if (init.equals(query)) {
            query = "select p from " + table + " p where p.price between " + min + " and " + max;
        } else {
            String[] arr1 = query.split(" ");
            String[] arr2 = Arrays.copyOfRange(arr1, 0, arr1.length - 2);
            query = String.join(" ", arr2);
        }
        return query;
    }
}
