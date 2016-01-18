angular.module 'clinic'
  .controller 'PatientPlannedVisitsController', ['$scope', '$timeout', 'Visits', ($scope, $timeout, Visits) ->
    console.log 'patient planned visits controller'
    Visits.getPatientPlannedVisits().then((res) ->
      $scope.visits = res.data
      console.log res.data
    )

    $scope.resign = (visitId) ->
      Visits.remove(visitId).then((res) ->
        Visits.getPatientPlannedVisits().then((res) ->
          $scope.visits = res.data
          console.log res.data
        )
      )

  ]
