package grails.angular.csrf

import grails.angular.csrf.api.PersonController
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@Mock([CsrfFilters, CsrfService, Person])
@TestFor(PersonController)
class CsrfApiFiltersSpec extends Specification {

    @Unroll
    void 'when token #requestHeaderToken should return #responseCode'() {
        setup:
        defineBeans {
            csrfService(CsrfApiService)
        }

        session['csrfToken'] = 'validToken'

        request.addHeader('X-Csrf-Token', requestHeaderToken)

        when:
        withFilters(controller: "*", action: "*") {
            controller.index()
        }

        then:
        assert response.status == responseCode

        where:
        requestHeaderToken || responseCode
        'validToken'       || 200
        'invalidToken'     || 401
    }
}

class CsrfApiService extends CsrfService {
    @Override
    boolean isApiController(String controllerName) {
        return true
    }
}