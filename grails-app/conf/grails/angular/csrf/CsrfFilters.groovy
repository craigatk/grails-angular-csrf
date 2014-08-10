package grails.angular.csrf

class CsrfFilters {
    CsrfService csrfService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if (csrfService.isApiController(controllerName)) {
                    // Validate the token passed in when the request matches the token stored in the session
                    String validToken = session['csrfToken']

                    String tokenFromHeader = request.getHeader('X-Csrf-Token')

                    boolean tokenNotPresent = (!tokenFromHeader && !validToken)
                    boolean tokenNotValid = (tokenFromHeader != validToken)

                    if (tokenNotValid || tokenNotPresent) {
                        response.status = 401

                        return false
                    } else {
                        return true
                    }
                }
            }
            after = { Map model ->
                if (!csrfService.isApiController(controllerName) && model != null) {
                    // Generate token then add it to the session and model
                    String token = UUID.randomUUID().toString()

                    model.csrfToken = token

                    session['csrfToken'] = token
                }
            }
        }
    }
}
