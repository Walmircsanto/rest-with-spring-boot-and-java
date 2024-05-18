package br.com.walmir.restwithspringbootandjava1.mapper.custom;


import br.com.walmir.restwithspringbootandjava1.data.vo.v2.PersonVOV2;
import br.com.walmir.restwithspringbootandjava1.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVO(Person person) {
        PersonVOV2 personVO = new PersonVOV2();
        personVO.setId(person.getId());
        personVO.setBirthDay(new Date());
        personVO.setFirstName(person.getFirstName());
        personVO.setLastName(person.getLastName());
        personVO.setAddress(person.getAddress());
        personVO.setGender(person.getGender());

        return personVO;
    }
    public Person convertVoToPerson(PersonVOV2 personVOV2) {
        Person person = new Person();
        person.setId(personVOV2.getId());
        person.setFirstName(personVOV2.getFirstName());
        person.setLastName(personVOV2.getLastName());
        person.setAddress(personVOV2.getAddress());
        person.setGender(personVOV2.getGender());

        return person;

    }


}
