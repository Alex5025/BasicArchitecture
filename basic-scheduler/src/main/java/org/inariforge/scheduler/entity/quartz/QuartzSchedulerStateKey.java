package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Quartz 排程器狀態複合主鍵.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Quartz 排程器狀態複合主鍵")
public class QuartzSchedulerStateKey implements Serializable {
    @Schema(description = "排程器名稱")
    private String schedName;
    @Schema(description = "實例名稱")
    private String instanceName;
}
