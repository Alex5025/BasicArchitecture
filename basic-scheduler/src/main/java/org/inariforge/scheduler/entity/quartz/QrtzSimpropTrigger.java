package org.inariforge.scheduler.entity.quartz;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.annotations.Immutable;

/**
 * Quartz SimProp Trigger 詳細資訊.
 * 對應資料表: qrtz_simprop_triggers
 */
@Data
@Entity
@Immutable
@IdClass(QuartzTriggerKey.class)
@Table(name = "qrtz_simprop_triggers")
@Schema(description = "Quartz 屬性觸發器定義")
public class QrtzSimpropTrigger {

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

    @Column(name = "str_prop_1")
    @Schema(description = "字串屬性 1")
    private String strProp1;

    @Column(name = "str_prop_2")
    @Schema(description = "字串屬性 2")
    private String strProp2;

    @Column(name = "str_prop_3")
    @Schema(description = "字串屬性 3")
    private String strProp3;

    @Column(name = "int_prop_1")
    @Schema(description = "整數屬性 1")
    private Integer intProp1;

    @Column(name = "int_prop_2")
    @Schema(description = "整數屬性 2")
    private Integer intProp2;

    @Column(name = "long_prop_1")
    @Schema(description = "長整數屬性 1")
    private Long longProp1;

    @Column(name = "long_prop_2")
    @Schema(description = "長整數屬性 2")
    private Long longProp2;

    @Column(name = "dec_prop_1")
    @Schema(description = "十進位屬性 1")
    private BigDecimal decProp1;

    @Column(name = "dec_prop_2")
    @Schema(description = "十進位屬性 2")
    private BigDecimal decProp2;

    @Column(name = "bool_prop_1")
    @Schema(description = "布林屬性 1")
    private Boolean boolProp1;

    @Column(name = "bool_prop_2")
    @Schema(description = "布林屬性 2")
    private Boolean boolProp2;
}
