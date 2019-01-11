<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>转账</title>
    <script type="text/javascript" src="${pageContext.request.getContextPath() }/static/js/jquery-1.12.4.min.js"></script>
    <link href="${pageContext.request.getContextPath() }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.getContextPath() }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function transfer() {
            var inAccount = $("#inAccountId").val();
            var money = $("#moneyId").val();
            $.ajax({
                url : "${pageContext.request.contextPath}/transfer",
                type: "post",
                data : JSON.stringify({inAccount:inAccount,balance:money}),
                //定义发送请求的数据格式为JSON字符串
                contentType : "application/json;charset=UTF-8",
                dataType : "json",
                success : function () {
                    location.href="${pageContext.request.contextPath}/Details?id=${sessionScope.get("clientId")}";
                }
            });
        }
        $(function(){
            $("#inAccountId").blur(function(){
                var cardNumber=$(this).val();
                if(cardNumber==""){
                    $("#inAccountMsg").html("账号不能为空");
                }else{
                    // $.ajax方法实现
                    $.ajax({
                        url:"${pageContext.request.contextPath }/checkAccount",
                        type:"get",
                        data:"cardNumber="+cardNumber,
                        dataType:"text",
                        success:function(result){
                            $("#inAccountMsg").html(result);
                        }
                    });
                }
            });
        });
       /* $(function(){
            $("#moneyId").blur(function(){
                var balance=$(this).val();
                var cardNumber=${sessionScope.get("outAccount")};
                alert(cardNumber);
                if(balance==""){
                    $("#moneyMsg").html("金额不能为空");
                }else{
                    // $.ajax方法实现
                    $.ajax({
                        url:"${pageContext.request.contextPath }/checkBalance",
                        type:"get",
                        data:{"balance":balance,"cardNumber":cardNumber},
                        dataType:"text",
                        success:function(result){
                            $("#moneyMsg").html(result);
                        }
                    });
                }
            });
        })
*/
    </script>
</head>
<body>
    <!-- 转账 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <h2>转账</h2>
                <tr>
                    <td>收款人卡号</td><td><input id="inAccountId" type="text" name="inAccount"/> <span id="inAccountMsg"/></td>
                </tr>
                <tr>
                    <td>转账金额</td><td><input id="moneyId" type="text" name="money"/> <span id="moneyMsg"/></td>
                </tr>
                <tr><td colspan="2"><button class="btn btn-danger" onclick="transfer()">确定</button></td></tr>
            </table>
        </div>
    </div>
</body>
</html>
