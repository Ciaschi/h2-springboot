package it.ciaschi.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ciaschi.demo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    List<Persona> findByName(String name);
    List<Persona> findByNameContains(String name);
    List<Persona> findBySurname(String surname);
    List<Persona> findByAge(int age);
}