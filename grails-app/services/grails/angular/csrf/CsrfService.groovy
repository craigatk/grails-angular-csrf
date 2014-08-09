package grails.angular.csrf

import org.codehaus.groovy.grails.commons.GrailsClass

class CsrfService {
    static transactional = false

    def grailsApplication

    boolean isApiController(String controllerName) {
        GrailsClass controllerClass = grailsApplication.getArtefactByLogicalPropertyName('Controller', controllerName)

        boolean apiController = controllerClass?.packageName?.endsWith('.api')

        return apiController
    }
}
