angular.module 'clinic'
  .controller 'AdminSpecialitiesController', ['$scope', 'Specialities', ($scope, Specialities) ->
    console.log 'Specialities controller'
    Specialities.getSpecialities().then((res) ->
      $scope.specialities = res.data
      console.log 'specialities list'
      console.log $scope.specialities
    )
  ]
