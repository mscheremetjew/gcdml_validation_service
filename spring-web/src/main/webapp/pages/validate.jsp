<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Upload Example</title>
</head>
<body>
<form:form modelAttribute="uploadItem" method="post" action="validate/doValidation" enctype="multipart/form-data">
    <fieldset>
        <legend>Upload Fields</legend>

        <p>
            <form:label for="fileData" path="fileData">File</form:label><br/>
            <form:input path="fileData" type="file"/>
        </p>

        <p>
            <input type="submit"/>
        </p>

    </fieldset>
</form:form>
<fieldset>
    <legend>File Name</legend>

    <p>${name}</p>

</fieldset>
</body>
</html>