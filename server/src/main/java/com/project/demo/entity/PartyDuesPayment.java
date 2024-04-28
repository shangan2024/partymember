package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 党费缴交：(PartyDuesPayment)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PartyDuesPayment")
public class PartyDuesPayment implements Serializable {

    // PartyDuesPayment编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_dues_payment_id")
    private Integer party_dues_payment_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 日期
    @Basic
    private Timestamp date;
    // 需交党费
    @Basic
    private String party_fee_is_required;
    // 备注
    @Basic
    private String remarks;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;










    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
