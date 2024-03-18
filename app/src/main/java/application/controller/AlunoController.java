package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.model.Aluno;
import application.repository.AlunoRepository;

@RestController
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepo;
    
    @PostMapping("/alunos")
    public Aluno post(RequestBody Aluno aluno){
        return alunoRepo.save(aluno);
    }

}
