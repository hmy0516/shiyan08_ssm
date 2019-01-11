<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户列表</title>
    <link href="${request.getContextPath() }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${request.getContextPath() }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 搭建显示页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>客户银行信息</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <form action="${pageContext.request.contextPath}/searchByPNI" method="post">
        <div class="col-md-10 col-md-offset-2">
            手机号：<input id="phoneId" type="text" name="phoneNumber"/>
            <div id="showDiv1" style="display:none; position:absolute;z-index:1000;background:#fff; width:179px;border:1px solid #ccc;"></div>
            姓  名：<input id="nameId" type="text" name="name"/>
            <div id="showDiv" style="display:none; position:absolute;z-index:1000;background:#fff; width:179px;border:1px solid #ccc;"></div>
            身份证号：<input id="idCard" type="text" name="idCard"/>
            <button class="btn btn-primary" onclick="search()">查询</button>
            <input type="submit" value="表单查询">
        </div>
        </form>
        <br><br><br>
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <br>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>序号</th>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>出生日期</td>
                    <td>身份证号</td>
                    <td>手机号</td>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list }" var="client">
                    <tr>
                        <th>${client.clientId}</th>
                        <th>${client.name}</th>
                        <th>${client.sex}</th>
                        <th><fmt:formatDate value="${client.birthday}" pattern="yyyy-MM-dd"/></th>
                        <th>${client.idCard}</th>
                        <th>${client.phoneNumber}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <a href="${pageContext.request.contextPath}/Details?id=${client.clientId}">详情</a>
                            <button class="btn btn-danger btn-sm" onclick="details(${client.clientId})">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                详情
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
            页,总 ${pageInfo.total } 条记录</div>
        <!-- 分页条信息 -->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${request.getContextPath() }/ClientInfo?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li><a href="${request.getContextPath() }/ClientInfo?pn=${pageInfo.pageNum-1}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>


                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum }">
                            <li class="active"><a href="#">${page_Num }</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum }">
                            <li><a href="${request.getContextPath() }/ClientInfo?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li><a href="${request.getContextPath() }/ClientInfo?pn=${pageInfo.pageNum+1 }"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                    <li><a href="${request.getContextPath() }/ClientInfo?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>
<script type="text/javascript" src="${request.getContextPath() }/static/js/jquery-1.12.4.min.js"></script>
<script>
    function overFn(obj){
        $(obj).css("background","#DBEAF9");
    }
    function outFn(obj){
        $(obj).css("background","#fff");
    }

    function clickFn(obj){
        $("#search").val($(obj).html());
        $("#showDiv").css("display","none");
    }

    /*function searchWord(obj){
        //1、获得输入框的输入的内容
        var word = $(obj).val();
        //2、根据输入框的内容去数据库中模糊查询---List<Product>
        var content = "";
        $.post(
            "${pageContext.request.contextPath}/ClientInfo",
                {"name":word},
                function(data){
                    //3、将返回的名称 现在showDiv中
                    if(data.length>0){
                        for(var i=0;i<data.length;i++){
                            content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
                        }
                        $("#showDiv").html(content);
                        $("#showDiv").css("display","block");
                    }

                },
                "json"
            );

        }*/
    //通过手机号 姓名 身份证查询
    function search() {
        var phone=$("#phoneId").val();
        var name=$("#nameId").val();
        var idCard=$("#idCard").val();
        $.get(
            "${pageContext.request.contextPath}/searchByPNI",
            {"phone":phone,
                "name":name,
                "idCard":idCard
            },function () {
                window.location.reload(true);
            }
        );
    };

    function details(id){
        $.post(
            "${pageContext.request.contextPath}/Details",
            {
                "id":id
            }
        );
    };
</script>
</body>
</html>