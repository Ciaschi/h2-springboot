package it.ciaschi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.ciaschi.demo.PersonaRepository;
import it.ciaschi.demo.model.Persona;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/persona")
public class myController {
    @Autowired
    PersonaRepository pr;

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathParam("id") long id){
        return pr.findById(id).get();
    }

    @PostMapping
    public void addPersona(@RequestBody Persona p){
        pr.save(p);
    }

    @PutMapping("/modify/{id}")
    public Persona modifyPersona(@RequestBody Persona p, @PathVariable("id") long id){
        pr.deleteById(id);
        p.setId(id);
        return pr.save(p);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@RequestBody long id){
        pr.deleteById(id);
    }

    /*@GetMapping("/list")
    public List<Persona> getPerListByParam(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "surname", required = false) String surname,@RequestParam(name = "eta", required = false) Integer eta){
        if(name == null && surname == null && eta == null){
            return pr.findAll();
        }else if(name != null && surname == null && eta == null){
            return pr.findByName(name);
        }else if(name != null && surname != null && eta == null){
            return pr.findAll();
        }else if(name != null && surname == null && eta != null){
            return pr.findAll();
        }else if(name != null && surname != null && eta != null){
            return pr.findAll();
        }else if(name == null && surname != null && eta == null){
            return pr.findAll();
        }else if(name == null && surname == null && eta != null){
            return pr.findAll();
        }else if(name == null && surname != null && eta != null){
            return pr.findAll();
        }else if(name == null && surname == null && eta == null){
            return pr.findAll();
        }
    }*/
    public List<Persona> find(@RequestParam(name = "name") String name){
        return pr.findByNameContains(name);
    }
}
