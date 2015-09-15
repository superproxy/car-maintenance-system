<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%--<script>--%>
<%--$(function () {--%>
<%--$("input[type=submit], a, button")--%>
<%--.button()--%>
<%--.click(function (event) {--%>
<%--event.preventDefault();--%>
<%--});--%>
<%--});--%>
<%--</script>--%>


<form name="form" action="${pageContext.request.contextPath}/template/create" method="post">
    配件列表<br/>
    <b>添加 删除 编辑</b><br/>
    <table>
        <tr>
            <td>
                <label>购买人：</label>
            </td>
            <td>
                <input type="text" id="buyPerson2" name="buyPerson" value="yxz" readonly="true">
            </td>
        </tr>
        <tr>
            <td>
                购买人：
            </td>
            <td>
                <input type="text" name="buyPerson" value="yxz" readonly="true">
            </td>
        </tr>

        <tr>
            <td>
                <label>购买人：</label>
            </td>
            <td>
                <input type="text" name="buyPerson" value="yxz" readonly="true">
            </td>
        </tr>
    </table>


    <table>
        <tr>
            <td>
                <label>购买人：</label>
            </td>
            <td>
                <input type="text" id="buyPerson" name="buyPerson" value="yxz" readonly="true">
            </td>
        </tr>
        <tr>
            <td>
                <label>购买时间：</label>
            </td>
            <td>
                <input type="text" id="buyDate" name="buyDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>录入时间：</label>
            </td>
            <td>
                <input type="text" id="inputDate" name="inputDate"
                       onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:'false',readOnly:'true'})"/>
            </td>
            <td>
        </tr>
        <tr>
            <td>
                <label>总价：</label>
            </td>
            <td>
                <input type="text" id="totalPrice" name="totalPrice"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>折扣：</label>
            </td>
            <td>
                <input type="text" id="discount" name="discount"/>
            </td>
        </tr>

    </table>

    <input type="submit" value="提交"/>
</form>
