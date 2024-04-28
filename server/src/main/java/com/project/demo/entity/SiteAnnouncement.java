package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 站点公告：(SiteAnnouncement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SiteAnnouncement")
public class SiteAnnouncement implements Serializable {

    // SiteAnnouncement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_announcement_id")
    private Integer site_announcement_id;

    // 公告标题
    @Basic
    private String announcement_title;
    // 发布时间
    @Basic
    private Timestamp release_time;
    // 管理者姓名
    @Basic
    private Integer manager_name;
    // 公告详情
    @Basic
    private String announcement_details;
    // 公告封面
    @Basic
    private String announcement_cover;
    // 公告附件
    @Basic
    private String announcement_attachment;

    // 点击数
    @Basic
    private Integer hits;













    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
