angular.module 'clinic'
  .controller 'AdminReceptionistsController', [ '$scope', 'Receptionists', '$stateParams', '$state', ($scope, Receptionists, $stateParams, $state) ->
    console.log 'admin receptionists controller'
    Receptionists.index().then((res) ->
      $scope.receptionists = res.data
    )

    $scope.submit = ->
      console.log $scope.receptionist
      Receptionists.create($scope.receptionist).then((res) ->
        $state.go('admin-receptionists')
      )

    if $stateParams
      Receptionists.show($stateParams.receptionistId).then((res)->
        $scope.receptionist = res.data
      )

    $scope.remove = (id) ->
      Receptionists.remove(id).then((res) ->
        console.log res
        Receptionists.index().then((res) ->
          $scope.receptionists = res.data
        )
      )
  ]
