angular.module 'clinic'
  .controller 'AdminPatientsController', [ '$scope', 'Patients', '$stateParams', '$state', ($scope, Patients, $stateParams, $state) ->
    console.log 'admin patients controller'

    Patients.index().then((res) ->
      console.log res
      $scope.patients = res.data
    )

    console.log $stateParams
    if $stateParams
      Patients.show($stateParams.patientId).then((res)->
        console.log res
        $scope.patient = res.data
      )

    $scope.remove = (id) ->
      Patients.remove(id).then((res) ->
        console.log res
        Patients.index().then((res) ->
          $scope.receptionists = res.data
        )
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
