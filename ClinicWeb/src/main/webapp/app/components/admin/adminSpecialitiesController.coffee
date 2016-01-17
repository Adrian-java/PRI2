angular.module 'clinic'
  .controller 'AdminSpecialitiesController', ['$scope', 'Specialities', '$stateParams', 'Doctors', ($scope, Specialities, $stateParams, Doctors) ->
    console.log 'Specialities controller'
    Specialities.getSpecialities().then((res) ->
      $scope.specialities = res.data
      console.log 'specialities list'
      console.log $scope.specialities
    )

    if $stateParams.specialitySlug
      console.log $stateParams.specialitySlug
      Doctors.indexBySpeciality($stateParams.specialitySlug).then((res) ->
        $scope.doctors = res.data
      )
  ]
