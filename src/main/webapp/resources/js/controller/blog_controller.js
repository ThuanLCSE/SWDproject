angular.module('blog').controller('BlogController', ['$scope', 'BlogService','UserService', 'LikeService','CommentService',
    function($scope, BlogService, UserService,LikeService,CommentService) {
		$scope.blogView = {
			currentUserID: '',
			currentUserFullname: '',
			url: 'resources/blog/list.html',
			listType : ''
		}
		$scope.blogDto = {
				title: '',
				content: '',
				imageUrl: ''
		};
		$scope.commentDto = {
				content : '',
				blogId: ''
		}
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
			$scope.blogView.listType = 'publish';
			BlogService.showAll({
		                action: 'all'
	      },null
	      , function(response) {
	    	  $scope.blogs = response;
              
            }, function(errorResponse) {
            	 console.log(errorResponse);
            });
		};

        
        $scope.showMyDraft = function(){
			$scope.blogView.url = 'resources/blog/list.html';
			$scope.blogView.listType = 'draft';
			BlogService.showMyBlog({
		                action: 'myDraft' 
	      },null
	      , function(response) {
	    	  $scope.blogs = response;
              
            }, function(errorResponse) {
            	 console.log(errorResponse);
            });
		};
		$scope.showMyBlog = function(){
			$scope.blogView.url = 'resources/blog/list.html';
			$scope.blogView.listType = 'publish';
			BlogService.showMyBlog({
		                action: 'myAll' 
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
		$scope.viewDetailBlog = function(currentBlogId){
			$scope.blogView.url = 'resources/blog/detail.html';
			BlogService.viewDetail({
		                action: 'detail',
		                blogId: currentBlogId
	      },null
	      , function(response) {
	    	  $scope.blogDetail = response;
	    	  $scope.listComment();
            }, function(errorResponse) {
            	 console.log(errorResponse);
            });
		};
		$scope.editBlog = function(){
			$scope.blogView.url = 'resources/blog/edit.html'; 
			$scope.blogDto.blogID = $scope.blogDetail.blogID;
			$scope.blogDto.title = $scope.blogDetail.title;
			$scope.blogDto.content = $scope.blogDetail.content;
			$scope.blogDto.imageUrl = $scope.blogDetail.imageUrl; 
		}
		$scope.sendUpdateBlog = function(){
			BlogService.updateBlog({
                action: 'edit',
                blogId: $scope.blogDto.blogID
			  },$scope.blogDto 
			  , function(response) {
				  $scope.blogView.url = 'resources/blog/list.html';
				  $scope.showAllBlog(); 
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		}
		$scope.hideBlog = function(){
			BlogService.hideBlog({
                action: 'hide',
                blogId: $scope.blogDetail.blogID
			  },null
			  , function(response) {
				  $scope.blogView.url = 'resources/blog/list.html';
				  $scope.showAllBlog(); 
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		}
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
		};
		$scope.likeBlog = function(){
			var likeData = {
					blogID : $scope.blogDetail.blogID
			}
			LikeService.userLikeBlog({
                action: 'create'
			  },likeData
			  , function(response) {
				  console.log(response);
				  if (response.state == 200){ 
					  $scope.blogDetail.numberOfLike += 1;
				  }
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		};
		$scope.commentBlog = function(){
			$scope.commentDto.blogId = $scope.blogDetail.blogID;
			
			CommentService.userCommentBlog({
                action: 'create'
			  },$scope.commentDto
			  , function(response) {
				  
				  if (response.state == 200){ 
					  $scope.blogDetail.numberOfComment += 1;
					  $scope.listComment();
				  }
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		}
		$scope.listComment = function(){ 
			CommentService.getListComment({
                action: 'listComment',
                blogId: $scope.blogDetail.blogID
			  }, null
			  , function(response) {
				 
				  $scope.commentList = response;
			    }, function(errorResponse) {
			    	 console.log(errorResponse);
			    });
		}
}]);
