angular.module 'clinic'
  .controller 'VisitsController', ['$scope', '$stateParams', 'Doctors', '$compile', 'uiCalendarConfig', '$timeout', 'Specialities', 'Visits', 'Auth', '$uibModal', ($scope, $stateParams, Doctors, $compile, uiCalendarConfig, $timeout, Specialities, Visits, Auth, $uibModal) ->

    $scope.workingTime = []

    Specialities.getSpecialities().then((res) ->
      $scope.specialities = res.data
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


    getStateParams = ->
      if $stateParams.speciality
        $scope.selectedSpeciality = $stateParams.speciality
        $scope.updateDoctorsList()
      if $stateParams.doctor
        $scope.selectedDoctorId = $stateParams.doctor
      if $stateParams.date
        $scope.selectedDate = $stateParams.date


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
    getStateParams()

    $scope.$watch 'selectedDoctor', ->
      if $scope.selectedDoctor
        getWorkingTime()

    $scope.changeTo = 'Hungarian'

    ### alert on eventClick ###

    $scope.alertOnEventClick = (date, jsEvent, view) ->
      $scope.alertMessage = date.title + ' was clicked '
      return

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
      defaultDate: if $scope.selectedDate then new Date($scope.selectedDate) else new Date()

    ###$timeout( ->
      $scope.uiConfig.calendar.slotDuration = '00:30:00'
      #$scope.renderCalender()
    , 5000)
    ###

    $scope.changeLang = ->
      if $scope.changeTo == 'Hungarian'
        $scope.uiConfig.calendar.dayNames = [
          'Vasárnap'
          'Hétfő'
          'Kedd'
          'Szerda'
          'Csütörtök'
          'Péntek'
          'Szombat'
        ]
        $scope.uiConfig.calendar.dayNamesShort = [
          'Vas'
          'Hét'
          'Kedd'
          'Sze'
          'Csüt'
          'Pén'
          'Szo'
        ]
        $scope.changeTo = 'English'
      else
        $scope.uiConfig.calendar.dayNames = [
          'Sunday'
          'Monday'
          'Tuesday'
          'Wednesday'
          'Thursday'
          'Friday'
          'Saturday'
        ]
        $scope.uiConfig.calendar.dayNamesShort = [
          'Sun'
          'Mon'
          'Tue'
          'Wed'
          'Thu'
          'Fri'
          'Sat'
        ]
        $scope.changeTo = 'Hungarian'
      return

    ### event sources array###

    $scope.eventSources = [
      $scope.workingTimeEvents
    ]

    $scope.submit = ->
      login = Auth.validate()
      if login
        visit = {}
        visit.patientId = login
        visit.date = $scope.selectedVisitDate.getTime()/1000
        visit.idDoctor = $scope.selectedDoctorId
        visit.typeOfVisit = 'Dermatolog'
        console.log visit
        Visits.create(visit).then((res)->
          console.log res
        )
      else
        modalInstance = $uibModal.open(
          animation: true
          templateUrl: '/app/components/login/login_modal.html'
          controller: 'LoginController'
        )
        modalInstance.result.then( (user) ->
          console.log user
        )

  ]
