<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户详情</title>
    <script type="text/javascript" src="${pageContext.request.getContextPath() }/static/js/jquery-1.12.4.min.js"></script>
    <link href="${pageContext.request.getContextPath() }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.getContextPath() }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <h2>客户银行详细信息</h2>
                <tr>
                    <td>姓名</td>
                    <td>身份证号</td>
                    <td>卡号</td>
                    <td>办卡日期</td>
                    <td>余额</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="bankCardInfo" items="${clientInfo.bankCardInfo}">
                    <tr>
                        <th>${clientInfo.name}</th>
                        <th>${clientInfo.idCard}</th>
                        <th>${bankCardInfo.cardNumber}</th>
                        <th><fmt:formatDate value="${bankCardInfo.cardDate}" pattern="yyyy-MM-dd"/></th>
                        <th>${bankCardInfo.balance}</th>
                        <th>
                            <a href="${pageContext.request.getContextPath() }/toTransfer?outAccount=${bankCardInfo.cardNumber}&clientId=${clientInfo.clientId}">转账</a>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                转账
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
