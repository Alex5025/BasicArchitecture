package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Quartz 執行中觸發器複合主鍵.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Quartz 執行中觸發器複合主鍵")
public class QuartzFiredTriggerKey implements Serializable {
    @Schema(description = "排程器名稱")
    private String schedName;
    @Schema(description = "執行項目 ID")
    private String entryId;
}
