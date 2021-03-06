package one.digitalinnovation.personapimaven.controller;


import lombok.AllArgsConstructor;
import one.digitalinnovation.personapimaven.dto.request.PersonDTO;
import one.digitalinnovation.personapimaven.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapimaven.entity.Person;
import one.digitalinnovation.personapimaven.exeception.PersonNotFoundExeception;
import one.digitalinnovation.personapimaven.repository.PersonRepository;
import one.digitalinnovation.personapimaven.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired) )
public class PersonController {


    private PersonService personService;


    @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findByID(@PathVariable Long id) throws PersonNotFoundExeception {
        return personService.findByID(id);

    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundExeception {
        return personService.updateById(id, personDTO);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundExeception {
        personService.delete(id);


    }

}






