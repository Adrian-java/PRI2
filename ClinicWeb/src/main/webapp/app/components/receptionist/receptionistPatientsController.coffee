angular.module 'clinic'
  .controller 'ReceptionistPatientsController', [ '$scope', 'Patients', '$stateParams', '$state', ($scope, Patients, $stateParams, $state) ->

    if $stateParams.patientId
      Patients.show($stateParams.patientId).then((res)->
        $scope.patient = res.data
      )
    else
      Patients.index().then((res) ->
        $scope.patients = res.data
      )

    $scope.submit = ->
      Patients.create($scope.user).then((res) ->
        console.log res
        $state.go('receptionist-patients')
      )

    $scope.edit = ->
      $scope.editedPatient = {
        'name': $scope.patient.name
        'surname': $scope.patient.surname
        'phoneNr': $scope.patient.phoneNr
        'address': {
          'city': $scope.patient.city
          'countryCode': $scope.patient.countryCode
          'province': $scope.patient.province
          'country': $scope.patient.country
          'countryCodeCity': $scope.patient.countryCode
          'street': $scope.patient.street
          'homeNr': $scope.patient.homeNr
        }
      }
      Patients.edit($scope.patient.id, $scope.editedPatient).then((res) ->
        console.log res
        console.log 'patient update'
        $state.go('admin-patients')
      )

  ]
