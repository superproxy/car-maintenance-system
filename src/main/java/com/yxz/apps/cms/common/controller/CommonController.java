package com.yxz.apps.cms.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 配件业务控制器
 */
@Controller
public class CommonController {

    /**
     * 显示主页
     *
     * @return
     */
    @RequestMapping(value = "/changepwd", method = RequestMethod.GET)
    public String index() {
        return "common/changepwd";
    }

    @RequestMapping(value = "/login_dialog", method = RequestMethod.GET)
    public String login_dialog() {
        return "common/login_dialog";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "common/logout";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "common/login";
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String loginOutAction() {
        return "common/login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginAction() {
        return "common/login";
    }
}