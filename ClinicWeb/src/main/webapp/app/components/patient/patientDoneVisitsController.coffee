angular.module 'clinic'
  .controller 'PatientDoneVisitsController', ['$scope', '$timeout', 'Visits', ($scope, $timeout, Visits) ->
    console.log 'patient done visits controller'
    Visits.getPatientDoneVisits().then((res) ->
      $scope.visits = res.data
    )
  ]
