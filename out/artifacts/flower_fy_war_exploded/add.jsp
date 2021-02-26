<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>花卉</title>
    <base href="<%=request.getContextPath() + "/"%>">
</head>
<body>
<%--
注意：
A:method="post" 因为get提交是有大小限定的
B:enctype:内容传输的类型
       application/x-www-form-urlencodeed(默认值：按照普通文本传递)
       multipart/form-data:把传递的数据转化成二进制流方式进行传递
--%>
    <center>
        <h1>花卉添加</h1>
        <hr/>
    <form action="FlowerFileUploadServlet" method="post" enctype="multipart/form-data">
        <p>
            花卉名称:<input type="text" name="name"/>
        </p>
        <p>
            花卉价格:<input type="text" name="price"/>
        </p>
        <p>
            花卉产地:<input type="text" name="production"/>
        </p>
        <p>
            花卉图片:<input type="file" name="picture"/><span style="color: red">${requestScope.msg}</span>
        </p>
        <p>
            <input type="submit" value="提交"/>
        </p>
    </form>
    </center>
</body>
</html>
