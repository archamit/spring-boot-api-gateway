'use strict';


/**
 * @author
 *
 */

app.controller('NomineesDetailController',['$scope', 'NomineesDetailService', function($scope, nomineesDetailService) {
	  var self = this;

	  self.nomineesDetailData={id:null,firstName:null,lastName:null,phoneNo:null,address:null,zip:null};
	  self.nomineesDetailList=[];
	  /**
		 *
		 * @return companies
		 */

	  self.fetchAllData = function() {
		  nomineesDetailService.fetchAllData().then(function(response) {
		       self.nomineesDetailList = response;
		    },
			function(errResponse) {
				console.log(errResponse);
			});
   };



      /**
  	 * @param companyProfile
  	 * @return
  	 */

      self.saveData = function(nomineesDetailData) {
    	  nomineesDetailService.saveData(nomineesDetailData).then(function(response) {
		        self.nomineesDetailData = response;
		        self.fetchAllData();
		        self.reset();
		       },
			function(errResponse) {
		    	   console.log(errResponse);
			});
	  };
	  
	  /**
	  	 * @param nomineesDetailData
	  	 * @return
	  	 */
	  self.checkedRdo = function (response) {
		  self.nomineesDetailData = response;	        
	  };

	  /**
		 *
		 * @return
		 */

	  self.submit = function() {
		  self.saveData(self.nomineesDetailData);
      };

      /**
		 *
		 * @return
		 */

	  self.delete = function(id) {
		  nomineesDetailService.delete(id).then(function(response) {
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
		  self.nomineesDetailData={id:null,firstName:null,lastName:null,phoneNo:null,address:null,zip:null};
	      $scope.myForm.$setPristine(); //reset Form
	  };


}]);
