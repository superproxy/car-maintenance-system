<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<div class="panelBar">
    <div class="pages">
        <span>显示</span>
        <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
            <c:forEach var="pageRows" items="${page.pageRowsList}">
                <option value="${pageRows}" ${pageRows==page.rowsPerPage?'selected="selected"':''}> ${pageRows}
                </option>
            </c:forEach>
        </select>

        <span>条，共${page.totalCount}条</span>
    </div>

    <!--分页组件-->
    <div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.rowsPerPage}"
         pageNumShown="${page.rowsPerPage}"
         currentPage="${page.currentPageNum}">
    </div>
</div>