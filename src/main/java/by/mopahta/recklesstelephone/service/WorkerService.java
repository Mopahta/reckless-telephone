package by.mopahta.recklesstelephone.service;

import by.mopahta.recklesstelephone.dto.WorkerInfoDTO;
import by.mopahta.recklesstelephone.model.Worker;
import by.mopahta.recklesstelephone.repository.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<WorkerInfoDTO> getWorkersDTO(List<Worker> workers) {
        return workers.stream().map(x ->
                new WorkerInfoDTO(
                        x.getName(), x.getSurname(), x.getPatronymic(), x.getPosition(), x.getWorkingMail()))
                .collect(Collectors.toList());
    }
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }


}
