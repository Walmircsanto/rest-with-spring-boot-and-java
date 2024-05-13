package br.com.walmir.restwithspringbootandjava1.controller;

import br.com.walmir.restwithspringbootandjava1.model.PessoasEntity;
import br.com.walmir.restwithspringbootandjava1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping
    public ResponseEntity<PessoasEntity> save(@RequestBody PessoasEntity pessoasEntity){
      personService.save(pessoasEntity);
      return new ResponseEntity<>(  personService.save(pessoasEntity), HttpStatus.CREATED);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<PessoasEntity> findById(@PathVariable Long id){
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }


    @GetMapping(value = "/persons")
    public ResponseEntity<List<PessoasEntity>> findAll(){

        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PessoasEntity> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PessoasEntity> update(@RequestBody PessoasEntity pessoasEntity){
        personService.update(pessoasEntity);
        return ResponseEntity.ok().build();
    }
}
