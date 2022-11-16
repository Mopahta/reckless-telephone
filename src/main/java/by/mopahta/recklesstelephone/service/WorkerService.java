package by.mopahta.recklesstelephone.service;

import by.mopahta.recklesstelephone.model.Worker;
import by.mopahta.recklesstelephone.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }
}
