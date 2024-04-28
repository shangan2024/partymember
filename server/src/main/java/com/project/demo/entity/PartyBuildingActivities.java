package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 党建活动：(PartyBuildingActivities)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PartyBuildingActivities")
public class PartyBuildingActivities implements Serializable {

    // PartyBuildingActivities编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_building_activities_id")
    private Integer party_building_activities_id;

    // 活动名称
    @Basic
    private String activity_name;
    // 活动类型
    @Basic
    private String activity_type;
    // 管理者姓名
    @Basic
    private Integer manager_name;
    // 参加人员
    @Basic
    private String participants;
    // 活动日期
    @Basic
    private Timestamp activity_date;
    // 活动详情
    @Basic
    private String event_details;
    // 活动封面
    @Basic
    private String activity_cover;
    // 活动附件
    @Basic
    private String activity_attachment;

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
