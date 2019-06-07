package com.sucu.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    /*
        URI versioning
     */
    @GetMapping(path = "v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    /*
        RequestParam versioning
     */
    @GetMapping(path = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    /*
        Header versioning
     */
    @GetMapping(path = "/person/header", headers = "X_API_VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X_API_VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    /*
        Accept Header versioning
     */
    @GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }


}
