(function() {
  angular.module('clinic').config(function($stateProvider, $urlRouterProvider, $locationProvider) {
    'ngInject';
    $stateProvider.state('home', {
      url: '/',
      templateUrl: '/app/components/home/home.html',
      controller: 'HomeController',
      controllerAs: 'home'
    }).state('login', {
      url: '/login',
      controller: 'LoginController',
      controllerAs: 'login'
    }).state('register', {
      url: '/register',
      templateUrl: '/app/components/register/register.html',
      controller: 'RegisterController',
      constrollerAs: 'register'
    }).state('password_reset', {
      url: '/password_reset',
      templateUrl: '/app/components/password_reset/password_reset.html'
    }).state('logout', {
      url: '/logout'
    }).state('contact', {
      url: '/contact',
      templateUrl: '/app/components/contact/contact.html',
      controller: 'ContactController',
      controllerAs: 'contact'
    }).state('visits', {
      url: '/visits',
      abstract: true,
      template: '<div ui-view></div>'
    }).state('visits.new', {
      url: '/new',
      template: '<div>xxxx</div>'
    }).state('specialties', {
      url: '/specialties',
      templateUrl: '/app/components/specialties/specialties.html',
      controller: 'SpecialtiesController',
      controllerAs: 'specialties'
    }).state('doctors', {
      url: '/doctors',
      templateUrl: '/app/components/doctors/doctors.html',
      controller: 'DoctorsController',
      constrollerAs: 'doctors'
    }).state('doctors.detail', {
      url: '/:slug',
      templateUrl: '/app/components/doctors/doctor.html'
    }).state('doctors.details.calendar', {
      url: '/calendar',
      template: '/app/components/doctors/calendar.html'
    }).state('patient', {
      url: '/patient',
      abstract: true,
      conroller: 'PatientController',
      constrollerAs: 'patient',
      template: '<div ui-view></div>'
    }).state('patient.change_password', {
      url: '/change_password'
    }).state('patient.edit', {
      url: '/edit'
    }).state('patient.visits', {
      url: '/visits',
      templateUrl: '/app/components/patient/patient.visits.html'
    }).state('patient.visits.show', {
      url: '/:id'
    }).state('patient.visits.delete', {
      url: '/:id/delete'
    }).state('patient.visits.edit', {
      url: '/:id/edit'
    }).state('doctor', {
      url: '/doctor',
      abstract: true
    }).state('doctor.edit', {
      url: '/edit'
    }).state('doctor.calendar', {
      url: '/calendar'
    }).state('doctor.calendar.edit', {
      url: '/edit'
    }).state('doctor.visits', {
      url: '/visits'
    }).state('doctor.visits.show', {
      url: '/:id'
    }).state('doctor.visits.edit', {
      url: '/:id/edit'
    }).state('doctor.visits.comments.new', {
      url: '/:id/comments/new'
    });
    return $urlRouterProvider.otherwise('/');
  });


  /*
  
  
      - receptionist/settings/change_password
      - receptionist/patients/new
      - receptionist/patients/:id
      - receptionist/patients/:id/edit
      - receptionist/patients/:id/visits/:id/delete
      - receptionist/patients/:id/visits/:id/edit
      - receptionist/patients/:id/card
      - receptionist/doctors/:id/edit
      - receptionist/doctors/:id/calendar
      - receptionist/doctors/:id/calendar/edit
      - receptionist/visits/new
  
      - admin/settings/change_password - admin
      - admin/doctors/new
      - admin/admins/new
      - admin/receptionists/new
      - admin/patients/new
      - admin/patients/:id/edit
      - admin/doctors/:id/edit
      - admin/doctors/:id/calendar
      - admin/doctors/:id/calendar/edit
      - admin/specialties
      - admin/specialties/new
   */

}).call(this);
