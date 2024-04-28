package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 院系类别：(DepartmentCategory)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DepartmentCategory")
public class DepartmentCategory implements Serializable {

    // DepartmentCategory编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_category_id")
    private Integer department_category_id;

    // 院系类别
    @Basic
    private String department_category;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
