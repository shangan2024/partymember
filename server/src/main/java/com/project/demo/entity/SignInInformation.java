package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 签到信息：(SignInInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SignInInformation")
public class SignInInformation implements Serializable {

    // SignInInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sign_in_information_id")
    private Integer sign_in_information_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 党课主题
    @Basic
    private String party_lesson_theme;
    // 党课类型
    @Basic
    private String type_of_party_courses;
    // 党课日期
    @Basic
    private Timestamp party_class_date;
    // 签到时间
    @Basic
    private Timestamp sign_in_time;
    // 签到照片
    @Basic
    private String sign_in_photo;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
