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
      console.log $stateParams
      Receptionists.show($stateParams.receptionistId).then((res)->
        console.log 'downloaded receptionists'
        console.log res
        $scope.receptionist = res.data
      , (err) ->
        console.log err
      )

    $scope.remove = (id) ->
      Receptionists.remove(id).then((res) ->
        console.log res
        Receptionists.index().then((res) ->
          $scope.receptionists = res.data
        )
      )

    $scope.edit = ->
      $scope.editedReceptionist = {
        'name': $scope.receptionist.name
        'surname': $scope.receptionist.surname
        'phoneNr': $scope.receptionist.phoneNr
      }
      console.log $stateParams.receptionistId
      #Receptionists.edit($stateParams.receptionistId, $scope.editedReceptionist).then((res) ->
      #  console.log res
      #  console.log 'receptionist update'
      #  $state.go('admin-receptionists')
      #)
  ]
