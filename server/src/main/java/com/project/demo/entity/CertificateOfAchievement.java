package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 成绩证书：(CertificateOfAchievement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CertificateOfAchievement")
public class CertificateOfAchievement implements Serializable {

    // CertificateOfAchievement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_of_achievement_id")
    private Integer certificate_of_achievement_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 上传主题
    @Basic
    private String upload_topic;
    // 上传类型
    @Basic
    private String upload_type;
    // 获取时间
    @Basic
    private Timestamp get_time;
    // 上传图片
    @Basic
    private String upload_pictures;
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
