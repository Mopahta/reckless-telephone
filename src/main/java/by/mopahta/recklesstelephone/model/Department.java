package by.mopahta.recklesstelephone.model;

import lombok.*;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "departments", schema = "telephonebook_db")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "dep_id")
    private Long depId;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Worker> workers;

    @NonNull
    private String name;
}
