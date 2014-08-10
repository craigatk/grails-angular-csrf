package grails.angular.conf

import geb.Page

class HomePage extends Page {
    static url = 'home'

    static content = {
        personNameListItems(wait: true) { $("#person_name_list li") }
    }

    List<String> getPeopleNames() {
        personNameListItems.collect { it.text().trim() }
    }
}
