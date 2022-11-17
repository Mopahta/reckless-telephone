package com.mopahta.recklesstelephone.model;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "worker_name")
    private String workerName;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    private String workingMail;
    @NonNull
    @Column(name = "job_title")
    private String jobTitle;
}
