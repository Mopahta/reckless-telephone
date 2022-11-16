package by.mopahta.recklesstelephone.controller;

import by.mopahta.recklesstelephone.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final WorkerService workerService;

    public IndexController (WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("")
    private String index(Model model) {
        model.addAttribute("workers", workerService.getWorkers());
        return "index";
    }
}
