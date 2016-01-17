angular.module('clinic').service 'Patients', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  index = ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/patients/all'
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (user) ->
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
    return request

  show = (id) ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/patient/'+id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  edit = (id, patient) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'SystemUser/updatePatient/' + id
      data: patient
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  remove = (id) ->
    console.log id
    request = $http(
      method: 'DELETE'
      url: api + 'SystemUser/patient/' + id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
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
    create: create
    show: show
    edit: edit
    remove: remove
  }
]
