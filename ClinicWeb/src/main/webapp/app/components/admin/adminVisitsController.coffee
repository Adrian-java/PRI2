angular.module 'clinic'
  .controller 'AdminVisitsController', ['$scope', '$stateParams', 'Doctors', 'Patients', '$compile', 'uiCalendarConfig', '$timeout', 'Specialities', 'Visits', 'Auth', '$uibModal', '$state', ($scope, $stateParams, Doctors, Patients, $compile, uiCalendarConfig, $timeout, Specialities, Visits, Auth, $uibModal, $state) ->

    $scope.selectedView = ''

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

    getAllVisitsByDate = (startDate, endDate) ->
      Visits.indexByDate(startDate, endDate).then((res) ->
        $scope.visits = res.data
      )

    $scope.updateAllVisits = ->
      actual = new Date()
      startDate = String(actual.getDate()) + '-' + String(actual.getMonth()+1) + '-' + String(actual.getFullYear())
      endDate = String(actual.getDate()+1) + '-' + String(actual.getMonth()+1) + '-' + String(actual.getFullYear())
      getAllVisitsByDate(startDate, endDate)

    $scope.updateAllVisits()

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

    $scope.getDayClass = (date, mode) ->
      if mode == 'day'
        dayToCheck = new Date(date).setHours(0, 0, 0, 0)
        i = 0
        while i < $scope.events.length
          currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0)
          if dayToCheck == currentDay
            return $scope.events[i].status
          i++
      ''

    $scope.$watch 'selectedEndDate', ->
      if $scope.selectedEndDate && $scope.selectedStartDate
        getVisits()

    $scope.$watch 'selectedStartDate', ->
      if $scope.selectedEndDate && $scope.selectedStartDate
        getVisits()

    getVisits = ->
      startDate = String($scope.selectedStartDate.getDate()) + '-' + String($scope.selectedStartDate.getMonth()+1) + '-' + String($scope.selectedStartDate.getFullYear())
      endDate = String($scope.selectedEndDate.getDate()+1) + '-' + String($scope.selectedEndDate.getMonth()+1) + '-' + String($scope.selectedEndDate.getFullYear())
      #console.log startDate
      getAllVisitsByDate(startDate, endDate)

    $scope.removeVisit = (id) ->
      Visits.remove(id).then((res) ->
        console.log 'visit removed'
        console.log res
        if $scope.selectedStartDate && $scope.selectedEndDate
          getVisits()
        else
          $scope.updateAllVisits()
      )

    if $stateParams.visitId
      console.log $stateParams.visitId
      Visits.show($stateParams.visitId).then((res) ->
        $scope.visit = res.data
        console.log res.data
      )

  ]
