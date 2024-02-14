package com.okta.developer;

import com.okta.developer.entity.Employee;
import com.okta.developer.services.EmployeeServices;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ejb.LockType.READ;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

//@Lock(READ)
//@Singleton
//@Path("/good-beers")
public class BeerResource {
    private final BeerService beerService;

    private final EmployeeServices employeeServices;

    @Inject
    public BeerResource(BeerService beerService, EmployeeServices employeeServices) {
        this.beerService = beerService;
        this.employeeServices = employeeServices;
    }

    @GET
    @Produces({APPLICATION_JSON})
    public List<Beer> getGoodBeers() {
        return beerService.getAllBeers().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/info")
    @Produces({APPLICATION_JSON})
    public List<Employee> getEmployees() {
        return employeeServices.getAllEmployee();
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}

