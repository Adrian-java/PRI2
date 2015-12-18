angular.module('clinic').service 'Patients', [ '$http', '$cookies', 'api', ($http, $cookies, api) ->

  index = ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/patients/all'
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  show = (id) ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/patient/'+id
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    return request

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    response.data
    console.log 'doctor added'

  {
    index: index
    show: show
  }
]
