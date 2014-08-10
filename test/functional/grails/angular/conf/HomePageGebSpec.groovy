package grails.angular.conf

import geb.spock.GebReportingSpec
import grails.angular.csrf.Person
import grails.plugin.remotecontrol.RemoteControl

class HomePageGebSpec extends GebReportingSpec {
    RemoteControl remote

    def setup() {
        remote = new RemoteControl()
    }

    def 'should list people on home page'() {
        given:
        remote {
            new Person(firstName: 'Jim', lastName: 'Smith').save()

            return null
        }

        when:
        HomePage homePage = to(HomePage)

        then:
        waitFor { homePage.peopleNames == ['Jim Smith'] }
    }
}
