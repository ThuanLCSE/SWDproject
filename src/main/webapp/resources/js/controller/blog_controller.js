angular.module('blog').controller('BlogController', ['$scope', 'BlogService','UserService',
    function($scope, BlogService, UserService) {
		$scope.blogView = {
				currentUserID: '',
				currentUserFullname: '',
			url: 'resources/blog/list.html'
		}
		$scope.blogDto = {
				title: '',
				content: '',
				imageUrl: ''
		};
		UserService.getAuthInfo({
            action: 'current'
	      },null
	      , function(response) {
	    	  $scope.blogView.currentUserID = response.userID;
	    	  $scope.blogView.currentUserFullname = response.fullname; 
          }, function(errorResponse) {
          	 console.log(errorResponse);
          });
		$scope.showAllBlog = function(){
			$scope.blogView.url = 'resources/blog/list.html';
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
			$scope.blogView.url = 'resources/blog/list.html';
			BlogService.showMyBlog({
		                action: 'all',
		                userId: $scope.blogView.currentUserID
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
		};
		$scope.saveDraftBlog = function(){
			BlogService.saveDraftBlog({
                action: 'create/draft'
			  },$scope.blogDto 
			  , function(response) {
				  $scope.blogView.url = 'resources/blog/list.html';
				  $scope.showMyBlog(); 
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		}
}]);
