package grails.angular.csrf.api

import grails.angular.csrf.Person
import grails.rest.RestfulController

class PersonController extends RestfulController {
    static responseFormats = ['json']

    PersonController() {
        super(Person)
    }
}
