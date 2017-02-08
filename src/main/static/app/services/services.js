'use strict';
angular.module('services.listFactory', ['ngRoute', 'ngResource'])

    .factory('fabrica', function () {
        var data = {
            listado: []
        };
        return {
            getListado: function () {
                return data.listado;
            },
            addTodo: function (todo) {
                data.listado.push(todo);
            }};
    })
    .factory('Tasks', function($resource) {
        return $resource('/app/tasks');
    })
    .factory("Task", function ($resource) {
        return $resource("/app/tasks",{
                method: 'POST'
            }
        );
    });