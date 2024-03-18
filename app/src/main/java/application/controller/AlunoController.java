package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/alunos")
    public List<Aluno> alunos(){
        return(List<Aluno>) alunoRepo.findAll();
    }

    @SuppressWarnings("null")
    @PutMapping("/diretores/{id}")
    public Aluno putAluno(@RequestBody Aluno aluno, @PathVariable Long id){
        Aluno resposta = alunoRepo.findById(id).get();
        resposta.setNome(aluno.getNome());

        return alunoRepo.save(resposta);
    }
}
