import grails.angular.csrf.Person

class BootStrap {

    def init = { servletContext ->
        // Uncomment to have a person loaded when running the app in dev mode
        //new Person(firstName: 'Jim', lastName: 'Sm/ith').save(failOnError: true)
    }
    def destroy = {
    }
}
