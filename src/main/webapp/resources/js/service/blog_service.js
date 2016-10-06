angular.module('blog').factory('BlogService', 
	['$resource',
	 function($resource) {
	// Use the '$resource' service to return an article '$resource' object
    return $resource('api/blog/:action/:blogId', 
    	null,
    	{
        showAll: {
            method: 'POST',
            isArray: true
        },
        viewDetail:{
            method:'POST'
        },
        viewComment:{
            method:'POST',
            isArray: true
        },
        saveBlog:{
            method:'POST' 
        },
        saveDraftBlog:{
            method:'POST' 
        }
    });
}]);