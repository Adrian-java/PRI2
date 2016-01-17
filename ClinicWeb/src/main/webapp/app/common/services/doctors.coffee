angular.module('clinic').service 'Doctors', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  index = ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/doctors/all'
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (doctor) ->
    console.log $cookies.token
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'SystemUser/newDoctor'
      data: doctor
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  show = (id) ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/doctor/'+id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  update = (id, doctor) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'SystemUser/updateDoctor/' + id
      data: doctor
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  indexBySpeciality = (speciality) ->
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/doctors/specialization/'+speciality
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  workingTime = (doctorId) ->
    request = $http(
      method: 'GET'
      url: api + 'VisitScheduler/doctor/'+doctorId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  takenVisitsTimeFrame = (doctorId, start, end) ->
    startDate = {}
    endDate = {}

    startDate.day = if start.getDate() < 10 then '0'+(start.getDate()) else start.getDate()
    startDate.month = if start.getMonth() < 10 then '0'+(start.getMonth()+1) else start.getMonth()+1
    startDate.year = start.getUTCFullYear()
    endDate.day = if end.getDate() < 10 then '0'+(end.getDate()) else end.getDate()
    endDate.month = if end.getMonth() < 10 then '0'+(end.getMonth()+1) else end.getMonth()+1
    endDate.year = end.getUTCFullYear()

    request = $http(
      method: 'GET'
      url: api + 'Visit/doctor/'+doctorId+"/date/"+startDate.day+"-"+startDate.month+"-"+startDate.year+"/"+endDate.day+"-"+endDate.month+"-"+endDate.year
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  indexDoctorsVisits = (doctorId, start, end) ->
    request = $http(
      method: 'GET'
      url: api + 'Visit/doctor/'+doctorId+'/date/'+start+'/'+end
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  remove = (id) ->
    console.log id
    request = $http(
      method: 'DELETE'
      url: api + 'SystemUser/doctor/' + id
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  addWorkingHours = (workingHours) ->
    console.log workingHours
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'VisitScheduler/scheduler/add'
      data: workingHours
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  getDoctorSpeciality = (doctorId) ->
    request = $http(
      method: 'GET'
      url: api + 'Specialization/doctor/' + doctorId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
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
    update: update
    indexBySpeciality: indexBySpeciality
    workingTime: workingTime
    takenVisitsTimeFrame: takenVisitsTimeFrame
    remove: remove
    addWorkingHours: addWorkingHours
    indexDoctorsVisits: indexDoctorsVisits
    getDoctorSpeciality: getDoctorSpeciality
  }
]
