package by.ToshibaMastr.FormulaSolver.controllers;

import by.ToshibaMastr.FormulaSolver.services.FormulaSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class rController {

    @Autowired
    private FormulaSolverService formulaSolverService;

    @GetMapping()
    public Float solve(@RequestParam("Formula") String string, Model model){
        return formulaSolverService.calculateFormula(string);
    }
}
