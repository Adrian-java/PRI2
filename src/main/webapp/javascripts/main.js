'use strict';

console.log("sth");

var clinic = angular.module('clinic', ['ui.router', 'ngCookies']);

clinic.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/home");

	$stateProvider
		.state('main', {
			url: "/home",
			templateUrl: "partials/main.html"
		})
		.state('add_user', {
			url: "/new",
			templateUrl: "partials/newUser.html"
		})
})

clinic.controller('exampleController', ['$scope', '$rootScope', '$http', '$cookies', function($scope, $rootScope, $http, $cookies) {
	
	/*$http({
		method: 'POST',
		isArray: false,
		url: "http://localhost:8080/wee/rest/auth/token",
		data: $.param({
			username: "patient5",
			password: "patient5"
		}),
		headers: {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'}
	}).success(function(result){
		$rootScope.example = result.token;
		$cookies.put('token', result.token);
		$http({
			method: 'GET',
			url: "http://localhost:8080/wee/rest/Address/6",
			headers: {'XToken': $cookies.get('token')}
		}).success(function(result){
			console.log(result);
		});
	});*/
}]);

clinic.controller('igCtrl', function ($scope, $http, $cookies) {

    $scope.email = "";
    $scope.pwd = "";
    $scope.loggedIn = false;
    $scope.loggingIn = false;

    $scope.showLogin = function () {
        $scope.loggingIn = true;
    };

    $scope.logout = function () {
        // do your logout logic
        $scope.user = null;
        $scope.loggedIn = false;
    };

    $scope.login = function () {
        // do your login logic
    	$http({
    		method: 'POST',
    		isArray: false,
    		url: "http://localhost:8080/wee/rest/auth/token",
    		data: $.param({
    			username: $scope.email,
    			password: $scope.pwd
    		}),
    		headers: {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'}
    	}).success(function(result){    		
    		$cookies.put('token', result.token);
    		console.log('ok');
    		$scope.loggedIn = true;
    		$scope.loggingIn = false;
    		
    	}).error(function(){
    		console.log('bad request');
    		$scope.logginIn = true;
    		$scope.loggedIn = false;
    	});
        
        
    };
});

clinic.directive('igLogin', function () {
    return {
        restrict: 'E',
        replace: true,
        template: '<div>' +
'  <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> ' +
'    <div class="modal-dialog"> ' +
'      <form name="form" ng-submit="submit()"> ' +
'        <div class="modal-content"> ' +
'          <div class="modal-header"> ' +
'            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" ng-click="cancel()"> Cancel </button>' +
'              <h3> </h3 > ' +
'          </div>' +
'          <div class="modal-body">' +
'            <table border="0"><tr><td>Email: </td><td><input type="text" ng-model="email"></input> </td></tr> ' +
'            <tr><td>Password: </td><td><input type="password" ng-model="pwd"> </input></td></tr>' +
'            <tr><td colspan="2"><input type="submit" class="btn btn-primary" id="submit" ng-click="submit()" value="Login"></input></td></tr></table> ' +
'          </div>' +
'        </div> ' +
'      </form>' +
'    </div> ' +
'  </div>' +
'</div> ',
        controller: function ($scope) {
            
            $scope.submit = function() {
                $scope.login();
            };
            
            $scope.cancel = function() {
                $scope.loggingIn = false;
		        $("#loginModal").modal('hide');
            };
            
            $scope.$watch('loggingIn', function() {
                if ($scope.loggingIn) {
		            $("#loginModal").modal('show');
		            
                }
                else {
                	$("#loginModal").modal('hide');
                	
                }
                
           });   
        }
    };
});