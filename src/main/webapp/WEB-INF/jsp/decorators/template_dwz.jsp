<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title>
        car
        <%--<decorator:title default="CAR"/>--%>
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="author" content="yxz"/>
    <meta name="copyright" content="Copyright (c) 2010 by yxz"/>
    <meta name="robots" content="index,follow"/>

    <%--日期控件--%>
    <script src="js/My97DatePicker/WdatePicker.js"></script>

    <%@ include file="dwz_init.jsp" %>

</head>


<body scroll="no">

<div id="layout">

    <div id="header">
        <div class="headerNav">
            <a class="logo" target="_blank" href="#">标志</a>

            <ul class="nav">
                <li><a href="${pageContext.request.contextPath}/changepwd" target="dialog" width="600">修改密码</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
            </ul>

            <ul class="themeList" id="themeList">
                <li theme="default">
                    <div class="selected">蓝色</div>
                </li>
                <li theme="green">
                    <div>绿色</div>
                </li>
                <!--<li theme="red"><div>红色</div></li>-->
                <li theme="purple">
                    <div>紫色</div>
                </li>
                <li theme="silver">
                    <div>银色</div>
                </li>
                <li theme="azure">
                    <div>天蓝</div>
                </li>
            </ul>
        </div>
    </div>


    <div id="leftside">
        <div id="sidebar_s">
            <div class="collapse">
                <div class="toggleCollapse">
                    <div></div>
                </div>
            </div>
        </div>
        <div id="sidebar">

            <div class="toggleCollapse"><h2>主菜单</h2>

                <div>收缩</div>
            </div>

            <div class="accordion" fillSpace="sidebar">

                <%@include file="../dwz.menu.jsp" %>

            </div>
        </div>
    </div>

    <div id="container">
        <div id="navTab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                    <ul class="navTab-tab">
                        <li tabid="main" class="main"><a href="javascript:;"><span><span
                                class="home_icon">我的主页</span></span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft">left</div>
                <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                <div class="tabsRight">right</div>
                <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                <div class="tabsMore">more</div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">我的主页</a></li>
            </ul>
            <div class="navTab-panel tabsPageContent layoutBox">
                <div class="page unitBox">
                    <%--xxx--%>
                    <decorator:body/>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    Copyright ©2013
    <%--技术支持：YXZ--%>
</div>


</body>
</html>