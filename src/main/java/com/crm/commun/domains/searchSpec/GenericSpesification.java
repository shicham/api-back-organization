package com.crm.commun.domains.searchSpec;
import com.crm.commun.domains.searchSpec.Ord;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import com.crm.commun.tools.StringTools;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
/**
 * Project Name     : dynamic-where
 * Date Time        : 22/12/2020
 *
 * @author sass.hicham@gmail.com
 */

public class GenericSpesification<T> implements Specification<T> {

    private static final long serialVersionUID = 1900581010229669687L;

    private List<SearchCriteria> list;
    private List<Ord> orders = new ArrayList<Ord>();
    public GenericSpesification() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }
    public void addOrder(List<Ord> list) {
        orders.addAll(list);
    }
    public void add(List<SearchCriteria> criteriaList) {
        list.addAll(criteriaList);
    }
  private Sort.Direction getSortDirection(String direction) {
    if (direction.equals("asc")) {
      return Sort.Direction.ASC;
    } else if (direction.equals("desc")) {
      return Sort.Direction.DESC;
    }

    return Sort.Direction.ASC;
  }
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        //create a new predicate list
        List<Predicate> predicates = new ArrayList<>();

        //add add criteria to predicates
        for (SearchCriteria criteria : list) {
            
            if(StringTools.isEmpty(criteria.getValue()) && StringTools.isEmpty(criteria.getValues())){
                
            }else if (criteria.getOperation().equals(SearchOperation.IN)) {
                System.out.println("--"+criteria.getValues());
                predicates.add(root.get(criteria.getKey()).in(criteria.getValues()));
            }else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(builder.greaterThan(
                root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(builder.lessThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            }
        }
        Collection<javax.persistence.criteria.Order> criteriaOrders = new ArrayList<>();
        if (this.orders != null) {
            System.out.println("222");
            for(Ord order : this.orders){
               if ("ASC".equals(order.getDirection())) {
                    System.out.println("888");
                    criteriaOrders.add(builder.asc(root.get(order.getProperty())));
                } else {
                   System.out.println("111");
                    criteriaOrders.add(builder.desc(root.get(order.getProperty())));
                }
            }
            query.orderBy(criteriaOrders.toArray(new javax.persistence.criteria.Order[0]));
           
        }
        
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
