angular.module('clinic').service 'Auth', [ '$http', '$cookies', ($http, $cookies) ->

  login = (user) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: 'http://localhost:8080/rest/auth/token'
      data: $.param(
        username: user.login
        password: user.password)
      headers: 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8')
    request.then handleLoginSuccess, handleError

  logout = ->
    $cookies.token = undefined
    console.log 'user logout success'

  register = (user) ->
    user.birthDate.monthId = if user.birthDate.monthId < 10 then '0' + user.birthDate.monthId else user.birthDate.monthId
    user.birthDate.day = if user.birthDate.day < 10 then '0' + user.birthDate.day else user.birthDate.day


    userInfo =
      'password': user.password
      'email': user.email
      'id': user.pin
      'patient':
        'name': user.firstName
        'surname': user.lastName
        'dateOfBirth': user.birthDate.year+'-'+user.birthDate.monthId+'-'+user.birthDate.day
        'phoneNr': user.phone
        'address':
          'city': user.city
          'countryCode': user.countyCode
          'province': user.province
          'country': user.country
          'countryCodeCity': user.countyCode
          'street': user.street
          'homeNr': user.home_nr

    request = $http(
      method: 'POST'
      isArray: false
      url: 'http://localhost:8080/rest/SystemUser/newPatient'
      data: userInfo
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  validate = ->
    if $cookies.token
      return $cookies.token.split(":")[0]
    else
      return false

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    console.log response.data
    response.data

  handleLoginSuccess = (response) ->
    $cookies.token = response.data.token

  {
    login: login
    logout: logout
    register: register
    validate: validate
  }
]
