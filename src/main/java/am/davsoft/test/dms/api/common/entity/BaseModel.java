package am.davsoft.test.dms.api.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 17, 2020
 * Time: 23:30
 */
@Data
public class BaseModel {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private LocalDateTime removed;
}
