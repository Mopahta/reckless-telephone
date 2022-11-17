package com.mopahta.recklesstelephone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentInfoDTO {
    private String department;

    private List<WorkerInfoDTO> workers;

    private List<String> numbers;
}
