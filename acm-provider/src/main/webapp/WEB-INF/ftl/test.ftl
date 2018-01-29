<#-- @ftlvariable name="userId" type="java.lang.String" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试页面</title>
</head>
<script src="/js/jquery-3.3.1.js"></script>
<body>
websocket demo
<hr>
<#if userId??>
    我的用户id是:${userId}
<#else>
未传入userId
</#if>
<hr>
<table border="1">
    <tr style="height: 600px">
        <td style="width: 800px">
            <div id="messageArea"></div>
        </td>
    </tr>
    <tr>
        <td>
            <input id="inputBox" title="老铁">
            <button id="btn">点我提交</button>
        </td>
    </tr>
</table>
<script>
    var socket = new WebSocket('ws://localhost:8080/socket/${userId}');
    $(function () {
        socket.onopen = function () {
            socket.send('${userId}已上线');
        };
        //  socket.send('啦啦啦我发了一个消息');
        $('#btn').click(function () {
            var message = $('#inputBox').val();
            $('#inputBox').val('');
            socket.send(message);
        });
        socket.onmessage = function (receive) {
            $('#messageArea').append("<br>").append(receive.data);
        };
    })
</script>
</body>
</html>