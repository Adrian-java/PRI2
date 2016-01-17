(function() {
  angular.module('clinic').service('Documents', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var addCertificate, addPrescription, addReferral, create, getPrescription;
      create = function(doc) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'documents/new/document',
          data: doc,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      addPrescription = function(prescriptionData) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'documents/new/prescription',
          data: prescriptionData,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      addCertificate = function(certificateData) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'documents/new/certificate',
          data: certificateData,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      addReferral = function(referralData) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'documents/new/referral',
          data: referralData,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      getPrescription = function(visitId) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'documents/prescription/data/' + visitId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      return {
        create: create,
        addPrescription: addPrescription,
        addCertificate: addCertificate,
        addReferral: addReferral,
        getPrescription: getPrescription
      };
    }
  ]);

}).call(this);
