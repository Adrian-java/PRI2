(function() {
  angular.module('clinic').controller('DoctorVisitsController', [
    '$scope', 'Doctors', 'Auth', 'Visits', '$stateParams', 'Documents', function($scope, Doctors, Auth, Visits, $stateParams, Documents) {
      var afterTomorrow, checkVisitDocument, getAllVisitsByDate, getVisits, tomorrow;
      $scope.prescription = {};
      $scope.referral = {};
      $scope.certificate = {};
      $scope.today = function() {
        $scope.dt = new Date;
      };
      $scope.today();
      $scope.clear = function() {
        $scope.dt = null;
      };
      $scope.disabled = function(date, mode) {
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
      };
      $scope.toggleMin = function() {
        $scope.minDate = $scope.minDate ? null : new Date;
      };
      $scope.toggleMin();
      $scope.maxDate = new Date(2020, 5, 22);
      $scope.openStart = function($event) {
        $scope.status.openedStart = true;
      };
      $scope.openEnd = function($event) {
        $scope.status.openedEnd = true;
      };
      $scope.setDate = function(year, month, day) {
        $scope.dt = new Date(year, month, day);
      };
      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
      };
      $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
      $scope.format = $scope.formats[0];
      $scope.status = {
        opened: false
      };
      tomorrow = new Date;
      tomorrow.setDate(tomorrow.getDate() + 1);
      afterTomorrow = new Date;
      afterTomorrow.setDate(tomorrow.getDate() + 2);
      $scope.events = [
        {
          date: tomorrow,
          status: 'full'
        }, {
          date: afterTomorrow,
          status: 'partially'
        }
      ];
      $scope.$watch('selectedEndDate', function() {
        if ($scope.selectedEndDate && $scope.selectedStartDate) {
          return getVisits();
        }
      });
      $scope.$watch('selectedStartDate', function() {
        if ($scope.selectedEndDate && $scope.selectedStartDate) {
          return getVisits();
        }
      });
      console.log(Auth.validate());
      getAllVisitsByDate = function(startDate, endDate) {
        console.log('getting visits');
        return Doctors.indexDoctorsVisits(Auth.validate(), startDate, endDate).then(function(res) {
          return $scope.visits = res.data;
        });
      };
      $scope.updateAllVisits = function() {
        var actual, endDate, startDate;
        actual = new Date();
        startDate = String(actual.getDate()) + '-' + String(actual.getMonth() + 1) + '-' + String(actual.getFullYear());
        endDate = String(actual.getDate() + 1) + '-' + String(actual.getMonth() + 1) + '-' + String(actual.getFullYear());
        return getAllVisitsByDate(startDate, endDate);
      };
      $scope.updateAllVisits();
      getVisits = function() {
        var endDate, startDate;
        startDate = String($scope.selectedStartDate.getDate()) + '-' + String($scope.selectedStartDate.getMonth() + 1) + '-' + String($scope.selectedStartDate.getFullYear());
        endDate = String($scope.selectedEndDate.getDate() + 1) + '-' + String($scope.selectedEndDate.getMonth() + 1) + '-' + String($scope.selectedEndDate.getFullYear());
        return getAllVisitsByDate(startDate, endDate);
      };
      if ($stateParams.visitId) {
        Visits.show($stateParams.visitId).then(function(res) {
          console.log(res);
          return $scope.visit = res.data;
        });
      }
      $scope.doc = {};
      $scope.submit = function() {
        var visit;
        visit = {
          'visitId': $stateParams.visitId,
          'description': $scope.visit.visitView.descriptionOfVisit
        };
        console.log('save visit');
        return Visits.edit(visit).then(function(res) {
          return console.log(res);
        });
      };
      checkVisitDocument = function() {
        var status;
        status = '';
        Documents.checkExistance($stateParams.visitId).then(function(res) {
          return status = res.status;
        });
        if (status === '200') {
          return true;
        } else {
          return false;
        }
      };
      $scope.addPrescription = function() {
        var doc, prescriptionData;
        console.log('check' + checkVisitDocument());
        console.log($scope.prescription.department);
        console.log('visit id' + $stateParams.visitId);
        prescriptionData = {
          'issuedDate': new Date().getTime(),
          'department': $scope.prescription.department,
          'executionDate': new Date().getTime(),
          'remady': $scope.prescription.remady,
          'visitId': $stateParams.visitId
        };
        doc = {
          'description': 'visit document',
          'visitId': $stateParams.visitId,
          'date': new Date().getTime()
        };
        if (!checkVisitDocument()) {
          console.log('here');
          return Documents.create(doc).then(function(res) {
            return Documents.addPrescription(prescriptionData).then(function(res) {
              return console.log(res);
            });
          });
        } else {
          return Documents.addPrescription(prescriptionData).then(function(res) {
            return console.log(res);
          });
        }
      };
      $scope.addCertificate = function() {
        var certificateData, doc;
        certificateData = {
          'purpose': $scope.certificate.purpose,
          'recognition': $scope.certificate.recognition,
          'visitId': $stateParams.visitId
        };
        doc = {
          'description': 'random',
          'visitId': $stateParams.visitId,
          'date': new Date().getTime()
        };
        if (!checkVisitDocument()) {
          return Documents.create(doc).then(function(res) {
            return Documents.addCertificate(certificateData).then(function(res) {
              return console.log(res);
            });
          });
        } else {
          return Documents.addCertificate(certificateData).then(function(res) {
            return console.log(res);
          });
        }
      };
      $scope.addReferral = function() {
        var doc, referralData;
        referralData = {
          'destination': $scope.referral.destination,
          'purpose': $scope.referral.purpose,
          'recognition': $scope.referral.recognition,
          'visitId': $stateParams.visitId
        };
        doc = {
          'description': 'random',
          'visitId': $stateParams.visitId,
          'date': new Date().getTime()
        };
        if (!checkVisitDocument()) {
          return Documents.create(doc).then(function(res) {
            return Documents.addReferral(referralData).then(function(res) {
              return console.log(res);
            });
          });
        } else {
          return Documents.addReferral(referralData).then(function(res) {
            return console.log(res);
          });
        }
      };
      $scope.showPrescription = function() {
        return Documents.getPrescription($stateParams.visitId);
      };
      $scope.showReferral = function() {
        return Documents.getReferral($stateParams.visitId);
      };
      return $scope.showCertificate = function() {
        return Documents.getCertificate($stateParams.visitId);
      };
    }
  ]);

}).call(this);
