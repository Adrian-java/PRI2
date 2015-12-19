angular.module 'clinic'
  .controller 'HomeController', ['$scope', '$timeout', '$state', 'Specialities', 'Doctors', ($scope, $timeout, $state, Specialities, Doctors) ->
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

    $scope.open = ($event) ->
      $scope.status.opened = true
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

    Specialities.getSpecialities().then((res) ->
      $scope.specialities = res.data
      console.log 'specialities list'
      console.log $scope.specialities
    )

    Doctors.index().then((res) ->
      $scope.doctors = res.data
      console.log 'doctors'
      console.log $scope.doctors
    )

    $scope.updateDoctorsList = ->
      console.log 'update doctors list ' + $scope.selectedSpeciality
      Doctors.indexBySpeciality($scope.selectedSpeciality).then( (res) ->
        console.log 'change doctors select'
        $scope.doctors = res.data
      )

    $scope.submit = ->
      console.log 'submit main form'
      console.log $scope.selectedDoctor
      $state.go('visits.new', {
        'speciality': $scope.selectedSpeciality
        'doctor': $scope.selectedDoctor.id
        'date': $scope.selectedDate
      })
  ]
