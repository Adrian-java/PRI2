angular.module 'clinic'
  .controller 'AdminPatientsVisitsController', [ '$scope', 'Patients', '$stateParams', ($scope, Patients, $stateParams) ->
    console.log 'admin patients visits controller'

    #if $stateParams
      #Patients.show($stateParams.patientId).then((res)->
      #  $scope.patient = res.data
      #)

  ]
