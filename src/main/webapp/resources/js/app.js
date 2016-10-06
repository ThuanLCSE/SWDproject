'use strict';

var mainApplicationModuleName = 'myApp';

var mainApplicationModule = angular.module(mainApplicationModuleName, 
	['ngResource', 'ngRoute', 'blog']);
angular.module('blog', []);