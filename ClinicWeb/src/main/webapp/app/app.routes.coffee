angular.module 'clinic'
  .config ($stateProvider, $urlRouterProvider, $locationProvider) ->
    'ngInject'
    $stateProvider
      .state 'home',
        url: '/'
        templateUrl: '/app/components/home/home.html'
        controller: 'HomeController'
        controllerAs: 'home'
      .state 'login',
        url: '/login'
        controller: 'LoginController'
        controllerAs: 'login'
      .state 'register',
        url: '/register'
        templateUrl: '/app/components/register/register.html'
        controller: 'RegisterController'
        constrollerAs: 'register'
      .state 'password_reset',
        url: '/password_reset'
        templateUrl: '/app/components/password_reset/password_reset.html'
      .state 'logout',
        url: '/logout'
      .state 'contact',
        url: '/contact'
        templateUrl: '/app/components/contact/contact.html'
        controller: 'ContactController'
        controllerAs: 'contact'
      .state 'visits',
        url: '/visits'
        abstract: true
        controller: 'VisitsController'
        controllerAs: 'visits'
        template: '<div ui-view></div>'
      .state 'visits.new',
        url: '/new?speciality&doctor&date'
        templateUrl: 'app/components/visits/newVisit.html'
        controller: 'VisitsController'
        controllerAs: 'visits'
      .state 'specialties',
        url: '/specialties'
        templateUrl: '/app/components/specialties/specialties.html'
        controller: 'SpecialtiesController'
        controllerAs: 'specialties'
      .state 'doctors',
        url: '/doctors'
        templateUrl: '/app/components/doctors/doctors.html'
        controller: 'DoctorsController'
        constrollerAs: 'doctors'
      .state 'doctors.detail',
        url: '/:slug'
        templateUrl: '/app/components/doctors/doctor.html'
      .state 'doctors.details.calendar',
        url: '/calendar'
        template: '/app/components/doctors/calendar.html'
      .state 'patient',
        url: '/patient'
        template: '<div ui-view>ddd</div>'
      .state 'patient.change_password',
        url: '/change_password'
      .state 'patient.edit',
        url: '/edit'
      .state 'patient.visits',
        url: '/visits'
        templateUrl: '/app/components/patient/patient.visits.html'
      .state 'patient.visits.show',
        url: '/:id'
      .state 'patient.visits.delete',
        url: '/:id/delete'
      .state 'patient.visits.edit',
        url: '/:id/edit'
      .state 'doctor',
        url: '/doctor'
        templateUrl: 'app/components/doctor/panel.html'
      .state 'doctor-patients',
        url: '/doctor/patients'
        templateUrl: 'app/components/doctor/patients.html'
        controller: 'DoctorPatientsController'
        controllesAs: 'doctor.patients'
      .state 'doctor-patients-new',
        url: '/doctor/patients/new'
        templateUrl: 'app/components/doctor/patients.new.html'
      .state 'doctor-patients-show',
        url: '/doctor/patients/:patientId/show'
        templateUrl: 'app/components/doctor/patients.show.html'
        controller: 'DoctorPatientsController'
        controllerAs: 'doctor.patients.show'
      .state 'doctor.edit',
        url: '/edit'
      .state 'doctor.calendar',
        url: '/calendar'
      .state 'doctor.calendar.edit',
        url: '/edit'
      .state 'doctor.visits',
        url: '/visits'
      .state 'doctor.visits.show',
        url: '/:id'
      .state 'doctor.visits.edit',
        url: '/:id/edit'
      .state 'doctor.visits.comments.new',
        url: '/:id/comments/new'
      .state 'admin',
        url: '/admin'
        templateUrl: 'app/components/admin/panel.html'
      .state 'admin-doctors',
        url: '/admin/doctors'
        templateUrl: 'app/components/admin/doctors.html'
        controller: 'AdminDoctorsController'
        controllesAs: 'admin.doctors'
      .state 'admin-doctors-new',
        url: '/admin/doctors/new'
        templateUrl: 'app/components/admin/doctors.new.html'
        controller: 'AdminDoctorsController'
        controllesAs: 'admin.doctors'
      .state 'admin-doctors-show',
        url: '/admin/doctors/:doctorId/show'
        templateUrl: 'app/components/admin/doctors.show.html'
        controller: 'AdminDoctorsController'
        controllerAs: 'admin.doctors.details'
      .state 'admin-doctors-remove',
        url: '/admin/doctors/:doctorId/remove'
        controller: 'AdminDoctorsController'
        controllerAs: 'admin.doctors.remove'
      .state 'admin-doctors-edit',
        url: '/admin/doctors/:doctorId/edit'
        controller: 'AdminDoctorsController'
        controllerAs: 'admin.doctors.edit'
        templateUrl: 'app/components/admin/doctors.edit.html'
      .state 'admin-doctors-visits',
        url: '/admin/doctors/:doctorId/visits'
        controller: 'AdminDoctorsVisitsController'
        controllerAs: 'admin.doctors.visits.index'
        templateUrl: 'app/components/admin/doctors.visits.html'
      .state 'admin-patients',
        url: '/admin/patients'
        templateUrl: 'app/components/admin/patients.html'
        controller: 'AdminPatientsController'
        controllerAs: 'admin.patients'
      .state 'admin-patients-new',
        url: '/admin/patients/new'
        templateUrl: 'app/components/admin/patients.new.html'
      .state 'admin-patients-show',
        url: '/admin/patients/:patientId/show'
        templateUrl: 'app/components/admin/patients.show.html'
        controller: 'AdminPatientsController'
        controllerAs: 'admin.patients.show'
      .state 'admin-patients-edit',
        url: '/admin/patients/:patientId/edit'
        controller: 'AdminPatientsController'
        controllerAs: 'admin.patients.edit'
        templateUrl: 'app/components/admin/patients.edit.html'
      .state 'admin-patients-visits',
        url: '/admin/patients/:patientId/visits'
        controller: 'AdminPatientsVisitsController'
        controllerAs: 'admin.patients.visits.index'
        templateUrl: 'app/components/admin/patients.visits.html'
      .state 'admin-patients-remove',
        url: '/admin/patients/:patientId/remove'
        controller: 'AdminPatientsController'
        controllerAs: 'admin.patients.remove'
      .state 'admin-receptionists',
        url: '/admin/receptionists'
        templateUrl: 'app/components/admin/receptionists.html'
        controller: 'AdminReceptionistsController'
        controllerAs: 'admin.receptionists'
      .state 'admin-receptionists-new',
        url: '/admin/receptionists/new'
        templateUrl: 'app/components/admin/receptionists.new.html'
        controller: 'AdminReceptionistsController'
        controllesAs: 'admin.receptionists'
      .state 'admin-receptionists-show',
        url: '/admin/receptionists/:receptionistId/show'
        templateUrl: 'app/components/admin/receptionists.show.html'
        controller: 'AdminReceptionistsController'
        controllerAs: 'admin.receptionists.show'
      .state 'admin-receptionists-edit',
        url: '/admin/receptionists/:receptionistId/edit'
        templateUrl: 'app/components/admin/receptionists.edit.html'
        controller: 'AdminReceptionistsController'
        controllerAs: 'admin.receptionists.edit'
      .state 'admin-specialities',
        url: '/admin/specialities'
        templateUrl: 'app/components/admin/specialities.html'
        controller: 'AdminSpecialitiesController'
        controllerAs: 'admin.specialities'
      .state 'admin-visits',
        url: '/admin/visits'
        templateUrl: 'app/components/admin/visits.html'
        controller: 'AdminVisitsController'
        controllerAs: 'admin.visits.index'
      .state 'admin-visits-show',
        url: '/admin/visits/:visitId/show'
        templateUrl: 'app/components/admin/visits.show.html'
        controller: 'AdminVisitsController'
        controllesAs: 'admin.visits.show'
      .state 'admin-visits-new',
        url: '/admin/visits/new'
        templateUrl: 'app/components/admin/visits.new.html'
        controller: 'AdminVisitsController'
        controllerAs: 'admin.visits.new'
      .state 'receptionist',
        url: '/receptionist'
        templateUrl: 'app/components/receptionist/panel.html'
      .state 'receptionist-doctors',
        url: '/receptionist/doctors'
        templateUrl: 'app/components/receptionist/doctors.html'
        controller: 'ReceptionistDoctorsController'
        controllesAs: 'receptionist.doctors'
      .state 'receptionist-doctors-new',
        url: '/receptionist/doctors/new'
        templateUrl: 'app/components/receptionist/doctors.new.html'
        controller: 'ReceptionistDoctorsController'
        controllesAs: 'receptionist.doctors'
      .state 'receptionist-doctors-show',
        url: '/receptionist/doctors/:doctorId/show'
        templateUrl: 'app/components/receptionist/doctors.show.html'
        controller: 'ReceptionistDoctorsController'
        controllerAs: 'receptionist.doctors.details'
      .state 'receptionist-doctors-remove',
        url: '/receptionist/doctors/:doctorId/remove'
        controller: 'ReceptionistDoctorsController'
        controllerAs: 'receptionist.doctors.remove'
      .state 'receptionist-doctors-edit',
        url: '/receptionist/doctors/:doctorId/edit'
        controller: 'ReceptionistDoctorsController'
        controllerAs: 'receptionist.doctors.edit'
        templateUrl: 'app/components/receptionist/doctors.edit.html'
      .state 'receptionist-doctors-visits',
        url: '/receptionist/doctors/:doctorId/visits'
        controller: 'ReceptionistDoctorsVisitsController'
        controllerAs: 'receptionist.doctors.visits.index'
        templateUrl: 'app/components/receptionist/doctors.visits.html'
      .state 'receptionist-patients',
        url: '/receptionist/patients'
        templateUrl: 'app/components/receptionist/patients.html'
        controller: 'ReceptionistPatientsController'
        controllerAs: 'receptionist.patients'
      .state 'receptionist-patients-new',
        url: '/receptionist/patients/new'
        templateUrl: 'app/components/receptionist/patients.new.html'
      .state 'receptionist-patients-show',
        url: '/receptionist/patients/:patientId/show'
        templateUrl: 'app/components/receptionist/patients.show.html'
        controller: 'ReceptionistPatientsController'
        controllerAs: 'receptionist.patients.show'
      .state 'receptionist-patients-edit',
        url: '/receptionist/patients/:patientId/edit'
        controller: 'ReceptionistPatientsController'
        controllerAs: 'receptionist.patients.edit'
        templateUrl: 'app/components/receptionist/patients.edit.html'
      .state 'receptionist-patients-visits',
        url: '/receptionist/patients/:patientId/visits'
        controller: 'ReceptionistPatientsVisitsController'
        controllerAs: 'receptionist.patients.visits.index'
        templateUrl: 'app/components/receptionist/patients.visits.html'
      .state 'receptionist-specialities',
        url: '/receptionist/specialities'
        templateUrl: 'app/components/receptionist/specialities.html'
        controller: 'ReceptionistSpecialitiesController'
        controllerAs: 'receptionist.specialities'
      .state 'receptionist-visits',
        url: '/receptionist/visits'
        templateUrl: 'app/components/receptionist/visits.html'
        controller: 'ReceptionistVisitsController'
        controllerAs: 'receptionist.visits.index'
      .state 'receptionist-visits-show',
        url: '/receptionist/visits/:visitId/show'
        templateUrl: 'app/components/receptionist/visits.show.html'
        controller: 'ReceptionistVisitsController'
        controllesAs: 'receptionist.visits.show'
      .state 'receptionist-visits-new',
        url: '/receptionist/visits/new'
        templateUrl: 'app/components/receptionist/visits.new.html'
        controller: 'ReceptionistVisitsController'
        controllerAs: 'receptionist.visits.new'
    $urlRouterProvider.otherwise '/'
