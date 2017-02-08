'use strict';

angular.module('login.login', [ 'ngRoute' ])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'login/login.html',
    controller: 'LogInController'
  });
}])
.controller('LogInController', function($rootScope, $scope, $http, $location) {

  var authenticate = function (credentials, callback) {
      var headers = credentials ? {authorization: "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};

      $http.get('user', {headers: headers}).success(function (data) {
          if (data.name) {
              $rootScope.authenticated = true;
          } else {
              $rootScope.authenticated = false;
          }
          callback && callback();
      }).error(function () {
          $rootScope.authenticated = false;
          callback && callback();
      });
  };

  authenticate();
  $scope.credentials = {};
  $scope.login = function () {
      authenticate($scope.credentials, function () {
          if ($rootScope.authenticated) {
              $location.path("/");
              $scope.error = false;
          } else {
              $location.path("/login");
              $scope.error = true;
          }
      });
  };
});