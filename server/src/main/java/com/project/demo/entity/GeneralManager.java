package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 普通管理者：(GeneralManager)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "GeneralManager")
public class GeneralManager implements Serializable {

    // GeneralManager编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "general_manager_id")
    private Integer general_manager_id;

    // 学号
    @Basic
    private String student_id;
    // 管理者姓名
    @Basic
    private String manager_name;
    // 届数
    @Basic
    private String number_of_sessions;
    // 年级班级
    @Basic
    private String grade_class;
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
