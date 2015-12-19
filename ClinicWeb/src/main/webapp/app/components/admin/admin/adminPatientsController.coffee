angular.module 'clinic'
  .controller 'AdminPatientsController', [ '$scope', 'Patients', '$stateParams', ($scope, Patients, $stateParams) ->
    console.log 'admin patients controller'

    Patients.index().then((res) ->
      console.log res
      $scope.patients = res.data
    )

    console.log $stateParams
    if $stateParams
      Patients.show($stateParams.patientId).then((res)->
        $scope.patient = res.data
      )

  ]
