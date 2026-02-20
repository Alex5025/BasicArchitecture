package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Quartz Calendar 複合主鍵.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Quartz 行事曆複合主鍵")
public class QuartzCalendarKey implements Serializable {
    @Schema(description = "排程器名稱")
    private String schedName;
    @Schema(description = "行事曆名稱")
    private String calendarName;
}
