package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 请假信息：(LeaveInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "LeaveInformation")
public class LeaveInformation implements Serializable {

    // LeaveInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_information_id")
    private Integer leave_information_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 党课主题
    @Basic
    private String party_lesson_theme;
    // 党课日期
    @Basic
    private Timestamp party_class_date;
    // 请假原因
    @Basic
    private String reason_for_leave;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
