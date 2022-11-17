package by.mopahta.recklesstelephone.controller;

import by.mopahta.recklesstelephone.dto.DepartmentInfoDTO;
import by.mopahta.recklesstelephone.repository.DepartmentRepository;
import by.mopahta.recklesstelephone.service.DepartmentService;
import by.mopahta.recklesstelephone.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

    private final DepartmentService departmentService;

    @GetMapping("")
    private String index(Model model) {
        model.addAttribute("departments", departmentService.getDepartmentsDTO(
                departmentService.getDepartments(), false
        ));
        return "index";
    }

    @GetMapping("private")
    private String privateNumbers(Model model) {
        model.addAttribute("departments", departmentService.getDepartmentsDTO(
                departmentService.getDepartments(), true)
        );
        return "index";
    }
}
