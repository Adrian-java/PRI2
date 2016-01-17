(function() {
  angular.module('clinic').service('Documents', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var addCertificate, addPrescription, addReferral, create, getCertificateData, getPrescription, getPrescriptionData;
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
        console.log(prescriptionData);
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
        console.log(certificateData);
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
      getPrescriptionData = function(visitId) {
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
      getCertificateData = function(visitId) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'documents/certificate/data/' + visitId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      getPrescription = function(visitId) {
        $http({
          method: 'GET',
          url: api + 'documents/prescription/' + visitId,
          responseType: 'arraybuffer',
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        }).success(function(data) {
          var file, fileURL;
          file = new Blob([data], {
            type: 'application/pdf'
          });
          fileURL = URL.createObjectURL(file);
          return window.open(fileURL);
        });
      };
      return {
        create: create,
        addPrescription: addPrescription,
        addCertificate: addCertificate,
        addReferral: addReferral,
        getPrescription: getPrescription,
        getCertificateData: getCertificateData
      };
    }
  ]);

}).call(this);
