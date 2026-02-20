package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

/**
 * Quartz 執行中觸發器狀態.
 * 對應資料表: qrtz_fired_triggers
 */
@Data
@Entity
@Immutable
@IdClass(QuartzFiredTriggerKey.class)
@Table(name = "qrtz_fired_triggers")
@Schema(description = "Quartz 執行中觸發器狀態")
public class QrtzFiredTrigger {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱")
    private String schedName;

    @Id
    @Column(name = "entry_id")
    @Schema(description = "執行實例 ID")
    private String entryId;

    @Column(name = "trigger_name")
    @Schema(description = "觸發器名稱")
    private String triggerName;

    @Column(name = "trigger_group")
    @Schema(description = "觸發器群組")
    private String triggerGroup;

    @Column(name = "instance_name")
    @Schema(description = "觸發執行的實例名稱")
    private String instanceName;

    @Column(name = "fired_time")
    @Schema(description = "實際觸發時間")
    private Long firedTime;

    @Column(name = "sched_time")
    @Schema(description = "預定觸發時間")
    private Long schedTime;

    @Column(name = "priority")
    @Schema(description = "優先級")
    private Integer priority;

    @Column(name = "state")
    @Schema(description = "狀態")
    private String state;

    @Column(name = "job_name")
    @Schema(description = "任務名稱")
    private String jobName;

    @Column(name = "job_group")
    @Schema(description = "任務群組")
    private String jobGroup;

    @Column(name = "is_nonconcurrent")
    @Schema(description = "是否非並發")
    private Boolean isNonconcurrent;

    @Column(name = "requests_recovery")
    @Schema(description = "是否要求恢復")
    private Boolean requestsRecovery;
}
