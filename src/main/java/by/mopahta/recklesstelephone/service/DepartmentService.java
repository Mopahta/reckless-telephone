package by.mopahta.recklesstelephone.service;

import by.mopahta.recklesstelephone.dto.DepartmentInfoDTO;
import by.mopahta.recklesstelephone.dto.WorkerInfoDTO;
import by.mopahta.recklesstelephone.model.Department;
import by.mopahta.recklesstelephone.repository.DepartmentRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final WorkerService workerService;
    private final PhoneNumberService phoneNumberService;

    public DepartmentService(DepartmentRepository departmentRepository, WorkerService workerService,
                             PhoneNumberService phoneNumberService) {
        this.departmentRepository = departmentRepository;
        this.workerService = workerService;
        this.phoneNumberService = phoneNumberService;
    }

    public List<DepartmentInfoDTO> getDepartmentsDTO(List<Department> departments, boolean getPrivateNumbers) {
        List<DepartmentInfoDTO> dtos;

        dtos =  departments.stream().map(x ->
                new DepartmentInfoDTO(x.getName(), workerService.getWorkersDTO(x.getWorkers()),
                phoneNumberService.getAvailablePhoneNumbers(x.getPhoneNumbers(), getPrivateNumbers)))
                .collect(Collectors.toList());

        return dtos;
    }

    @EntityGraph(attributePaths = {"phoneNumbers", "workers"})
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }
}
