package com.crm.api.organization.resources;

import com.crm.api.organization.forms.*;
import com.crm.api.organization.services.OrganizationService;
import com.crm.commun.exceptions.WebException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import com.crm.commun.results.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organization")
public class OrganizationResource {

    @Autowired
    OrganizationService organizationService;


    /**
     * get
     *
     * @param id
     * @return
     * @throws WebException
     */
   
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public Response<Organization> get(@PathVariable Long id) throws WebException {
        return new Response(organizationService.get(id));
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
    public PaginResponse<Organization> find(@RequestBody RequestFilter filter) throws WebException {
        return organizationService.find(filter);
    }

    /**
     * childs
     *
     * @param filter
     * @return
     * @throws WebException
     */
    @PostMapping(value = "/childs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PaginResponse<OrganizationRel> childs(@RequestBody OrganizationRelFilter filter) throws WebException {
        return organizationService.childs(filter);
    }


    /**
     * childs
     *
     * @param filter
     * @return
     * @throws WebException
     */
    @PostMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PaginResponse<OrganizationPerson> persons(@RequestBody OrganizationPersonFilter filter) throws WebException {
        return organizationService.persons(filter);
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
    public Response<Organization> create(@RequestBody Organization form) throws WebException {
        return new Response(organizationService.create(form));
    }



    /**
     * create
     *
     * @param form
     * @return
     * @throws WebException
     */
    @PostMapping(value = "/{id}/person", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response<PersonCreate> addNewPerson(@PathVariable(name = "id") Long id, @RequestBody PersonCreate form) throws WebException {
        return new Response(organizationService.addNewPerson(form));
    }

    /**
     * add Organization
     *
     * @param form
     * @return
     * @throws WebException
     */
    @PostMapping(value = "/{id}/organization", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response<OrganizationCreate> addNewOrganization(@PathVariable(name = "id") Long id, @RequestBody OrganizationCreate form) throws WebException {
        return new Response(organizationService.addNewOrganization(form));
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
    public Response<Organization> update(@RequestBody Organization form, @PathVariable Long id) throws WebException {
        return new Response(organizationService.update(form, id));
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
    public Response<Organization> delete(@PathVariable Long id) throws WebException {
        organizationService.delete(id);
        return new Response("deleted");
    }
    
    @DeleteMapping(value = "/deletes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Response<Organization> deletes(@RequestBody Long[] ids) throws WebException {
        organizationService.delete(ids);
        return new Response("deleted");
    }

}
