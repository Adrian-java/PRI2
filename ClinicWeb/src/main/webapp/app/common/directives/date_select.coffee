angular.module 'clinic'
  .directive 'dateSelect', [ ->
    {
      restrict: 'C'
      template: '<select class="form-control" ng-options="month as month for month in months" ng-model="user.birthDate.month"></select>'+
                '<select class="form-control" ng-options="day as day for day in days" ng-model="user.birthDate.day"></select>'+
                '<select class="form-control" ng-options="year as year for year in years" ng-model="user.birthDate.year"></select>'
      controller: [ '$scope', ($scope) ->

        $scope.months = ['styczeń', 'luty', 'marzec', 'kwiecień', 'maj', 'czerwiec', 'lipiec', 'sierpień', 'wrzesień', 'październik', 'listopad', 'grudzień']

        $scope.user = {}
        $scope.user.birthDate = {}
        #$scope.user.birthDate.month = ''

        getDays = ->
          monthIndex = $scope.months.indexOf($scope.user.birthDate.month)
          $scope.user.birthDate.monthId = monthIndex+1

          if $scope.user.birthDate.month && $scope.user.birthDate.year
            #monthIndex = $scope.months.indexOf($scope.user.birthDate.month)
            days = new Date($scope.user.birthDate.year, monthIndex+1, 0).getDate()
          else
            days = 31

          $scope.days = new Array(days)

          i = 0
          while i < $scope.days.length
            $scope.days[i] = i+1
            i++

        getYears = ->
          $scope.years = new Array(100)
          currentYear =  new Date().getFullYear()
          
          i = 0
          while i < $scope.years.length
            $scope.years[i] = currentYear--
            i++

        getDays()
        getYears()

        $scope.$watch 'user.birthDate.month', ->
          getDays()
        $scope.$watch 'user.birthDate.year', ->
          getDays()
      ]
    }
  ]
