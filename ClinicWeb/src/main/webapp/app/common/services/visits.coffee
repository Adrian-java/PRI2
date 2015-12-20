angular.module('clinic').service 'Visits', [ '$http', '$cookies', 'api', ($http, $cookies, api) ->

  indexByDate = (startDate, endDate) ->
    console.log 'dates'
    console.log startDate
    console.log endDate
    request = $http(
      method: 'GET'
      url: api + 'Visit/all/date/'+startDate+'/'+endDate
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    return request

  check = ->
    login = $cookies.token.split(":")[0]
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/role/'+login
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (visit) ->
    console.log visit
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'Visit/new/'
      data: visit
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  show = (visitId) ->
    request = $http(
      method: 'GET'
      url: api + 'Visit/info/' + visitId
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json'
    )
    return request

  remove = (visitId) ->
    console.log 'visit id: ' + visitId
    request = $http(
      method: 'DELETE'
      url: api + 'Visit/' + visitId
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    return request

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    console.log response.data
    console.log 'visit added'

  {
    create: create
    remove: remove
    show: show
    indexByDate: indexByDate
  }
]
