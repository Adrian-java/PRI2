angular.module 'clinic'
  .controller 'ReceptionistDoctorsController', ['$scope', '$stateParams', 'Doctors', '$state', ($scope, $stateParams,Doctors, $state) ->
    console.log 'admin doctors controller'

    Doctors.index().then((res) ->
      $scope.doctors = res.data
    )

    $scope.submit = ->
      Doctors.create($scope.doctor).then((res)->
        $state.go('admin-doctors')
      )

    console.log $stateParams
    if $stateParams
      if $stateParams.doctorId
        Doctors.show($stateParams.doctorId).then((res)->
          $scope.doctor = res.data
          console.log res
        )
        Doctors.getDoctorSpeciality($stateParams.doctorId).then((res)->
          $scope.doctorSpecialities = res.data
        )

  ]
