package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 心得体会：(Experience)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Experience")
public class Experience implements Serializable {

    // Experience编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private Integer experience_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 心得所属活动
    @Basic
    private String experience_activity;
    // 心得体会
    @Basic
    private String experience;
    // 提交时间
    @Basic
    private Timestamp submission_time;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
