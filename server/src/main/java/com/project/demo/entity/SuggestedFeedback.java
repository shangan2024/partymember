package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 建议反馈：(SuggestedFeedback)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SuggestedFeedback")
public class SuggestedFeedback implements Serializable {

    // SuggestedFeedback编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suggested_feedback_id")
    private Integer suggested_feedback_id;

    // 学号
    @Basic
    private Integer student_id;
    // 姓名
    @Basic
    private String full_name;
    // 提交时间
    @Basic
    private Timestamp submission_time;
    // 申请内容
    @Basic
    private String application_content;
    // 备注
    @Basic
    private String remarks;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
