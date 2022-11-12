package by.ToshibaMastr.FormulaSolver.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormulaSolverService {

    Float calculateFormula(String string);

}
