'use strict';

/**
 * @author
 *
 */

app.service('EmergencyContactService', ['$http', '$q', function($http, $q) {

	return {
		saveData: function(data) {
					return $http.post('../client/save-emergencycontact', data)
					.then(
						function(response) {
							return response.data;
						},
						function(errResponse){
							console.error('Error while creating record');
							return $q.reject(errResponse);
						}
			);
		},
		delete: function(id) {
			return $http.delete('../client/delete-emergencycontact/'+id)
			.then(
				function(response) {
					return response.data;
				},
				function(errResponse){
					console.error('Error while deleting record');
					return $q.reject(errResponse);
				}
			);
		},
		fetchAllData:function() {
			return $http.get('../client/get-emergencycontact-data')
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching Data');
						return $q.reject(errResponse);
					}
			);

		}
	};

}]);
