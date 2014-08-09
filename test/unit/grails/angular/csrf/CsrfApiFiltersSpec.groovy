package grails.angular.csrf

import grails.angular.csrf.api.PersonController
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([CsrfFilters, CsrfService, Person])
@TestFor(PersonController)
class CsrfApiFiltersSpec extends Specification {
    void 'when token valid should return 200'() {
        setup:
        defineBeans {
            csrfService(CsrfApiService)
        }

        session['csrfToken'] = 'validToken'

        request.addHeader('X-Csrf-Token', 'validToken')

        when:
        withFilters(controller: "*", action: "*") {
            controller.index()
        }

        then:
        assert response.status == 200
    }

    void 'when token not valid should return error code'() {
        setup:
        defineBeans {
            csrfService(CsrfApiService)
        }

        session['csrfToken'] = 'validToken'

        request.addHeader('X-Csrf-Token', 'invalidToken')

        when:
        withFilters(controller: "*", action: "*") {
            controller.index()
        }

        then:
        assert response.status == 401
    }
}

class CsrfApiService extends CsrfService {
    @Override
    boolean isApiController(String controllerName) {
        return true
    }
}