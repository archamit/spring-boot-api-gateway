'use strict';


/**
 * @author
 *
 */

app.controller('CarInsuranceContrller',['$scope', 'CarInsuranceService', function($scope, carInsuranceService) {
	  var self = this;

	  self.carInsuranceData={id:null,ownerName:null,carModel:null,carManufacturer:null,manufacturingYear:null,engineCapacity:null,bodyColor:null,currentInsuranceValidTill:null,newInsuranceDate:null};
	  self.carInsuranceList=[];
	  /**
		 *
		 * @return companies
		 */

	  self.fetchAllData = function() {
		  carInsuranceService.fetchAllData().then(function(response) {
		       self.carInsuranceList = response;
		    },
			function(errResponse) {
				console.log(errResponse);
			});
   };



      /**
  	 * @param companyProfile
  	 * @return
  	 */

      self.saveData = function(carInsuranceData) {
    	  	carInsuranceService.saveData(carInsuranceData).then(function(response) {
		        self.carInsuranceData = response;
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
		  self.carInsuranceData = response;	        
	  };


	  /**
		 *
		 * @return
		 */

	  self.submit = function() {
		  self.saveData(self.carInsuranceData);
      };

      /**
		 *
		 * @return
		 */

	  self.delete = function(id) {
		  carInsuranceService.delete(id).then(function(response) {
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
		  self.carInsuranceData={id:null,ownerName:null,carModel:null,carManufacturer:null,manufacturingYear:null,engineCapacity:null,bodyColor:null,currentInsuranceValidTill:null,newInsuranceDate:null};
	      $scope.myForm.$setPristine(); //reset Form
	  };


}]);
