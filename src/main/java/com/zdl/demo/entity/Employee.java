package com.zdl.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "company", replicas = 0, refreshInterval = "-1")
public class Employee {
    @Id
    private String id;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field
    private Integer age = 0;

    @Field
    private String about;
}
