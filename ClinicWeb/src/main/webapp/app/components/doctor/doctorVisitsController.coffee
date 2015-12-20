angular.module 'clinic'
  .controller 'DoctorVisitsController', [ '$scope', 'Doctors', 'Auth', 'Visits', '$stateParams', 'Documents', ($scope, Doctors, Auth, Visits, $stateParams, Documents) ->

    $scope.today = ->
      $scope.dt = new Date
      return

    $scope.today()

    $scope.clear = ->
      $scope.dt = null
      return

    # Disable weekend selection

    $scope.disabled = (date, mode) ->
      mode == 'day' and (date.getDay() == 0 or date.getDay() == 6)

    $scope.toggleMin = ->
      $scope.minDate = if $scope.minDate then null else new Date
      return

    $scope.toggleMin()
    $scope.maxDate = new Date(2020, 5, 22)

    $scope.openStart = ($event) ->
      $scope.status.openedStart = true
      return

    $scope.openEnd = ($event) ->
      $scope.status.openedEnd = true
      return

    $scope.setDate = (year, month, day) ->
      $scope.dt = new Date(year, month, day)
      return

    $scope.dateOptions =
      formatYear: 'yy'
      startingDay: 1
    $scope.formats = [
      'dd-MMMM-yyyy'
      'yyyy/MM/dd'
      'dd.MM.yyyy'
      'shortDate'
    ]
    $scope.format = $scope.formats[0]
    $scope.status = opened: false
    tomorrow = new Date
    tomorrow.setDate tomorrow.getDate() + 1
    afterTomorrow = new Date
    afterTomorrow.setDate tomorrow.getDate() + 2
    $scope.events = [
      {
        date: tomorrow
        status: 'full'
      }
      {
        date: afterTomorrow
        status: 'partially'
      }
    ]

    $scope.$watch 'selectedEndDate', ->
      if $scope.selectedEndDate && $scope.selectedStartDate
        getVisits()

    $scope.$watch 'selectedStartDate', ->
      if $scope.selectedEndDate && $scope.selectedStartDate
        getVisits()

    console.log Auth.validate()

    getAllVisitsByDate = (startDate, endDate) ->
      console.log 'getting visits'
      Doctors.indexDoctorsVisits(Auth.validate(), startDate, endDate).then((res) ->
        $scope.visits = res.data
      )

    $scope.updateAllVisits = ->
      actual = new Date()
      startDate = String(actual.getDate()) + '-' + String(actual.getMonth()+1) + '-' + String(actual.getFullYear())
      endDate = String(actual.getDate()+1) + '-' + String(actual.getMonth()+1) + '-' + String(actual.getFullYear())
      getAllVisitsByDate(startDate, endDate)

    $scope.updateAllVisits()

    getVisits = ->
      startDate = String($scope.selectedStartDate.getDate()) + '-' + String($scope.selectedStartDate.getMonth()+1) + '-' + String($scope.selectedStartDate.getFullYear())
      endDate = String($scope.selectedEndDate.getDate()+1) + '-' + String($scope.selectedEndDate.getMonth()+1) + '-' + String($scope.selectedEndDate.getFullYear())
      #console.log startDate
      getAllVisitsByDate(startDate, endDate)

    if $stateParams.visitId
      Visits.show($stateParams.visitId).then((res) ->
        console.log res
        $scope.visit = res.data
      )

    $scope.doc = {}

    $scope.submit = ->
      $scope.doc.visitId = $stateParams.visitId
      $scope.doc.date = $scope.visit.visitView.dateOfVisit
      Documents.create($scope.doc).then((res) ->
        console.log res
        console.log 'doc added'
      )

  ]
