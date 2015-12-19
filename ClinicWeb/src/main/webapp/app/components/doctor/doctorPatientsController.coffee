angular.module 'clinic'
  .controller 'DoctorPatientsController', ['$scope', 'Patients', '$stateParams', ($scope, Patients, $stateParams) ->
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
