'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'login.login',
  'myApp.view1',
  'myApp.view1',
  'myApp.view2',
  'myApp.view3',
  'myApp.version',
  'services.listFactory'
])
.config(['$locationProvider','$routeProvider','$httpProvider',function($locationProvider, $routeProvider, $httpProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/login'});
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])
.controller('LogOutController', function($rootScope, $scope, $http, $location) {

    $scope.logout = function () {
        $http.post('/logout', {}).success(function () {
            $rootScope.authenticated = false;
            $location.path("/");
        }).error(function (data) {
            $rootScope.authenticated = false;
        });
    };
});