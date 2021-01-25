package com.zdl.demo.dao.impl;

import com.zdl.demo.dao.EmployeeDao;
import com.zdl.demo.dao.repository.EmployeeRepository;
import com.zdl.demo.entity.Employee;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(String s) {
        return employeeRepository.findById(s);
    }

    @Override
    public List<Employee> search() {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("age", "26");
        System.out.println("...");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.boolQuery()
//                        .should(boolQueryBuilder)
//                        .should(fuzzyQueryBuilder)
//                        .mustNot(QueryBuilders.termQuery("title", "潮头"))
                )
//                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
//                .withPageable(PageRequest.of(0, 50))
                .build();
        SearchHits<Employee> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Employee.class);
        return (List<Employee>) SearchHitSupport.unwrapSearchHits(searchHits);
    }
}
