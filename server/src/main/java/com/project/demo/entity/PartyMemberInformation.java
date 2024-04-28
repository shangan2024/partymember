package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 党员信息：(PartyMemberInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PartyMemberInformation")
public class PartyMemberInformation implements Serializable {

    // PartyMemberInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_member_information_id")
    private Integer party_member_information_id;

    // 学号
    @Basic
    private String student_id;
    // 姓名
    @Basic
    private String full_name;
    // 性别
    @Basic
    private String gender;
    // 年级班级
    @Basic
    private String grade_class;
    // 身份
    @Basic
    private String identity;
    // 院别
    @Basic
    private String hospital;
    // 个人头像
    @Basic
    private String personal_portrait;
    // 身份证号
    @Basic
    private String id_number;
    // 入党积极分子期数
    @Basic
    private String number_of_active_members_of_the_party;
    // 何时转为预备党员
    @Basic
    private String when_to_become_a_probationary_member;
    // 何时转为正式党员
    @Basic
    private String when_to_become_a_full_member;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
