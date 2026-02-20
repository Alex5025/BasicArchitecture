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
 * Quartz 任務定義檔 (JobDetail).
 * 對應資料表: qrtz_job_details
 */
@Data
@Entity
@Immutable
@IdClass(QuartzJobKey.class)
@Table(name = "qrtz_job_details")
@Schema(description = "Quartz 任務定義")
public class QrtzJobDetail {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱", example = "quartzScheduler")
    private String schedName;

    @Id
    @Column(name = "job_name")
    @Schema(description = "任務名稱", example = "daily-report")
    private String jobName;

    @Id
    @Column(name = "job_group")
    @Schema(description = "任務群組", example = "DEFAULT")
    private String jobGroup;

    @Column(name = "description")
    @Schema(description = "任務描述")
    private String description;

    @Column(name = "job_class_name")
    @Schema(description = "任務執行類別全名", example = "org.inariforge.scheduler.job.HttpJob")
    private String jobClassName;

    @Column(name = "is_durable")
    @Schema(description = "是否持久化 (無 Trigger 是否保留)")
    private Boolean isDurable;

    @Column(name = "is_nonconcurrent")
    @Schema(description = "是否禁止並發執行")
    private Boolean isNonconcurrent;

    @Column(name = "is_update_data")
    @Schema(description = "是否更新 JobData")
    private Boolean isUpdateData;

    @Column(name = "requests_recovery")
    @Schema(description = "是否要求故障恢復 (機器重啟後重跑)")
    private Boolean requestsRecovery;

    @Lob
    @Column(name = "job_data")
    @Schema(description = "任務參數 (Serialized Map)")
    private byte[] jobData;
}
