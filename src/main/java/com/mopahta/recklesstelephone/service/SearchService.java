package com.mopahta.recklesstelephone.service;

import com.mopahta.recklesstelephone.dto.DepartmentInfoDTO;
import com.mopahta.recklesstelephone.dto.SearchInfoDTO;
import com.mopahta.recklesstelephone.dto.WorkerInfoDTO;
import com.mopahta.recklesstelephone.model.QueriedDetails;
import com.mopahta.recklesstelephone.repository.impl.SearchRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final DepartmentService departmentService;
    private final SearchRepositoryImpl searchRepository;

    public List<DepartmentInfoDTO> searchForDepartments(SearchInfoDTO searchInfo, boolean getPrivateNumbers) {
        searchInfo.trimFields();
        List<QueriedDetails> queriedDetails = searchRepository.findAll(
                searchInfo.getFullname(), searchInfo.getNumber(), searchInfo.getMail(),
                searchInfo.getPosition(), searchInfo.getDepartment());

        System.out.println(Arrays.toString(queriedDetails.toArray()));
        List<DepartmentInfoDTO> departments = new ArrayList<>();

        List<String> depNames = queriedDetails.stream().map(QueriedDetails::getDepName)
                .distinct().collect(Collectors.toList());

        for (String depName: depNames) {
            departments.add(new DepartmentInfoDTO(
                    depName,
                    queriedDetails.stream().filter(x -> x.getDepName().equals(depName))
                            .map(x -> new WorkerInfoDTO(x.getWorkerName(), x.getWorkingMail(), x.getJobTitle()))
                            .collect(Collectors.toList()),
                    queriedDetails.stream().filter(x -> x.getDepName().equals(depName))
                            .filter(x -> {
                                if (!getPrivateNumbers) {
                                    return x.isPublic();
                                }
                                return true;
                            })
                            .map(QueriedDetails::getNumber).distinct().collect(Collectors.toList())));
        }

//        String prevDepName = queriedDetails.get(0).getDepName();
//        for (int i = 0; i <= )
//        departments = queriedDetails.stream().map(
//                x -> new DepartmentInfoDTO(x.getDepName(),
//                        queriedDetails.stream().filter(y -> y.getDepName().equals(x.getDepName()))
//                                .map(t -> new WorkerInfoDTO(t.getName(), t.getWorkingMail(), t.getPosition()))
//                                .collect(Collectors.toList()),
//                        queriedDetails.stream().map(QueriedDetails::getNumber).collect(Collectors.toList())))
//                .collect(Collectors.toList());

        return departments;
    }


}
