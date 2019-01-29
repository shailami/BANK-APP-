<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<form action="fundTransfer">
ENTER SENDER'S ACCOUNT NUMBER:
<input TYPE="number" name="senderAccountNumber"><br>
ENTER RECEIVER'S ACCOUNT NUMBER:
<input TYPE="number" name="receiverAccountNumber"><br>
Enter Amount:
<input type="number" name="amount"><br>
<input type="submit" name="submit">
</form>
</body>
</html>