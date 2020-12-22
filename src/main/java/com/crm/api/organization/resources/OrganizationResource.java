package com.crm.api.organization.resources;

import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationFilter;
import com.crm.api.organization.services.OrganizationService;
import com.crm.commun.exceptions.WebException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import com.crm.commun.results.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController(value = "/api/api-back-organization")
public class OrganizationResource {

	@Autowired
	OrganizationService organizationService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Organization> get(@PathVariable Long id)  throws WebException {
		return new Response(organizationService.get(id));
	}
	@PostMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public PaginResponse<Organization> find(@RequestBody RequestFilter filter)  throws WebException {
		return new PaginResponse(organizationService.find(filter));
	}
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Organization> create(@RequestBody Organization form)  throws WebException {
		return new Response(organizationService.create(form));
	}
	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Organization> update(@RequestBody Organization form)  throws WebException {
		return new Response(organizationService.update(form));
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Response<Organization> delete(@PathVariable Long id)  throws WebException {
		organizationService.delete(id);
		return new Response("deleted");
	}

}
