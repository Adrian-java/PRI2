angular.module('clinic').service 'Receptionists', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  index = ->
    request = $http(
      method: 'GET'
      url: api + 'Receptionist/list'
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (receptionist) ->
    console.log $cookies.token
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'SystemUser/newReceptionist'
      data: receptionist
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  show = (id) ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/receptionist/'+id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  edit = (id, receptionist) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'SystemUser/updateReceptionist/' + id
      data: receptionist
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  remove = (id) ->
    console.log id
    request = $http(
      method: 'DELETE'
      url: api + 'SystemUser/receptionist/' + id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    response.data
    console.log 'receptionists added'

  {
    index: index
    create: create
    show: show
    edit: edit
    remove: remove
  }
]
