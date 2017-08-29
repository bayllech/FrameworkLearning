<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple/><br/>
    <input type="submit" />
</form>
</body>
</html>
