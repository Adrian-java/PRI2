angular.module('clinic').service 'Documents', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  create = (doc) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/document'
      data: doc
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  addPrescription = (prescriptionData) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/prescription'
      data: prescriptionData
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  addCertificate = (certificateData) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/certificate'
      data: certificateData
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  addReferral = (referralData) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/referral'
      data: referralData
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  getPrescription = (visitId) ->
    request = $http(
      method: 'GET'
      url: api + 'documents/prescription/data/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  #indexPrescription = (visitId) ->
  #  request = $http(
  #    method: 'GET'
  #    url: api +
  #  )

  {
    create: create
    addPrescription: addPrescription
    addCertificate: addCertificate
    addReferral: addReferral
    getPrescription: getPrescription
  }
]
