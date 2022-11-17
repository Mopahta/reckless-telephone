package com.mopahta.recklesstelephone.service;

import com.mopahta.recklesstelephone.dto.DepartmentInfoDTO;
import com.mopahta.recklesstelephone.dto.SearchInfoDTO;
import com.mopahta.recklesstelephone.model.Department;
import com.mopahta.recklesstelephone.repository.DepartmentRepository;
import com.mopahta.recklesstelephone.repository.impl.SearchRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final WorkerService workerService;
    private final PhoneNumberService phoneNumberService;
    private final SearchRepositoryImpl searchRepository;

    public List<DepartmentInfoDTO> getDepartmentsDTO (List<Department> departments, boolean getPrivateNumbers) {
        List<DepartmentInfoDTO> dtos;

        dtos = departments.stream().map(x ->
                new DepartmentInfoDTO(x.getDepName(), workerService.getWorkersDTO(x.getWorkers()),
                phoneNumberService.getAvailablePhoneNumbers(x.getPhoneNumbers(), getPrivateNumbers)))
                .collect(Collectors.toList());

        return dtos;
    }

    @EntityGraph(attributePaths = {"phoneNumbers", "workers"})
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public List<Department> getDepartmentsWithSearchInfo(SearchInfoDTO searchInfoDTO, boolean getPrivateNumbers) {
        searchInfoDTO.trimFields();
        System.out.println(searchRepository.findAll(searchInfoDTO.getFullname(), searchInfoDTO.getNumber(),
                searchInfoDTO.getMail(), searchInfoDTO.getPosition(), searchInfoDTO.getDepartment(), getPrivateNumbers)
        );
        return searchRepository.findAll(searchInfoDTO.getFullname(), searchInfoDTO.getNumber(),
                searchInfoDTO.getMail(), searchInfoDTO.getPosition(), searchInfoDTO.getDepartment(), getPrivateNumbers);
    }
}
