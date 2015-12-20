(function() {
  angular.module('clinic').service('Documents', [
    '$http', '$cookies', 'api', function($http, $cookies, api) {
      var addCertificate, addPrescription, addReferral, create;
      create = function(doc) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'documents/new/document',
          data: doc,
          headers: {
            'XToken': $cookies.token,
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
            'XToken': $cookies.token,
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
            'XToken': $cookies.token,
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
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      return {
        create: create,
        addPrescription: addPrescription,
        addCertificate: addCertificate,
        addReferral: addReferral
      };
    }
  ]);

}).call(this);
