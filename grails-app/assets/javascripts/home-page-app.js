//= require jquery
//= require grails-angularjs

var homePageApp = angular.module('homePageApp', []);

homePageApp.config(function ($httpProvider) {
  var addCsrfHeader = function(data, headersGetter) {
    var headers = headersGetter();

    var csrfTokenValue = $('meta[name=csrfToken]').attr("content");

    console.log('adding header', csrfTokenValue);

    headers['X-Csrf-Token'] = csrfTokenValue;

    return data;
  };

  $httpProvider.defaults.transformRequest.push(addCsrfHeader);
});

homePageApp.controller('homePageCtrl', function($http, $scope) {
  $http.get('/grails-angular-csrf/person/index').then(function(response) {
    $scope.people = response.data;
  });
});