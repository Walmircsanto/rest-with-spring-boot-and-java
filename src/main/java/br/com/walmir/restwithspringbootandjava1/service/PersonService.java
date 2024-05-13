package br.com.walmir.restwithspringbootandjava1.service;

import br.com.walmir.restwithspringbootandjava1.exceptions.ResourceNotFoundException;
import br.com.walmir.restwithspringbootandjava1.model.PessoasEntity;
import br.com.walmir.restwithspringbootandjava1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    public PessoasEntity save(PessoasEntity pessoasEntity){
       return personRepository.save(pessoasEntity);

    }

    public List<PessoasEntity> findAll(){
        return personRepository.findAll();
    }

    public PessoasEntity findById(Long id) throws ResourceNotFoundException {
        if(!personRepository.existsById(id)){

            throw new ResourceNotFoundException("Person with id " + id + " not found");
        }
        System.out.println(personRepository.findById(id).get());
        return personRepository.findById(id).get();
    }

    public PessoasEntity update(PessoasEntity pessoasEntity){
        if(findById(pessoasEntity.getId())!=null){
            personRepository.save(pessoasEntity);
        }
         return pessoasEntity;
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }
}
