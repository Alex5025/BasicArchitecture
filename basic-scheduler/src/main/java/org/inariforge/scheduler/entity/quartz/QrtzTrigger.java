package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

/**
 * Quartz 觸發器基礎資訊 (Trigger).
 * 對應資料表: qrtz_triggers
 */
@Data
@Entity
@Immutable
@IdClass(QuartzTriggerKey.class)
@Table(name = "qrtz_triggers")
@Schema(description = "Quartz 觸發器定義")
public class QrtzTrigger {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱", example = "quartzScheduler")
    private String schedName;

    @Id
    @Column(name = "trigger_name")
    @Schema(description = "觸發器名稱", example = "daily-report_trigger")
    private String triggerName;

    @Id
    @Column(name = "trigger_group")
    @Schema(description = "觸發器群組", example = "DEFAULT")
    private String triggerGroup;

    @Column(name = "job_name")
    @Schema(description = "關聯任務名稱")
    private String jobName;

    @Column(name = "job_group")
    @Schema(description = "關聯任務群組")
    private String jobGroup;

    @Column(name = "description")
    @Schema(description = "觸發器描述")
    private String description;

    @Column(name = "next_fire_time")
    @Schema(description = "下次執行時間 (Epoch ms)")
    private Long nextFireTime;

    @Column(name = "prev_fire_time")
    @Schema(description = "上次執行時間 (Epoch ms)")
    private Long prevFireTime;

    @Column(name = "priority")
    @Schema(description = "優先級")
    private Integer priority;

    @Column(name = "trigger_state")
    @Schema(description = "狀態 (WAITING, PAUSED, ACQUIRED, EXECUTING, ERROR, BLOCKED)",
            example = "WAITING")
    private String triggerState;

    @Column(name = "trigger_type")
    @Schema(description = "觸發器類型 (CRON, SIMPLE, etc.)", example = "CRON")
    private String triggerType;

    @Column(name = "start_time")
    @Schema(description = "開始時間 (Epoch ms)")
    private Long startTime;

    @Column(name = "end_time")
    @Schema(description = "結束時間 (Epoch ms)")
    private Long endTime;

    @Column(name = "calendar_name")
    @Schema(description = "行事曆名稱")
    private String calendarName;

    @Column(name = "misfire_instr")
    @Schema(description = "Misfire 策略代碼")
    private Integer misfireInstr;

    @Lob
    @Column(name = "job_data")
    @Schema(description = "觸發器參數")
    private byte[] jobData;
}
