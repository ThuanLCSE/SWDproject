angular.module('blog').factory('BlogService', 
	['$resource',
	 function($resource) {
	// Use the '$resource' service to return an article '$resource' object
    return $resource('api/blog/:action/:blogId/:userId', 
    	null,
    	{
        showAll: {
            method: 'POST',
            isArray: true
        },
        showMyDraft: {
            method: 'POST',
            isArray: true
        }, showMyBlog: {
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
        },
        updateBlog:{
        	 method:'POST' 
        },
        hideBlog:{
        	method:'POST' 
       }
    });
}]);