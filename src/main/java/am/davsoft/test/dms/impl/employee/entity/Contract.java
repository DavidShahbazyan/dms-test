package am.davsoft.test.dms.impl.employee.entity;

import am.davsoft.test.dms.common.ContractType;
import am.davsoft.test.dms.common.entity.BaseEntity;
import am.davsoft.test.dms.common.entity.LocalDateTimePeriod;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 18, 2020
 * Time: 21:38
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "contracts")
public class Contract extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = false)
    private ContractType contractType;

    @Embedded
    private LocalDateTimePeriod period;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
}
