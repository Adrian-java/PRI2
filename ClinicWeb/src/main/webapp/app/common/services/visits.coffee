angular.module('clinic').service 'Visits', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  indexByDate = (startDate, endDate) ->
    console.log 'dates'
    console.log startDate
    console.log endDate
    request = $http(
      method: 'GET'
      url: api + 'Visit/all/date/'+startDate+'/'+endDate
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  check = ->
    login = $cookies.token.split(":")[0]
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/role/'+login
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (visit) ->
    console.log visit
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'Visit/new/'
      data: visit
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  show = (visitId) ->
    request = $http(
      method: 'GET'
      url: api + 'Visit/info/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  showDone = (id) ->
    request = $http(
      method: 'GET'
      url: api + 'Visit/patient/done/' + id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  showPlanned = (id) ->
    request = $http(
      method: 'GET'
      url: api + 'Visit/patient/plane/' + id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  remove = (visitId) ->
    console.log 'visit id: ' + visitId
    request = $http(
      method: 'DELETE'
      url: api + 'Visit/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
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
    showDone: showDone
    showPlanned: showPlanned
    indexByDate: indexByDate
  }
]
