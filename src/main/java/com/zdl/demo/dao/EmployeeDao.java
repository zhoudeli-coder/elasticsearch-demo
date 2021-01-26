package com.zdl.demo.dao;

import com.zdl.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    void save(Employee employee);

    Optional<Employee> findById(String s);

    /**
     * NativeSearchQuery ：是springdata中的查询条件；
     * NativeSearchQueryBuilder ：用于建造一个NativeSearchQuery查询对象；
     * QueryBuilders ：设置查询条件，是ES中的类；
     * SortBuilders ：设置排序条件；
     * HighlightBuilder ：设置高亮显示；
     * @return
     */
    List<Employee> search();
}
