'use strict';


/**
 * @author
 *
 */

app.controller('UserDetailsController',['$scope', 'UserDetailsService', function($scope, userDetailsService) {
	  var self = this;

	  self.userDetailsData={id:null,firstName:null,lastName:null,phoneNo:null,address:null,zip:null};
	  self.userDetailsList=[];
	  /**
		 *
		 * @return companies
		 */

	  self.fetchAllData = function() {
		  userDetailsService.fetchAllData().then(function(response) {
		       self.userDetailsList = response;
		    },
			function(errResponse) {
				console.log(errResponse);
			});
   };



      /**
  	 * @param companyProfile
  	 * @return
  	 */

      self.saveData = function(userDetailsData) {
    	  userDetailsService.saveData(userDetailsData).then(function(response) {
		        self.userDetailsData = response;
		        self.fetchAllData();
		        self.reset();
		       },
			function(errResponse) {
		    	   console.log(errResponse);
			});
	  };
	  
	  /**
		 *
		 * @return
		 */

	  self.delete = function(id) {
		  userDetailsService.delete(id).then(function(response) {
			  self.fetchAllData();
		    },
			function(errResponse) {
				console.log(errResponse);
			});
	  	};
	  
	  /**
	  	 * @param userdetails
	  	 * @return
	  	 */
	  self.checkedRdo = function (response) {
		  self.userDetailsData = response;	        
	  };

	  /**
		 *
		 * @return
		 */

	  self.submit = function() {
		  self.saveData(self.userDetailsData);
      };



	  /**
		 *
		 * @return
		 */

	  self.reset = function(){
		  self.userDetailsData={id:null,firstName:null,lastName:null,phoneNo:null,address:null,zip:null};
	      $scope.myForm.$setPristine(); //reset Form
	  };


}]);
