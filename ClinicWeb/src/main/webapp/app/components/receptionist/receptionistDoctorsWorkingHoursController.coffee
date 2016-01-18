angular.module 'clinic'
  .controller 'ReceptionistDoctorsWorkingHoursController', [ '$scope', 'Specialities', '$stateParams', 'Doctors', ($scope, Specialities, $stateParams, Doctors) ->

    $scope.workingHours = {}

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

    Doctors.getDoctorSpeciality($stateParams.doctorId).then((res) ->
      console.log res
      $scope.specialities = res.data
    )

    $scope.submit = ->
      #console.log $scope.selectedDate
      #dateParams = $scope.selectedDate.split('-')
      #console.log dateParams
      $scope.workingHours.idDoctor = $stateParams.doctorId

      #$scope.workingHours.startDate = new Date($scope.selectedDate).getTime()
      #console.log $scope.workingHours.startDate
      date = new Date($scope.selectedDate)
      $scope.workingHours.startDate = new Date(date.getFullYear(),date.getMonth(),date.getDate()-3).getTime()
      $scope.workingHours.duration = 30
      $scope.workingHours.visitRepeat = 7
      $scope.workingHours.description = ''
      console.log $scope.workingHours
      Doctors.addWorkingHours($scope.workingHours).then((res) ->
        console.log res
      )

  ]
