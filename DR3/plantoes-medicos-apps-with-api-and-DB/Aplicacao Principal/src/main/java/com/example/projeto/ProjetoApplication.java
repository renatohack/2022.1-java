package com.example.projeto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjetoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

/*    @Bean
    public CommandLineRunner manyToMany(IAlunoRepository alunoRepository){
        return (String[] args) -> {
            Aluno aluno = new Aluno("Breno", "21921212121");

            Endereco endereco = new Endereco("Senador", "Flamengo", "Rio", "RJ", "22222-000");
            aluno.setEndereco(endereco);

            List<Email> emails = new ArrayList<>();
            emails.add(new Email("raquel@gmail.com"));
            emails.add(new Email("renato@gmail.com"));
            aluno.setEmails(emails);

            List<Disciplina> disciplinas = new ArrayList<>();
            disciplinas.add(new Disciplina("002", "Java Web"));
            disciplinas.add(new Disciplina("001", "Java Nuvem"));
            aluno.setDisciplinas(disciplinas);

            alunoRepository.save(aluno);
            System.out.println("Aluno salvo");

            Aluno aluno2 = alunoRepository.findById(1).get();
            alunoRepository.delete(aluno2);
            System.out.println("Aluno excluido");
            System.exit(0);
        };
    }*/
}
