angular.module('clinic').service 'Documents', [ '$http', '$cookies', 'api', ($http, $cookies, api) ->

  create = (doc) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/document'
      data: doc
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    return request

  addPrescription = (prescriptionData) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/prescription'
      data: prescriptionData
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json'
    )
    return request

  addCertificate = (certificateData) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/certificate'
      data: certificateData
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json'
    )
    return request

  addReferral = (referralData) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/referral'
      data: referralData
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json'
    )
    return request

  {
    create: create
    addPrescription: addPrescription
    addCertificate: addCertificate
    addReferral: addReferral
  }
]
