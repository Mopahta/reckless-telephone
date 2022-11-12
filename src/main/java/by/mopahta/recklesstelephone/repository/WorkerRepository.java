package by.mopahta.recklesstelephone.repository;

import by.mopahta.recklesstelephone.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
