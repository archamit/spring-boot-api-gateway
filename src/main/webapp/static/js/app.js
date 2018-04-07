var app = angular.module('parNorthAm',["ngRoute", "LocalStorageModule"]);

app.config(function($routeProvider) {
  $routeProvider
  .when("/car-insurance-data", {
	controller  : 'CarInsuranceContrller',
    templateUrl : "../car-insurance-data",
  })
  .when("/user-details", {
	controller  : 'UserDetailsController',
    templateUrl : "../user-details"
  })
  .when("/emergency-contact", {
	controller  : 'EmergencyContactController',
	 templateUrl : "../emergency-contact"
  })
  .when("/nominees-contact", {
	 controller  : 'NomineesDetailController',
	 templateUrl : "../nominees-contact"
  })
});
