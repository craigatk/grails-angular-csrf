<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>List People</title>
</head>

<body>
  <h1>List People</h1>

  <div ng-app="homePageApp">
    <div ng-controller="homePageCtrl">
      <ul id="person_name_list">
        <li ng-repeat="person in people">{{person.firstName}} {{person.lastName}}</li>
      </ul>
    </div>
  </div>
  <asset:javascript src="home-page-app.js"/>
</body>
</html>