package by.ToshibaMastr.FormulaSolver.controllers;

import by.ToshibaMastr.FormulaSolver.services.FormulaSolverService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gui")
public class guiController {
    final static String MAIN_PAGE = "main";

    @Autowired
    private FormulaSolverService formulaSolverService;

    @GetMapping()
    public String homePage(Model model){
        return MAIN_PAGE;
    }
    @PostMapping()
    public String solve(@RequestParam("Formula") String string, Model model){
        model.addAttribute("output", string + " = " + formulaSolverService.calculateFormula(string));
        model.addAttribute("input", string);
        model.addAttribute("url", "/gui");
        return MAIN_PAGE;
    }
}
