package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 党课信息：(PartyLessonInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PartyLessonInformation")
public class PartyLessonInformation implements Serializable {

    // PartyLessonInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_lesson_information_id")
    private Integer party_lesson_information_id;

    // 党课主题
    @Basic
    private String party_lesson_theme;
    // 党课类型
    @Basic
    private String type_of_party_courses;
    // 管理者姓名
    @Basic
    private Integer manager_name;
    // 党课日期
    @Basic
    private Timestamp party_class_date;
    // 党课详情
    @Basic
    private String party_class_details;
    // 备注
    @Basic
    private String remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
