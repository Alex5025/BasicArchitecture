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
 * Quartz 已暫停的觸發器群組.
 * 對應資料表: qrtz_paused_trigger_grps
 */
@Data
@Entity
@Immutable
@IdClass(QuartzPausedTriggerGrpKey.class)
@Table(name = "qrtz_paused_trigger_grps")
@Schema(description = "Quartz 已暫停觸發器群組")
public class QrtzPausedTriggerGrp {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱")
    private String schedName;

    @Id
    @Column(name = "trigger_group")
    @Schema(description = "暫停的群組名稱")
    private String triggerGroup;
}
