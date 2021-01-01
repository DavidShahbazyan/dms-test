package am.davsoft.test.dms.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 13, 2020
 * Time: 15:43
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "removed")
    private LocalDateTime removed;

    public BaseEntity() {
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }
}
