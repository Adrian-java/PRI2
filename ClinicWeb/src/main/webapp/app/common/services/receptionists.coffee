angular.module('clinic').service 'Receptionists', [ '$http', '$cookies', ($http, $cookies) ->

  index = ->
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/Receptionist/list"
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (receptionist) ->
    console.log $cookies.token
    request = $http(
      method: 'POST'
      isArray: false
      url: 'http://localhost:8080/rest/SystemUser/newReceptionist'
      data: receptionist
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  show = (id) ->
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/SystemUser/receptionist/"+id
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
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
  }
]
