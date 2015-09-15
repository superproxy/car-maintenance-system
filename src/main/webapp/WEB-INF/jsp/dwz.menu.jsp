<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="accordionHeader">
    <h2><span>Folder</span>CAR</h2>
</div>
<div class="accordionContent">
    <ul class="tree treeFolder">


        <li>
            <a>客户信息</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/carOwner/list" target="navTab" ref="carOwner">客户信息</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/car/list" target="navTab" rel="car">车辆信息</a></li>
            </ul>
        </li>

        <li>
            <a>维修管理</a>
            <ul>
                <%--<li><a href="${pageContext.request.contextPath}/maintance/add" target="navTab" rel="pjadd">添加维修单</a>--%>
                <%--</li>--%>
                <li><a href="${pageContext.request.contextPath}/maintance/list" target="navTab" ref="pjquery">待维修的车辆</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/maintance/list" target="navTab" ref="pjquery">正在维修的车辆</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/maintance/list" target="navTab" ref="pjquery">已维修的车辆</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/maintance/list" target="navTab" ref="pjquery">已提车</a>
                </li>
            </ul>
        </li>

        <li>
            <a>配件管理</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/peijian/add" target="navTab" rel="pjadd">添加配件</a></li>
                <li><a href="${pageContext.request.contextPath}/peijian/list" target="navTab" ref="pjquery">配件管理</a>
                </li>
            </ul>
        </li>


        <li>
            <a>数据分析</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/peijian2/add" target="navTab" rel="pjadd">配件统计</a></li>
                <li><a href="${pageContext.request.contextPath}/peijian2/list" target="navTab" ref="pjquery">维修统计</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/peijian2/list" target="navTab" ref="pjquery">支出和收益</a>
                </li>
            </ul>
        </li>


        <li>
            <a>每日理财</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/peijian/add" target="navTab" rel="pjadd">收益</a></li>
                <li><a href="${pageContext.request.contextPath}/peijian/show" target="navTab" ref="pjquery">支出</a>
                </li>
            </ul>
        </li>

        <li>
            <a>系统管理</a>
            <ul>
                <%--<li><a href="${pageContext.request.contextPath}/template/list" target="navTab" ref="pjquery">修改密码</a>--%>
                <%--</li>--%>
                <li><a href="${pageContext.request.contextPath}/peijian/add" target="navTab" rel="pjadd">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/peijian/show" target="navTab" ref="pjquery">权限管理</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/peijian/list" target="navTab" ref="pjquery">菜单管理</a>
                </li>

            </ul>
        </li>


        <li>
            <a>DWZ测试</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/dwz/table.html" target="navTab">dwz table</a></li>
                <li><a href="${pageContext.request.contextPath}/dwz/form.html" target="navTab">dwz form</a></li>
                <li><a href="${pageContext.request.contextPath}/dwz/search.html" target="navTab">dwz search</a></li>
                <li><a href="${pageContext.request.contextPath}/dwz/add.html" target="navTab">dwz add</a></li>
            </ul>
        </li>


    </ul>
</div>