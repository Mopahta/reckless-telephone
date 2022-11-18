package com.mopahta.recklesstelephone.service;

import com.mopahta.recklesstelephone.dto.DepartmentInfoDTO;
import com.mopahta.recklesstelephone.dto.SearchInfoDTO;
import com.mopahta.recklesstelephone.dto.WorkerInfoDTO;
import com.mopahta.recklesstelephone.model.QueriedDetails;
import com.mopahta.recklesstelephone.repository.impl.SearchRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final DepartmentService departmentService;
    private final SearchRepositoryImpl searchRepository;

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

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
                            .filter(distinctByKey(QueriedDetails::getWorkerName))
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

        return departments;
    }


}
