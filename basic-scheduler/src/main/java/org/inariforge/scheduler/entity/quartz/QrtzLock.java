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
 * Quartz 分散式悲觀鎖.
 * 對應資料表: qrtz_locks
 */
@Data
@Entity
@Immutable
@IdClass(QuartzLockKey.class)
@Table(name = "qrtz_locks")
@Schema(description = "Quartz 分散式鎖")
public class QrtzLock {

    @Id
    @Column(name = "sched_name")
    @Schema(description = "排程器名稱")
    private String schedName;

    @Id
    @Column(name = "lock_name")
    @Schema(description = "鎖名稱")
    private String lockName;
}
