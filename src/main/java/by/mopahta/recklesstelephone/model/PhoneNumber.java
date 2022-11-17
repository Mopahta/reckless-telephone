package by.mopahta.recklesstelephone.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "phone_numbers", schema = "telephonebook_db")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String number;

    private boolean isPublic = false;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;
}
