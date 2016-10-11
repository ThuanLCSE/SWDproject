angular.module('blog').factory('LikeService', 
	['$resource',
	 function($resource) {
	// Use the '$resource' service to return an article '$resource' object
    return $resource('api/like/:action/', 
    	null,
    	{
        userLikeBlog: {
            method: 'POST' 
        }, 
        userUnlikeBlog:{
            method:'POST' 
        }
    });
}]);