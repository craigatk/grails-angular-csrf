package grails.angular.conf

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import spock.lang.Specification

class NoTokenApiFunctionalSpec extends Specification {
    void 'when calling person api without token should get 401 response'() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        RestResponse response = rest.get("http://localhost:8080/grails-angular-csrf/person/index") {
            accept JSON
        }

        then:
        assert response.status == 401
    }
}
