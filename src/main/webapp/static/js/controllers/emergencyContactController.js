'use strict';


/**
 * @author
 *
 */

app.controller('EmergencyContactController',['$scope', 'EmergencyContactService', function($scope, emergencyContactService) {
	  var self = this;

	  self.emergencyContactData={id:null,firstName:null,lastName:null,phoneNo:null,address:null,zip:null};
	  self.emergencyContactList=[];
	  /**
		 *
		 * @return companies
		 */

	  self.fetchAllData = function() {
		  emergencyContactService.fetchAllData().then(function(response) {
		       self.emergencyContactList = response;
		    },
			function(errResponse) {
				console.log(errResponse);
			});
   };



      /**
  	 * @param companyProfile
  	 * @return
  	 */

      self.saveData = function(emergencyContactData) {
    	  emergencyContactService.saveData(emergencyContactData).then(function(response) {
		        self.emergencyContactData = response;
		        self.fetchAllData();
		        self.reset();
		       },
			function(errResponse) {
		    	   console.log(errResponse);
			});
	  };

	  /**
	  	 * @param emergencyContact
	  	 * @return
	  	 */
	  self.checkedRdo = function (response) {
		  self.emergencyContactData = response;	        
	  };

	  /**
		 *
		 * @return
		 */

	  self.submit = function() {
		  self.saveData(self.emergencyContactData);
      };



	  /**
		 *
		 * @return
		 */

	  self.delete = function(id) {
		  emergencyContactService.delete(id).then(function(response) {
			  self.fetchAllData();
		    },
			function(errResponse) {
				console.log(errResponse);
			});
   };



	  /**
		 *
		 * @return
		 */

	  self.reset = function(){
		  self.emergencyContactData={id:null,firstName:null,lastName:null,phoneNo:null,address:null,zip:null};
	      $scope.myForm.$setPristine(); //reset Form
	  };


}]);
