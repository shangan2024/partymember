package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 普通用户：(OrdinaryUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OrdinaryUsers")
public class OrdinaryUsers implements Serializable {

    // OrdinaryUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordinary_users_id")
    private Integer ordinary_users_id;

    // 学号
    @Basic
    private String student_id;
    // 姓名
    @Basic
    private String full_name;
    // 年级班级
    @Basic
    private String grade_class;
    // 政治面貌
    @Basic
    private String political_outlook;
    // 院别
    @Basic
    private String hospital;



    // 审核状态
    @Basic
    private String examine_state;









    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
