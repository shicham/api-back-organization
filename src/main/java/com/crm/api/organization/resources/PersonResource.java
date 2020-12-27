package com.crm.api.organization.resources;

import com.crm.api.organization.forms.Person;
import com.crm.api.organization.services.PersonService;
import com.crm.commun.exceptions.WebException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import com.crm.commun.results.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    @Autowired
    PersonService personService;

    /**
     * get
     *
     * @param id
     * @return
     * @throws WebException
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response<Person> get(@PathVariable Long id) throws WebException {
        return new Response(personService.get(id));
    }

    /**
     * find
     *
     * @param filter
     * @return
     * @throws WebException
     */
    @PostMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PaginResponse<Person> find(@RequestBody RequestFilter filter) throws WebException {
        return personService.find(filter);
    }

    /**
     * create
     *
     * @param form
     * @return
     * @throws WebException
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response<Person> create(@RequestBody Person form) throws WebException {
        return new Response(personService.create(form));
    }

    /**
     * update
     *
     * @param form
     * @param id
     * @return
     * @throws WebException
     */
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response<Person> update(@RequestBody Person form, @PathVariable Long id) throws WebException {
        return new Response(personService.update(form, id));
    }

    /**
     * delete
     *
     * @param id
     * @return
     * @throws WebException
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Response<Person> delete(@PathVariable Long id) throws WebException {
        personService.delete(id);
        return new Response("deleted");
    }

}