package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 思想汇报：(Thought)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Thought")
public class Thought implements Serializable {

    // Thought编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thought_id")
    private Integer thought_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 标题
    @Basic
    private String title;
    // 思想汇报
    @Basic
    private String thought_report;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
