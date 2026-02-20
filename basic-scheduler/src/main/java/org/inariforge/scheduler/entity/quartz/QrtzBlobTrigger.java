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
 * Quartz Blob Trigger 詳細資訊.
 * 對應資料表: qrtz_blob_triggers
 */
@Data
@Entity
@Immutable
@IdClass(QuartzTriggerKey.class)
@Table(name = "qrtz_blob_triggers")
@Schema(description = "Quartz Blob 觸發器定義")
public class QrtzBlobTrigger {

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

    @Lob
    @Column(name = "blob_data")
    @Schema(description = "自訂觸發器資料 (BLOB)")
    private byte[] blobData;
}
