<%--
  Created by IntelliJ IDEA.
  User: lijx33137
  Date: 2020/12/21
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
    request.getServerName() + ":" +
    request.getServerPort()+
    request.getContextPath() + "/";
%>
<html>
<head>
    <title>查询学生信息</title>
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
    </div>
</body>
<script type="text/javascript">
    $(function (){
        //在当前dom对象加载后，执行loadStudentData()方法发起ajax请求获取数据
        loadStudentData();
    })

    function loadStudentData(){
        $.ajax({
            //指定ajax的请求地址
            url:"student/queryStudent.do",
            //指定请求方式是get请求还是post请求
            type:"get",
            //指定期望服务器返回的数据格式是json
            dataType:"json",
            //根据服务器返回的不同情况进行处理
            success:function (data){
                //清除已有的旧数据
                $("#info").html("");
                //由于返回的结果是List,元素是json，因此需要进行遍历
                $.each(data,function (i,n){
                    //解析每条json数据，并把json里面的id,name,age属性信息作为table的每列值进行展示
                    $("#info").append("<tr>")
                        .append("<td>" + n.id + "</td>")
                        .append("<td>" + n.name + "</td>")
                        .append("<td>" + n.age + "</td>")
                        .append("</tr>")
                })
            }
        })
    }
</script>
</html>
