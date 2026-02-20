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
 * Quartz Simple Trigger 詳細資訊.
 * 對應資料表: qrtz_simple_triggers
 */
@Data
@Entity
@Immutable
@IdClass(QuartzTriggerKey.class)
@Table(name = "qrtz_simple_triggers")
@Schema(description = "Quartz Simple 觸發器定義")
public class QrtzSimpleTrigger {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱")
    private String schedName;

    @Id
    @Column(name = "trigger_name")
    @Schema(description = "觸發器名稱")
    private String triggerName;

    @Id
    @Column(name = "trigger_group")
    @Schema(description = "觸發器群組")
    private String triggerGroup;

    @Column(name = "repeat_count")
    @Schema(description = "重複次數 (-1 為無限)")
    private Long repeatCount;

    @Column(name = "repeat_interval")
    @Schema(description = "重複間隔 (ms)")
    private Long repeatInterval;

    @Column(name = "times_triggered")
    @Schema(description = "已觸發次數")
    private Long timesTriggered;
}
