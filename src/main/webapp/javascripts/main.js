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
		.state('panel', {
			url: "/panel",
			templateUrl: "partials/panel.html"
		})
		.state('add_admin', {
			url: "/newAdmin",
			templateUrl: "partials/newAdmin.html"
		})
		.state('add_doctor', {
			url: "/newDoctor",
			templateUrl: "partials/newDoctor.html"
		})
		.state('add_receptionist', {
			url: "/newReceptionist",
			templateUrl: "partials/newReceptionist.html"
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

clinic.controller('NewUserController', function($scope, $http, $cookies){
	$scope.addUser = function(user){
		var userInfo = {
				"role": "patient",
				"pesel": user.pesel,
				"changedPassword": "false",
				"password": user.password,
				"worker": {
					"patient": {
						"name": user.first_name,
						"surname": user.last_name,
						"dateOfBirth": user.birth_date,
						"EMail": user.email,
						"phoneNr": user.phone,
						"confirmed": "0",
						"address": {
							"city": user.city,
							"countryCode": user.county_code,
							"province": user.province,
							"country": user.country,
							"countryCodeCity": user.county_code,
							"homeNr": user.home_nr,
						}
					}
				},
				"registerDate": "2015-01-01",
				"isActive": "true",
				"email": user.email				
			};
		console.log(userInfo);
		$http({
			method: 'POST',
			url: "http://localhost:8080/wee/rest/SystemUser/newPatient",
			data: userInfo,
			headers: {'XToken': $cookies.get('token'), 'Content-Type': 'application/json'}
		}).success(function(result){
			console.log("user added");
			console.log(result);
			
			
			
			
			
			
			
			
		});
	}
	
	
});


clinic.controller('NewAdminController', function($scope, $http, $cookies){
	$scope.addUser = function(user){
		var userInfo = {
				"role": "admin",
				"pesel": user.pesel,
				"changedPassword": "false",
				"password": user.password,
				"registerDate": "2015-01-01",
				"isActive": "true",
				"email": user.email,
				"worker": {
					"admin": {
						"isSuper": 0
					}
				},
			};
		$http({
			method: 'POST',
			url: "http://localhost:8080/wee/rest/SystemUser/newAdmin",
			data: userInfo,
			headers: {'XToken': $cookies.get('token'), 'Content-Type': 'application/json'}
		}).success(function(result){
			console.log("admin added");
			console.log(result);		
		});
	}
});

clinic.controller('NewDoctorController', function($scope, $http, $cookies) {
	$scope.addUser = function(user){
		var userInfo = 
		{
			"role":"doctor",
			"pesel": user.pesel,
			"changedPassword":"false",
			"password":user.password,
			"registerDate":"2015-05-04",
			"isActive":"true",
			"email": user.email,
			"worker":
				  {
					"doctor":
						{
						"name": user.first_name,
						"surname": user.last_name 
						}
				}			
		};
		$http({
			method: 'POST',
			url: "http://localhost:8080/wee/rest/SystemUser/newDoctor",
			data: userInfo,
			headers: {'XToken': $cookies.get('token'), 'Content-Type': 'application/json'}
		}).success(function(result){
			console.log("doctor added");
			console.log(result);		
		});
	}
})

clinic.controller('NewReceptionistController', function($scope, $http, $cookies) {
	$scope.addUser = function(user){
		var userInfo = 
		{
			"role":"receptionist",
			"pesel": user.pesel,
			"changedPassword":"false",
			"password":user.password,
			"registerDate":"2015-05-04",
			"isActive":"true",
			"email": user.email,
			"worker":
				  {
					"receptionist":
						{
						"name": user.first_name,
						"surname": user.last_name,
						"phoneNr": user.phone,
						"access": "access"
						}
				}			
		};
		$http({
			method: 'POST',
			url: "http://localhost:8080/wee/rest/SystemUser/newReceptionist",
			data: userInfo,
			headers: {'XToken': $cookies.get('token'), 'Content-Type': 'application/json'}
		}).success(function(result){
			console.log("recept added");
			console.log(result);		
		});
	}
})

clinic.controller('PanelController', function($scope, $http, $cookies) {
	$scope.pesel = $cookies.get('token').split(":")[0]
	
	$http({
			method: 'GET',
			url: "http://localhost:8080/wee/rest/SystemUser/role/"+$scope.pesel,
			headers: {'XToken': $cookies.get('token')}
		}).success(function(result){
			$scope.role = result.role;
			console.log(result);
		}).error(function(error){
			
		});
})

clinic.controller('igCtrl', function ($scope, $http, $cookies) {

    $scope.email = "";
    $scope.pwd = "";
    $scope.loggedIn = $cookies.get('token') ? true : false;
    $scope.loggingIn = false;

    $scope.showLogin = function () {
        $scope.loggingIn = true;
    };

    $scope.logout = function () {
        // do your logout logic
        $scope.user = null;
        $scope.loggedIn = false;
        $cookies.remove('token');
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
'		   	 <div class="login_header">Logowanie</div>' +
'          </div>' +
'          <div class="modal-body">' +
'            <table border="0"><tr><td></td><td><input type="text" ng-model="email" placeholder="Pesel:"></input> </td></tr> ' +
'            <tr><td></td><td><input type="password" ng-model="pwd" placeholder="Password:"> </input></td></tr>' +
'            <tr><td colspan="2"><input type="submit" class="btn login_submit" id="submit" ng-click="submit()" value="Login"></input></td></tr> ' +
'			 <tr><td colspan="2"><button type="button" class="btn login_cancel" data-dismiss="modal" aria-hidden="true" ng-click="cancel()">Anuluj</button></td></tr> ' +
'			 <tr><td colspan="2"><button type="button" class="btn login_forgotten" data-dismiss="modal" aria-hidden="true" ng-click="cancel()">Nie pamiętasz hasła?</button></td></tr></table> ' +
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