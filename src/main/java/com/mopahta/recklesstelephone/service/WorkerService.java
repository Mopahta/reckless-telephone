package com.mopahta.recklesstelephone.service;

import com.mopahta.recklesstelephone.dto.WorkerInfoDTO;
import com.mopahta.recklesstelephone.model.Worker;
import com.mopahta.recklesstelephone.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<WorkerInfoDTO> getWorkersDTO(List<Worker> workers) {
        return workers.stream().map(x ->
                new WorkerInfoDTO(
                        x.getWorkerName(), x.getJobTitle(), x.getWorkingMail()))
                .collect(Collectors.toList());
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }


}
