angular.module('blog').factory('CommentService', 
    ['$resource',
     function($resource) {
    // Use the '$resource' service to return an article '$resource' object
    return $resource('api/comment/:action/:blogId/:commentId', 
        null,
        {
        userCommentBlog: {
            method: 'POST' 
        }, 
        userRemoveComment:{
            method:'POST' 
        },
        getListComment:{
        	method: 'POST',
        	isArray: true
        }
    });
}]);