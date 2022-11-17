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
@Table(name = "workers", schema = "telephonebook_db")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    private String workingMail;
    @NonNull
    private String position;
}
