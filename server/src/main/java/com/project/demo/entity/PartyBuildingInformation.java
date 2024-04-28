package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 党建资讯：(PartyBuildingInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PartyBuildingInformation")
public class PartyBuildingInformation implements Serializable {

    // PartyBuildingInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_building_information_id")
    private Integer party_building_information_id;

    // 资讯标题
    @Basic
    private String information_title;
    // 资讯类型
    @Basic
    private String information_type;
    // 管理者姓名
    @Basic
    private Integer manager_name;
    // 发布日期
    @Basic
    private Timestamp release_date;
    // 资讯详情
    @Basic
    private String information_details;
    // 资讯封面
    @Basic
    private String information_cover;
    // 资讯附件
    @Basic
    private String information_attachment;

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
