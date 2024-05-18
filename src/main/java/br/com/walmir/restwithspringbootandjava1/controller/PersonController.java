package br.com.walmir.restwithspringbootandjava1.controller;

import br.com.walmir.restwithspringbootandjava1.data.vo.v1.PersonVO;
import br.com.walmir.restwithspringbootandjava1.data.vo.v2.PersonVOV2;
import br.com.walmir.restwithspringbootandjava1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping
    public ResponseEntity<PersonVO> save(@RequestBody PersonVO PersonVO){
      personService.save(PersonVO);
      return new ResponseEntity<>(  personService.save(PersonVO), HttpStatus.CREATED);
    }

    @PostMapping(value ="/v2")
    public ResponseEntity<PersonVOV2> saveV2(@RequestBody PersonVOV2 PersonVOV2){
      return new ResponseEntity<>(  personService.saveV2(PersonVOV2), HttpStatus.CREATED);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable Long id){
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }


    @GetMapping(value = "/persons")
    public ResponseEntity<List<PersonVO>> findAll(){

        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonVO> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PersonVO> update(@RequestBody PersonVO PersonVO){
        personService.update(PersonVO);
        return ResponseEntity.ok().build();
    }
}
