angular.module('clinic').service 'Doctors', [ '$http', '$cookies', ($http, $cookies) ->

  index = ->
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/SystemUser/doctors/all"
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
    return request

  create = (doctor) ->
    console.log $cookies.token
    request = $http(
      method: 'POST'
      isArray: false
      url: 'http://localhost:8080/rest/SystemUser/newDoctor'
      data: doctor
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  show = (id) ->
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/SystemUser/doctor/"+id
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    return request

  indexBySpeciality = (speciality) ->
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/SystemUser/doctors/specialization/"+speciality
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    return request

  workingTime = (doctorId) ->
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/VisitScheduler/doctor/"+doctorId
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
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
      url: "http://localhost:8080/rest/Visit/doctor/"+doctorId+"/date/"+startDate.day+"-"+startDate.month+"-"+startDate.year+"/"+endDate.day+"-"+endDate.month+"-"+endDate.year
      #url: "http://localhost:8080/rest/Visit/doctor/71120789123/date/01-01-2016/08-01-2016"
      #urL: "http://localhost:8080/rest/Visit/doctor/71120789123/03-01-2016/10-01-2016"
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
    create: create
    show: show
    indexBySpeciality: indexBySpeciality
    workingTime: workingTime
    takenVisitsTimeFrame: takenVisitsTimeFrame
  }
]
