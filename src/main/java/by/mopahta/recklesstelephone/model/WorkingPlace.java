package by.mopahta.recklesstelephone.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class WorkingPlace {
    @EmbeddedId
    WorkingPlaceKey id;

    @ManyToOne
    @MapsId("phoneId")
    @JoinColumn(name ="phone_id")
    PhoneNumber phoneNumber;

    @ManyToOne
    @MapsId("workerId")
    @JoinColumn(name ="worker_id")
    Worker worker;

    @NonNull
    String workingPlace;
}
