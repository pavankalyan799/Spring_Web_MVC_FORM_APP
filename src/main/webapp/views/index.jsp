<%@ pa ge language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Student Registration form</h3>
<font color="green">${msg}</font>

<form:form  action="save" modelAttribute="student" method="post">
<table>
<tr>
<td>Name</td>
<td><form:input path="name" /></td>
</tr>
<tr>
<td>Email</td>
<td><form:input path="email" /></td>
<tr>
<tr>
<td>Gender</td>
<td><form:radiaobutton path="gender" value="male" />Male
<form:radiaobutton path="gender" value="female" />Fe-Male
</td>
</tr>
<tr>
<td>Course</td>
<td>
<form:select path="corse"> 
<form:option value="">-select-</form:option>/>
<form:options items="${couses}"/>
</form:select>
</td>

</tr>
<tr>
<td>Timings</td>
<td>
<form:checkboxes items="${timings}" path="timings"/>
</td>

</tr>
<tr>
<td></td>
<td>
<input type="sunmit" value="save" />
</td>

</tr>





</table>


</form:form>
</body>
</html>