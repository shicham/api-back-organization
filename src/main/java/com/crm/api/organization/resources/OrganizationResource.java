package com.crm.api.organization.resources;

import com.crm.api.organization.forms.Organization;
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
@RequestMapping("/api-back-organization")
public class OrganizationResource {

	@Autowired
	OrganizationService organizationService;

	/**
	 * get
	 * @param id
	 * @return
	 * @throws WebException
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Organization> get(@PathVariable Long id)  throws WebException {
		return new Response(organizationService.get(id));
	}

	/**
	 * find
	 * @param filter
	 * @return
	 * @throws WebException
	 */
	@PostMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public PaginResponse<Organization> find(@RequestBody RequestFilter filter)  throws WebException {
		return organizationService.find(filter);
	}

	/**
	 * create
	 * @param form
	 * @return
	 * @throws WebException
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Organization> create(@RequestBody Organization form)  throws WebException {
		return new Response(organizationService.create(form));
	}

	/**
	 * update
	 * @param form
	 * @param id
	 * @return
	 * @throws WebException
	 */
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Organization> update(@RequestBody Organization form, @PathVariable Long id)  throws WebException {
		return new Response(organizationService.update(form, id));
	}

	/**
	 * delete
	 * @param id
	 * @return
	 * @throws WebException
	 */
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Response<Organization> delete(@PathVariable Long id)  throws WebException {
		organizationService.delete(id);
		return new Response("deleted");
	}

}
