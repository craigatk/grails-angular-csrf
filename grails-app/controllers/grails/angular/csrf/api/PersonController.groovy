package grails.angular.csrf.api

import grails.angular.csrf.Person
import grails.rest.RestfulController

class PersonController extends RestfulController {
    PersonController() {
        super(Person)
    }
}
