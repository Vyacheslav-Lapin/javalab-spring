<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- TODO: Try to use tag "spring:message" instead of direct message below-->
    <title>Country :: AddForm</title>

</head>
<body>

<h3><spring:message code="form.addCountry.name"/></h3>
<form:form modelAttribute="countryFormBean">
    <table>
        <tr>
            <!-- TODO: Try to use tag "spring:message" instead of direct message below-->
            <td>First Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red; font-size: small;">
                <form:errors path="name"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="name.last"/></td>
            <td><form:input path="codeName"/></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red; font-size: small;">
                <form:errors path="codeName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save Changes"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>