package com.yxz.apps.cms.template;

import com.yxz.apps.cms.peijian.service.OrderService;
import com.yxz.apps.cms.po.hibernate.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 配件业务控制器
 */
@RequestMapping("/peijianmvc")
@Controller
public class PeiJianControllerMVC {

    public static final String PEIJIAN_SHOW = "/template/show";
    @Resource
    private OrderService orderService;

    /**
     * 对应路径 /template
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index2() {
        return "peijian/index";
    }

    /**
     * 显示主页 , 实际的路径是/template/
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "peijian/index";
    }

    /**
     * 分页显示所有的用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        List<Order> list = orderService.queryOrder();
        model.addAttribute("orderEntityList", list);
        return "peijian/show";
    }

    /**
     * 显示单个id
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String getById(@PathVariable String id, Model model) throws Exception {
        Order orderEntity = orderService.getBeanById(id);
        System.out.println(orderEntity.toString());
        if (orderEntity != null) {
            model.addAttribute("orderEntity", orderEntity);
        }
        return "peijian/view";
    }

    /**
     * 添加界面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        // TODO:  用户信息，需要初始化的默认值
        return "/peijian/add";
    }

    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public String add2(Model model) {
        //  创建表单的时候必须初始化一个表单
        model.addAttribute("orderEntity", new Order());
        return "/peijian/add_spring_form";
    }

    /**
     * 添加动作
     *
     * @param orderEntity 表单提交封装
     * @param response
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void add(@ModelAttribute("orderEntity") Order orderEntity, HttpServletResponse response) throws Exception {
        orderEntity.setBuyId(System.nanoTime());
        orderEntity.setBuyDate(new Timestamp(new Date().getTime()));
        orderEntity.setInputDate(new Timestamp(new Date().getTime()));
        orderEntity.setInputPersonId("3");
        orderService.save(orderEntity);
        redirect(response, PEIJIAN_SHOW);
    }

    private void redirect(HttpServletResponse response, String url) throws IOException {
        response.sendRedirect(url); //内部跳转, 如果直接返回url并不会跳转
    }

    /**
     * 编辑
     *
     * @param orderEntity 表单提交封装
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void edit(@ModelAttribute("orderEntity") Order orderEntity, ModelMap model, HttpServletResponse response) throws Exception {
        orderService.edit(orderEntity);
        redirect(response, PEIJIAN_SHOW);
    }

    /**
     * 编辑请求UI
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) throws Exception {
        Order orderEntity = orderService.getBeanById(id);
        if (orderEntity != null) {
            model.addAttribute("orderEntity", orderEntity);      // 隐藏表单
        } else {
            //  没有发现这个
            return "";
        }

        return "/peijian/edit";
    }

    /**
     * 删除请求
     * delete ajax使用，但是有的web服务器可能不支持。 所以使用 get替代
     *
     * @param id
     * @return
     */
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public void del(@PathVariable String id, HttpServletResponse response) throws Exception {
        orderService.remove(id);
        redirect(response, PEIJIAN_SHOW);
    }
}