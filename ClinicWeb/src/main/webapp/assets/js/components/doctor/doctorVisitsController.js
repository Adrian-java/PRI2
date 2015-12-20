(function() {
  angular.module('clinic').controller('DoctorVisitsController', [
    '$scope', 'Doctors', 'Auth', 'Visits', '$stateParams', 'Documents', function($scope, Doctors, Auth, Visits, $stateParams, Documents) {
      var afterTomorrow, getAllVisitsByDate, getVisits, tomorrow;
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
        $scope.doc.visitId = $stateParams.visitId;
        $scope.doc.date = $scope.visit.visitView.dateOfVisit;
        return Documents.create($scope.doc).then(function(res) {
          console.log(res);
          return console.log('doc added');
        });
      };
      $scope.addPrescription = function() {
        var prescriptionData;
        prescriptionData = {
          'issuedDate': new Date().getTime(),
          'department': '03',
          'executionDate': new Date().getTime(),
          'remady': 'Duomox;50%;',
          'visitId': $stateParams.visitId
        };
        return Documents.addPrescription(prescriptionData).then(function(res) {
          return console.log(res);
        });
      };
      return $scope.addCertificate = function() {
        var certificateData;
        certificateData = {
          'purpose': 'certificate purpose',
          'recognition': 'certificate recognition',
          'visitId': $stateParams.visitId
        };
        return Documents.addCertificate(certificateData).then(function(res) {
          return console.log(res);
        });
      };
    }
  ]);

}).call(this);
