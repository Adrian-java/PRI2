angular.module('clinic').service 'Documents', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  create = (doc) ->
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/document'
      data: doc
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  checkExistance = (visitID) ->
    request = $http(
      method: 'GET'
      url: api + 'documents/exist/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  addPrescription = (prescriptionData) ->
    console.log prescriptionData
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'documents/new/prescription'
      data: prescriptionData
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  addCertificate = (certificateData) ->
    console.log certificateData
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

  getPrescriptionData = (visitId) ->
    request = $http(
      method: 'GET'
      url: api + 'documents/prescription/data/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  getCertificateData = (visitId) ->
    request = $http(
      method: 'GET'
      url: api + 'documents/certificate/data/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  getReferralData = (visitId) ->
    request = $http(
      method: 'GET'
      url: api + 'documents/referral/data/' + visitId
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
    )
    return request

  getPrescription = (visitId) ->
    $http(
      method: 'GET'
      url: api + 'documents/prescription/' + visitId
      responseType: 'arraybuffer'
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
      ).success (data) ->
        file = new Blob([ data ], type: 'application/pdf')
        fileURL = URL.createObjectURL(file)
        window.open fileURL
      return

  getCertificate = (visitId) ->
    $http(
      method: 'GET'
      url: api + 'documents/certificate/' + visitId
      responseType: 'arraybuffer'
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
      ).success (data) ->
        file = new Blob([ data ], type: 'application/pdf')
        fileURL = URL.createObjectURL(file)
        window.open fileURL
      return

  getReferral = (visitId) ->
    $http(
      method: 'GET'
      url: api + 'documents/certificate/' + visitId
      responseType: 'arraybuffer'
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json'
      ).success (data) ->
        file = new Blob([ data ], type: 'application/pdf')
        fileURL = URL.createObjectURL(file)
        window.open fileURL
      return

  {
    create: create
    checkExistance: checkExistance
    addPrescription: addPrescription
    addCertificate: addCertificate
    addReferral: addReferral
    getPrescriptionData: getPrescriptionData
    getCertificateData: getCertificateData
    getReferralData: getReferralData
    getPrescription: getPrescription
    getCertificate: getCertificate
    getReferral: getReferral
  }
]
