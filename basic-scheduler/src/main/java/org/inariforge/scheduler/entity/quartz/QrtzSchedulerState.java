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
 * Quartz 排程器實例狀態 (Cluster Heartbeat).
 * 對應資料表: qrtz_scheduler_state
 */
@Data
@Entity
@Immutable
@IdClass(QuartzSchedulerStateKey.class)
@Table(name = "qrtz_scheduler_state")
@Schema(description = "Quartz 排程器實例狀態")
public class QrtzSchedulerState {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱")
    private String schedName;

    @Id
    @Column(name = "instance_name")
    @Schema(description = "實例 ID")
    private String instanceName;

    @Column(name = "last_checkin_time")
    @Schema(description = "上次 Heartbeat 時間")
    private Long lastCheckinTime;

    @Column(name = "checkin_interval")
    @Schema(description = "Heartbeat 間隔 (ms)")
    private Long checkinInterval;
}
