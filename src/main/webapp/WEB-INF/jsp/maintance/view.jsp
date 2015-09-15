<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<table>
    <tr>
        <td>购买人:</td>
        <td>
            ${orderEntity.buyPerson}
        </td>
    </tr>
    <tr>
        <td>单号：</td>
        <td>
            ${orderEntity.buyId}
        </td>
    </tr>

    <tr>
        <td>购买时间：</td>
        <td>
            ${orderEntity.buyDate}
        </td>
    </tr>

    <tr>
        <td>录入时间：</td>
        <td>
            ${orderEntity.inputDate}
        </td>
    </tr>

    <tr>
        <td>总金额：</td>
        <td>
            ${orderEntity.totalPrice}
        </td>
    </tr>

    <tr>
        <td>折扣：</td>
        <td>
            ${orderEntity.discount}
        </td>
    </tr>

</table>
