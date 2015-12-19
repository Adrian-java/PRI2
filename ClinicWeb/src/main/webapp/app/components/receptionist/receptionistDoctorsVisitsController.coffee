angular.module 'clinic'
  .controller 'ReceptionistDoctorsVisitsController', [ '$scope', 'Doctors', '$stateParams', '$state', ($scope, Doctors, $stateParams, $state) ->

    if $stateParams
      $scope.selectedDoctorId = $stateParams.doctorId

    changeWeek = (element, view) ->
      $scope.calendarStartDate = element.start._d
      Doctors.takenVisitsTimeFrame($scope.selectedDoctorId, element.start._d, element.end._d).then((res)->
        if res.data.length > 0
          visitDate = new Date(res.data[0].dateOfVisit*1000)
        console.log res
        $scope.visitsTemp = res.data
        getVisits()
      )

    $scope.visits = []

    getVisits = ->
      $scope.visits.length = 0
      for visit in $scope.visitsTemp
        do ->
          startDate = new Date(visit.dateOfVisit)
          endDate = new Date(startDate.getTime() + 20*60000)
          $scope.visits.push({
            start: startDate
            end: endDate
            id: visit.id
          })

    $scope.clickEvent = (event) ->
      $state.go('admin-visits-show', {visitId: event.id})

    $scope.uiConfig = calendar:
      height: 450
      editable: false
      defaultView: 'agendaWeek'
      slotDuration: '00:20:00'
      header:
        left: 'title'
        center: ''
        right: 'today prev,next'
      eventClick: $scope.clickEvent
      eventDrop: $scope.alertOnDrop
      eventResize: $scope.alertOnResize
      eventRender: $scope.eventRender
      viewRender: changeWeek
      defaultDate: if $scope.selectedDate then new Date($scope.selectedDate) else new Date()

    $scope.eventSources = [
      $scope.visits
    ]

  ]
