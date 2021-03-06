angular.module 'clinic'
  .service 'Specialities', ['$http', 'api', ($http, api) ->
    # Return public API.
    # ---
    # PUBLIC METHODS.
    # ---
    # I add a friend with the given name to the remote collection.
    getSpecialities = ->
      request = $http(
        method: 'GET'
        url: api + 'Specialization/list')
      return request

    # ---
    # PRIVATE METHODS.
    # ---
    # I transform the error response, unwrapping the application dta from
    # the API response payload.

    handleError = (response) ->
      # The API response from the server should be returned in a
      # nomralized format. However, if the request was not handled by the
      # server (or what not handles properly - ex. server error), then we
      # may have to normalize it on our end, as best we can.
      if !angular.isObject(response.data) or !response.data.message
        console.log 'An unknown error occurred.'
        #return $q.reject('An unknown error occurred.')
      # Otherwise, use expected error message.
      #$q.reject response.data.message

    # I transform the successful response, unwrapping the application data
    # from the API response payload.

    handleSuccess = (response) ->
      console.log response.data
      response.data

    {
      getSpecialities: getSpecialities
    }
  ]
