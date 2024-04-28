package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 党建通知：(PartyBuildingNotice)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PartyBuildingNotice")
public class PartyBuildingNotice implements Serializable {

    // PartyBuildingNotice编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_building_notice_id")
    private Integer party_building_notice_id;

    // 通知标题
    @Basic
    private String notification_title;
    // 通知类型
    @Basic
    private String notification_type;
    // 管理者姓名
    @Basic
    private Integer manager_name;
    // 通知详情
    @Basic
    private String notice_details;
    // 备注
    @Basic
    private String remarks;
    // 通知附件
    @Basic
    private String notice_attachment;
    // 通知封面
    @Basic
    private String notice_cover;

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
