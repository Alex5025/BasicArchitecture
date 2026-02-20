package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Quartz 已暫停觸發器群組複合主鍵.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Quartz 暫停觸發器群組複合主鍵")
public class QuartzPausedTriggerGrpKey implements Serializable {
    @Schema(description = "排程器名稱")
    private String schedName;
    @Schema(description = "觸發器群組")
    private String triggerGroup;
}
