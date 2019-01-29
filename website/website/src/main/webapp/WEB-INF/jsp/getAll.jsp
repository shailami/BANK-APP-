<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<!-- <form action="allTransaction"> -->
		<table>
		<tr>
		<th>transactionId</th>
		<th>accountNumber</th>
		<th>amount</th>
		<th>transactionType</th>
		<th>transactionDate</th>
		<th>transactionDetails</th>
		<th>currentBalance</th>
		</tr>

			<%-- <jstl:if test="${!(transactionList==null)}"> --%>
				<jstl:forEach var="transaction" items="${transactionList}">
					<tr>
						<td>${transaction.transactionId}</td>
						<td>${transaction.accountNumber}</td>
						<td>${transaction.amount}</td>
						<td>${transaction.transactionType}</td>
						<td>${transaction.transactionDate}</td>
						<td>${transaction.transactionDetails}</td>
						<td>${transaction.currentBalance}</td>
					</tr>
				</jstl:forEach>
			<%-- </jstl:if> --%>
		</table>
		<!-- <input type="submit" name="submit"> -->
	<!-- </form> -->
</body>
</html>
