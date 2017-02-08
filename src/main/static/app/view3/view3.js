'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])
.controller('View3Ctrl', ['$scope', 'fabrica', 'Tasks', 'orderByFilter', function($scope, fabrica, Tasks, orderBy){
    //$scope.listado=fabrica.getListado();

    $scope.listado = Tasks.query();
    
    $scope.key = 'priority';
    $scope.reverse = true;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = (propertyName !== null && $scope.key === propertyName)
            ? !$scope.reverse : false;
        $scope.key = propertyName;
    };
}]);
