package com.yxz.apps.cms.common;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-29
 * Time: 下午9:13
 * To change this template use File | Settings | File Templates.
 */
public class DwzActionResult {

    public DwzActionResult() {
//        this("200", "操作成功", "navTab", "main", "closeCurrent", "");
    }

    public DwzActionResult(String statusCode, String message, String navTabId, String rel, String callbackType, String forwardUrl) {
        this.statusCode = statusCode;
        this.message = message;
        this.navTabId = navTabId;
        this.rel = rel;
        this.callbackType = callbackType;
        this.forwardUrl = forwardUrl;
    }

//    public static DwzActionResult OK = new DwzActionResult("200", "操作成功", "navTab", "main", "closeCurrent", "");
//    public static DwzActionResult FAIL = new DwzActionResult();

    String statusCode = "200";
    String message = "操作成功";
    String navTabId = ""; //"navTab";
    String rel = ""; // "main";
    String callbackType = ""; //  = "closeCurrent";  关闭Tab
    String forwardUrl = "";

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }
}
