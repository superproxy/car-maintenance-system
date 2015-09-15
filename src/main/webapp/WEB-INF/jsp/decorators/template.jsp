<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title>
        <decorator:title default="装饰器页面..."/>
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="author" content="yxz"/>
    <meta name="copyright" content="Copyright (c) 2010 by yxz"/>
    <meta name="robots" content="index,follow"/>
    <%--jquery--%>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <%--日期控件--%>
    <script src="/js/My97DatePicker/WdatePicker.js"/>

    <%--jquery ui--%>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>

    <style type="text/css">
        #main {
            position: absolute;
            top: 55px;
            left: 210px;
        }

        #header {
            display: block;
            overflow: hidden;
            height: 50px;
            z-index: 30
        }

        #left {
            position: absolute;
            top: 55px;
            left: 0;
            z-index: 20;
        }

        #footer {
            position: absolute;
            bottom: 0;
            left: 0;
            text-align: center;
            width: 100%;
            height: 21px;
            padding: 0 5px;
            z-index: -1
        }
    </style>
</head>
<body>
<div id="header">
    header............
</div>
<div>
    <div id="left">
        <div id="navMenu">
            <ul>
                <a href="/peijian">配件管理</a> <br/>
                <ul>
                    <li><a href="/peijian/add">添加配件</a></li>
                    <li><a href="/peijian/show">查询配件</a> <br/></li>
                </ul>
                <a href="/accessory">配件管理</a> <br/>
                <a href="/accessoryorder">配件到货</a> <br/>
                <a href="/maintaince">车辆维修</a> <br/>
                <a href="/stock">库存管理</a> <br/>
            </ul>
        </div>
    </div>

    <div id="main">
        <decorator:body/>
    </div>
</div>

<div id="footer">
    footer
</div>
</body>
</html>