package com.sun.restFulApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,length = 20,nullable = false)
    private Long id;

    @NonNull
    @Column(columnDefinition = "varchar(50) comment '书名'")
    private String name;

    @NonNull
    @Column(columnDefinition = "varchar(20) comment '作者'")
    private String author;
    @NonNull
    @Column(columnDefinition = "varchar(100) comment '描述'")
    private String description;

    @NonNull
    @ColumnDefault("1")
    @Column(columnDefinition = "tinyint(1) comment B'是否存在'")
    @JsonIgnore//实力返回中不再有
    private Boolean status;
}
