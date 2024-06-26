package br.com.walmir.restwithspringbootandjava1.repository;

import br.com.walmir.restwithspringbootandjava1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
