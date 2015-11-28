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

    userInfo =
      'id': user.pin
      'password': user.password
      'patient':
        'name': user.firstName
        'surname': user.lastName
        'dateOfBirth': user.birthDate.day+'-'+user.birthDate.monthId+'-'+user.birthDate.year
        'phoneNr': user.phone
        'address':
          'city': user.city
          'countryCode': user.countyCode
          'province': user.province
          'country': user.country
          'countryCodeCity': user.countyCode
          'homeNr': user.home_nr
      'email': user.email

    request = $http(
      method: 'POST'
      isArray: false
      url: 'http://localhost:8080/rest/SystemUser/newPatient"'
      data: userInfo
      #headers: 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8')
      headers: 'XToken': $cookies.get('token'), 'Content-Type': 'application/json')
    request.then handleSuccess, handleError



  ###
  $scope.addUser = function(user){
		var userInfo = {
				"id": user.pesel,
				"password": user.password,
					"patient": {
						"name": user.first_name,
						"surname": user.last_name,
						"dateOfBirth": user.birth_date,
						"phoneNr": user.phone,
						"address": {
							"city": user.city,
							"countryCode": user.county_code,
							"province": user.province,
							"country": user.country,
							"countryCodeCity": user.county_code,
							"homeNr": user.home_nr,
						}
					},
				"email": user.email
			};
		console.log(userInfo);
		$http({
			method: 'POST',
			url: "http://localhost:9000/rest/SystemUser/newPatient",
			data: userInfo,
			headers: {'XToken': $cookies.get('token'), 'Content-Type': 'application/json'}
		}).success(function(result){
			console.log("user added");
			console.log(result);
  ###


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
  }
]
