angular.module 'clinic'
  .controller 'AdminVisitsController', ['$scope', '$stateParams', 'Doctors', 'Patients', '$compile', 'uiCalendarConfig', '$timeout', 'Specialities', 'Visits', 'Auth', '$uibModal', '$state', ($scope, $stateParams, Doctors, Patients, $compile, uiCalendarConfig, $timeout, Specialities, Visits, Auth, $uibModal, $state) ->

    $scope.removeVisit = (id) ->
      Visits.destroy(id)

    $scope.workingTime = []

    Specialities.getSpecialities().then((res) ->
      $scope.specialities = res.data
    )

    Patients.index().then((res) ->
      console.log res
      $scope.patients = res.data
    )

    getAllDoctors = ->
      Doctors.index().then((res) ->
        $scope.doctors = res.data
      )

    getAllDoctors()

    $scope.updateDoctorsList = ->
      if $scope.selectedSpeciality
        Doctors.indexBySpeciality($scope.selectedSpeciality).then( (res) ->
          $scope.doctors = res.data
          for doctor in $scope.doctors
            do ->
              if doctor.id == $scope.selectedDoctorId
                $scope.selectedDoctor = doctor
        )
      else
        getAllDoctors()

    $scope.$watch('selectedDoctor', ->
      if $scope.selectedDoctor
        $scope.selectedDoctorId = $scope.selectedDoctor.id
        getWorkingTime()
    )

    getWorkingTime = ->
      Doctors.workingTime($scope.selectedDoctorId).then((res) ->
        $scope.workingTime = res.data
        setCalendarWorkingTime(res.data)
      )

    $scope.workingTimeEvents = []

    setCalendarWorkingTime = ->
      $scope.workingTimeEvents.length = 0
      for date in $scope.workingTime
        do ->
          startDate = new Date(date.startDate*1000)
          dayOfTheWeek = startDate.getDay()

          eventStartDate = new Date($scope.calendarStartDate.getUTCFullYear(), $scope.calendarStartDate.getMonth(), $scope.calendarStartDate.getUTCDate() + dayOfTheWeek, date.timeFrom.split(':')[0], date.timeFrom.split(':')[1])
          eventEndDate = new Date($scope.calendarStartDate.getUTCFullYear(), $scope.calendarStartDate.getMonth(), $scope.calendarStartDate.getUTCDate() + dayOfTheWeek, date.timeTo.split(':')[0], date.timeTo.split(':')[1])

          $scope.workingTimeEvents.push({
            start: eventStartDate
            end: eventEndDate
          })

          eventCurrentDate = eventStartDate
          eventCurrentEndDate = new Date(eventEndDate.getTime() + 20*60000)
          while eventCurrentDate < eventEndDate
            $scope.workingTimeEvents.push({
              start: eventCurrentDate
              end: new Date(eventCurrentDate.getTime() + 20*60000)
            })
            eventCurrentDate = new Date(eventCurrentDate.getTime() + 20*60000)

    $scope.$watch 'selectedDoctor', ->
      if $scope.selectedDoctor
        getWorkingTime()

    changeWeek = (element, view) ->
      $scope.calendarStartDate = element.start._d
      Doctors.takenVisitsTimeFrame($scope.selectedDoctorId, element.start._d, element.end._d).then((res)->
        if res.data.length > 0
          visitDate = new Date(res.data[0].dateOfVisit*1000)
      )
      setCalendarWorkingTime()

    $scope.clickEvent = (event, jsEvent, view) ->
      $scope.selectedVisitDate = event.start._d

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

    ### event sources array###

    $scope.eventSources = [
      $scope.workingTimeEvents
    ]

    $scope.submit = ->
      visit = {}
      visit.patientId = $scope.selectedPatient
      visit.date = $scope.selectedVisitDate.getTime()
      visit.idDoctor = $scope.selectedDoctorId
      visit.typeOfVisit = 'Dermatolog'
      Visits.create(visit).then((res)->
        $state.go('admin-visits')
      )

  ]
