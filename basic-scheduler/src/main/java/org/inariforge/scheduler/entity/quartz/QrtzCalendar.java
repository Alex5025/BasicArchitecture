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
 * Quartz Calendar 行事曆定義.
 * 對應資料表: qrtz_calendars
 */
@Data
@Entity
@Immutable
@IdClass(QuartzCalendarKey.class)
@Table(name = "qrtz_calendars")
@Schema(description = "Quartz 行事曆定義")
public class QrtzCalendar {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱")
    private String schedName;

    @Id
    @Column(name = "calendar_name")
    @Schema(description = "行事曆名稱")
    private String calendarName;

    @Lob
    @Column(name = "calendar")
    @Schema(description = "序列化的行事曆物件 (BLOB)")
    private byte[] calendar;
}
