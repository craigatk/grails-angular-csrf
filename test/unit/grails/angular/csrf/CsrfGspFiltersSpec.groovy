package grails.angular.csrf

import grails.angular.csrf.api.PersonController
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([CsrfFilters, CsrfService])
@TestFor(HomeController)
class CsrfGspFiltersSpec extends Specification {
    void 'should add token to session'() {
        setup:
        defineBeans {
            csrfService(CsrfNonApiService)
        }

        when:
        withFilters(controller: "*", action: "*") {
            controller.index()
        }

        then:
        assert session['csrfToken']?.length() >= 16
    }
}

class CsrfNonApiService extends CsrfService {
    @Override
    boolean isApiController(String controllerName) {
        return false
    }
}