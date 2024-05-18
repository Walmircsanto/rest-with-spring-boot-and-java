package br.com.walmir.restwithspringbootandjava1.service;

import br.com.walmir.restwithspringbootandjava1.data.vo.v2.PersonVOV2;
import br.com.walmir.restwithspringbootandjava1.exceptions.ResourceNotFoundException;
import br.com.walmir.restwithspringbootandjava1.data.vo.v1.PersonVO;
import br.com.walmir.restwithspringbootandjava1.mapper.DozerMapper;
import br.com.walmir.restwithspringbootandjava1.mapper.custom.PersonMapper;
import br.com.walmir.restwithspringbootandjava1.model.Person;
import br.com.walmir.restwithspringbootandjava1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    @Autowired
    private PersonMapper mapper;



    public PersonVO save(PersonVO personVO) {
        var entity = DozerMapper.parseObject(personVO, Person.class);
        personRepository.save(entity);
        return DozerMapper.parseObject(entity, PersonVO.class);
    }


    public PersonVOV2 saveV2(PersonVOV2 personVOV2) {
        var entity = mapper.convertVoToPerson(personVOV2);
        personRepository.save(entity);
        return mapper.convertEntityToVO(entity);
    }

    public List<PersonVO> findAll() {
        // Estou retornando uma lista de pessoas la do banco de dados e convertendo em personsVO para o client
        return DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) throws ResourceNotFoundException {
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO personVO) {
       var entity = personRepository.findById(personVO.getId())
               .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

       entity.setFirstName(personVO.getFirstName());
       entity.setLastName(personVO.getLastName());
       entity.setAddress(personVO.getAddress());
       entity.setGender(personVO.getGender());

       personRepository.save(entity);
       return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
