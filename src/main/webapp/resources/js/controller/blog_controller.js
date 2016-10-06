angular.module('blog').controller('BlogController', ['$scope', 'BlogService',
    function($scope, BlogService) {
		$scope.blogView = {
			url: 'resources/blog/list.html'
		}
		$scope.blogDto = {
				title: '',
				content: '',
				imageUrl: ''
		};
		$scope.showAllBlog = function(){
			BlogService.showAll({
		                action: 'all'
	      },null
	      , function(response) {
	    	  $scope.blogs = response;
              
            }, function(errorResponse) {
            	 console.log(errorResponse);
            });
		};
		$scope.showMyBlog = function(){
			BlogService.showMyBlog({
		                action: 'all'
	      },null
	      , function(response) {
	    	  $scope.blogs = response;
              
            }, function(errorResponse) {
            	 console.log(errorResponse);
            });
		};
		$scope.createBlog = function(){
			$scope.blogView.url = 'resources/blog/create.html';
		}
		$scope.viewDetailBlog = function(blogIndex){
			$scope.blogView.url = 'resources/blog/detail.html';
			BlogService.viewDetail({
		                action: 'detail',
		                blogId: $scope.blogs[blogIndex].blogID
	      },null
	      , function(response) {
	    	  $scope.blogDetail = response;
              
            }, function(errorResponse) {
            	 console.log(errorResponse);
            });
		};
		
		$scope.postBlog = function(){
			 
			BlogService.saveBlog({
                action: 'create'
			  },$scope.blogDto 
			  , function(response) {
				  $scope.blogView.url = 'resources/blog/list.html';
				  $scope.showMyBlog(); 
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		}
}]);
