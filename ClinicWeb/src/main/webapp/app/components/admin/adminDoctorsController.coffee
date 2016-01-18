angular.module 'clinic'
  .controller 'AdminDoctorsController', ['$scope', '$stateParams', 'Doctors', '$state', ($scope, $stateParams,Doctors, $state) ->
    console.log 'admin doctors controller'

    Doctors.index().then((res) ->
      $scope.doctors = res.data
    )

    $scope.submit = ->
      specialities = $scope.specialities.split(',')
      specialitiesArray = []
      for speciality in specialities
        specialitiesArray.push({
          'name': speciality
        })
      $scope.doctor.doctor.specializations = specialitiesArray
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


    $scope.remove = (id) ->
      Doctors.remove(id).then((res) ->
        console.log res
        Doctors.index().then((res) ->
          $scope.doctors = res.data
        )
      )

    $scope.update = ->
      doctor = {
        'name': $scope.doctor.name
        'surname': $scope.doctor.surname
      }
      Doctors.update($stateParams.doctorId, doctor).then((res) ->
        console.log 'doctor updated'
        $state.go('admin-doctors')
      )
  ]
