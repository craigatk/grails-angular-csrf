package grails.angular.csrf

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll

class CsrfServiceIntegrationSpec extends IntegrationSpec {
    CsrfService csrfService

    @Unroll
    def 'when controller is #controllerName should be api controller #expectedIsApiController'() {
        when:
        boolean isApiController = csrfService.isApiController(controllerName)

        then:
        assert isApiController == expectedIsApiController

        where:
        controllerName || expectedIsApiController
        'person'       || true
        'home'         || false
    }
}
