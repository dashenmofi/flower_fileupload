<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() + "/"%>">
</head>
<body>
    <center>
        <h1>主页面</h1>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>花卉名称</th>
                    <th>花卉价格</th>
                    <th>花卉产地</th>
                    <th>花卉图片</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.flowers}" var="flower">
                    <tr>
                        <th>${flower.name}</th>
                        <th>${flower.price}</th>
                        <th>${flower.production}</th>
                        <th><img src="imgs/${flower.filename}" style="width: 60px;height: 60px"></th>
                        <th><a href="FlowerDownload?filename=${flower.filename}&filetype=${flower.filetype}">下载</a></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </center>
</body>
</html>
