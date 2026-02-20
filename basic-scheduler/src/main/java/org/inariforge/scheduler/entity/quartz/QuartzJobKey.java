package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Quartz JobDetail 複合主鍵.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Quartz 任務複合主鍵")
public class QuartzJobKey implements Serializable {
    @Schema(description = "排程器名稱")
    private String schedName;
    @Schema(description = "任務名稱")
    private String jobName;
    @Schema(description = "任務群組")
    private String jobGroup;
}
