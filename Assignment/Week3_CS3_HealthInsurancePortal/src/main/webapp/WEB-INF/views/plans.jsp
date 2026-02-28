<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Available Insurance Plans</h2>

<form action="apply" method="post">
    <input type="radio" name="planName" value="Basic Health Plan"/> Basic Health Plan <br>
    <input type="radio" name="planName" value="Premium Health Plan"/> Premium Health Plan <br>
    <input type="radio" name="planName" value="Family Coverage Plan"/> Family Coverage Plan <br><br>

    <input type="submit" value="Apply"/>
</form>

</body>
</html>