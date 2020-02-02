<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Guest book</title>
</head>
<body>

<h1>Guest book</h1>
<form action="/feedback" method="post">
    <p><input type="submit" name="logout" value="logout"></p>
    <p>Name: <%= request.getAttribute("name") %></p>
    <p><textarea placeholder="Your feedback here..." name="text"></textarea></p>
    <p>Rank:
        <select name="rank">
            <option value="5" selected>5</option>
            <option value="4">4</option>
            <option value="3">3</option>
            <option value="2">2</option>
            <option value="1">1</option>
        </select>
    </p>
    <p><input type="submit" name="submit" value="submit"></p>
</form>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <th>Name</th>
        <th>Feedback</th>
        <th>Rank</th>
    </tr>
    <c:forEach var="feedback" items="${feedbackList}">
        <tr>
            <td>${feedback.name}</td>
            <td>${feedback.text}</td>
            <td>${feedback.rank}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
