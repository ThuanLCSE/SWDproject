angular.module('blog').factory('UserService', 
    ['$resource',
     function($resource) { 
    return $resource('api/auth/:action/:userId', 
        null,
        { 
        getAuthInfo:{
            method:'POST' 
        }
    });
}]);