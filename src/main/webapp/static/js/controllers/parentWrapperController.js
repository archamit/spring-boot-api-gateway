app.controller('parentWrapper', ['$scope','$http','localStorageService','$location','$route', function($scope, $http, localStorageService, $location, $route){
  console.log("Works");
  $scope.testData = "something";
  $scope.user = {};

  $scope.userLoggedIn = function(){
    if(localStorageService.get('user')){
      return true;
    }else{
      return false;
    }
  }

  $scope.checkAuth = function(){
    $http.get('https://api.github.com/users/shrikarch').then(function(response){
      processLogin($scope.user.email);
    }, function(error){
      console.log("Auth Failed");
    })
  }

  $scope.checkLocation = function(path){
    if($location.path() == path){
      return true;
    }else{
      return false;
    }
  }

  function processLogin(userEmail){
    localStorageService.set('user', userEmail);
    // console.log('retrievedObject: ' + localStorageService.get("user"));
  }

}]);
