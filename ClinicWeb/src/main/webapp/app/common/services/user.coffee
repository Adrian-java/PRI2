angular.module('clinic').service 'Auth', [ '$http', '$cookies', 'api', '$state', '$localStorage', ($http, $cookies, api, $state, $localStorage) ->

  login = (user) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'auth/token'
      data: $.param(
        username: user.login
        password: user.password)
      headers: 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8')
    request.then handleLoginSuccess, handleError

  logout = ->
    $localStorage.token = undefined
    console.log 'user logout success'
    $state.go('home')

  register = (user) ->
    user.birthDate.monthId = if Number(user.birthDate.monthId) < 10 then '0' + user.birthDate.monthId else user.birthDate.monthId
    user.birthDate.day = if Number(user.birthDate.day) < 10 then '0' + user.birthDate.day else user.birthDate.day

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
      url: api + 'SystemUser/newPatient'
      data: userInfo
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  validate = ->
    if $localStorage.token
      return $localStorage.token.split(":")[0]
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
    #$cookies.token = response.data.token
    $localStorage.token = response.data.token
    console.log $localStorage.token

  {
    login: login
    logout: logout
    register: register
    validate: validate
  }
]
