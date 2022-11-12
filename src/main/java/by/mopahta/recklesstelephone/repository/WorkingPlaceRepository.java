package by.mopahta.recklesstelephone.repository;

import by.mopahta.recklesstelephone.model.WorkingPlace;
import by.mopahta.recklesstelephone.model.WorkingPlaceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingPlaceRepository extends JpaRepository<WorkingPlace, WorkingPlaceKey> {
}
