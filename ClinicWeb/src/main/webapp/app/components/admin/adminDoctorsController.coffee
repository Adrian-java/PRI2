angular.module 'clinic'
  .controller 'AdminDoctorsController', ['$scope', '$stateParams', 'Doctors', '$state', ($scope, $stateParams,Doctors, $state) ->
    console.log 'admin doctors controller'

    Doctors.index().then((res) ->
      $scope.doctors = res.data
    )

    $scope.submit = ->
      Doctors.create($scope.doctor).then((res)->
        $state.go('admin-doctors')
      )

    console.log $stateParams
    if $stateParams.doctorId
      Doctors.show($stateParams.doctorId).then((res)->
        console.log res.data
        $scope.doctor = res.data
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
