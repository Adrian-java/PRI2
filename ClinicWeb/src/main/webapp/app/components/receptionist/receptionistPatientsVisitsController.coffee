angular.module 'clinic'
  .controller 'ReceptionistPatientsVisitsController', [ '$scope', 'Patients', '$stateParams', ($scope, Patients, $stateParams) ->
    console.log 'admin patients visits controller'

    #if $stateParams
      #Patients.show($stateParams.patientId).then((res)->
      #  $scope.patient = res.data
      #)

  ]
