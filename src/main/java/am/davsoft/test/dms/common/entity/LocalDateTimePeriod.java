package am.davsoft.test.dms.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 19, 2020
 * Time: 23:49
 */
@Embeddable
@Data
public class LocalDateTimePeriod {
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
