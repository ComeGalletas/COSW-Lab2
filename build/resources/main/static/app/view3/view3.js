'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])
.controller('View3Ctrl', ['$scope', 'fabrica',  'orderByFilter', function($scope, fabrica, orderBy){
    $scope.listado=fabrica.getListado();
    
    $scope.key = 'priority';
    $scope.reverse = true;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = (propertyName !== null && $scope.key === propertyName)
            ? !$scope.reverse : false;
        $scope.key = propertyName;
    };
}]);
