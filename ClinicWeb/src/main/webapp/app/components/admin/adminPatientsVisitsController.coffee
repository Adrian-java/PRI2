angular.module 'clinic'
  .controller 'AdminPatientsVisitsController', [ '$scope', 'Visits', '$stateParams', ($scope, Visits, $stateParams) ->

    if $stateParams.patientId
      Visits.showDone($stateParams.patientId).then((res)->
        console.log res
        $scope.doneVisits = res.data
      )

      Visits.showPlanned($stateParams.patientId).then((res)->
        console.log res
        $scope.plannedVisits = res.data
      )

  ]
