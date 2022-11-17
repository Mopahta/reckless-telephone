package com.mopahta.recklesstelephone.controller;

import com.mopahta.recklesstelephone.dto.SearchInfoDTO;
import com.mopahta.recklesstelephone.service.DepartmentService;
import com.mopahta.recklesstelephone.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

    private final DepartmentService departmentService;
    private final SearchService searchService;

    @GetMapping("")
    private String index(SearchInfoDTO searchInfoDTO, Model model) {

        model.addAttribute("departments",
                searchService.searchForDepartments(searchInfoDTO, true));

//        model.addAttribute("departments", departmentService.getDepartmentsDTO(
//                departmentService.getDepartments(), false
//        ));
        return "index";
    }

    @GetMapping("private")
    private String privateNumbers(SearchInfoDTO searchInfoDTO, Model model) {
        model.addAttribute("departments", departmentService.getDepartmentsDTO(
                departmentService.getDepartments(), true)
        );
        return "index";
    }

    @GetMapping("error")
    private String error() {
        return "error";
    }
}
