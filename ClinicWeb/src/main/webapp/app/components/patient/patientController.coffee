angular.module 'clinic'
  .controller 'PatientController', ['$scope', '$timeout', 'Patients', ($scope, $timeout, Patients) ->
    console.log 'patient controller'

    Patients.show().then((res) ->
      $scope.patient = res.data
    )

  ]
