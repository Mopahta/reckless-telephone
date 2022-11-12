package by.mopahta.recklesstelephone.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class WorkingPlaceKey implements Serializable {
    @Column(name = "phone_id")
    private Long phoneId;

    @Column(name = "worker_id")
    private Long workerId;
}
