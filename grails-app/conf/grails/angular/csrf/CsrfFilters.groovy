package grails.angular.csrf

class CsrfFilters {
    CsrfService csrfService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if (csrfService.isApiController(controllerName)) {
                    // Verify token
                }
            }
            after = { Map model ->
                if (!csrfService.isApiController(controllerName)) {
                    // Generate token and add it to the model
                }
            }
        }
    }
}
