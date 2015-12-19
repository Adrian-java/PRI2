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

  edit = (id, patient) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'SystemUser/updatePatient/' + id
      data: patient
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json'
    )
    return request

  remove = (id) ->
    console.log id
    request = $http(
      method: 'DELETE'
      url: api + 'SystemUser/patient/' + id
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
    edit: edit
    remove: remove
  }
]
