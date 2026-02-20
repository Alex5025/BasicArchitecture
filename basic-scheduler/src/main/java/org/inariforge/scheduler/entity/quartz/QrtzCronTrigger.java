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
 * Quartz Cron 觸發器詳細資訊 (CronTrigger).
 * 對應資料表: qrtz_cron_triggers
 */
@Data
@Entity
@Immutable
@IdClass(QuartzTriggerKey.class)
@Table(name = "qrtz_cron_triggers")
@Schema(description = "Quartz Cron 觸發器定義")
public class QrtzCronTrigger {

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

    @Column(name = "cron_expression")
    @Schema(description = "Cron 表達式", example = "0 0 12 * * ?")
    private String cronExpression;

    @Column(name = "time_zone_id")
    @Schema(description = "時區 ID", example = "Asia/Taipei")
    private String timeZoneId;
}
