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
    if $stateParams
      Doctors.show($stateParams.doctorId).then((res)->
        $scope.doctor = res.data
      )

    $scope.remove = (id) ->
      Doctors.remove(id).then((res) ->
        console.log res
        Doctors.index().then((res) ->
          $scope.doctors = res.data
        )
      )
  ]
