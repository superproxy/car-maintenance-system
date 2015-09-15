package com.yxz.apps.cms.peijian.controller;

import com.yxz.apps.cms.common.Pagination;
import com.yxz.apps.cms.peijian.service.OrderService;
import com.yxz.apps.cms.po.hibernate.Order;
import com.yxz.apps.cms.common.DwzActionResult;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 配件业务控制器
 */
@RequestMapping("peijian")
@Controller
public class PeiJianController {

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
     * 显示主页 , 实际的路径是/peijian/
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "peijian/list";
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String searchByList(HttpServletRequest request, Model model) throws Exception {
        int rowsPerPage = 10;
        List<Order> list = orderService.queryOrder("from " + Order.class.getName());
        int totalCount = list.size();
        if (totalCount > rowsPerPage) {
            list = list.subList(0, rowsPerPage - 1);
        }
        model.addAttribute("orderEntityList", list);

        int currentPageNum = 1;

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);
        doList(model, pagination);
        return "peijian/list";      //  返回到页面
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model) throws Exception {
        String buyId = request.getParameter("buyId");
        String buyDate = request.getParameter("buyDate");
        String condition = "";
//        buyId = "1077852873274";
        if (StringUtils.isNotEmpty(buyId)) {
            //   build Condition
            condition = "  buyId='" + buyId + "'";
        }


        int currentPageNum = 1;
        try {
            currentPageNum =
                    Integer.parseInt(request.getParameter("pageNum"));
        } catch (Exception ex) {

        }

        int rowsPerPage = 10;
        try {
            rowsPerPage =
                    Integer.parseInt(request.getParameter("numPerPage"));
        } catch (Exception ex) {

        }

        int totalCount = orderService.getTotalCount();
        List<Order> list = orderService.queryByPagination((currentPageNum - 1) * rowsPerPage, rowsPerPage);
        model.addAttribute("buyId", buyId);
        model.addAttribute("buyDate", buyDate);
        model.addAttribute("orderEntityList", list);

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);

        doList(model, pagination);
        return "peijian/list";      //  返回到页面
    }

    /**
     * @param model
     * @param pagination
     */
    private void doList(Model model, Pagination pagination) {
        model.addAttribute("page", pagination);
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

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
    public String advancedSearch() {
        return "peijian/advancedSearch";
    }

    /**
     * 添加界面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
//        TODO:  用户信息，需要初始化的默认值
//        model.addAttribute("orderEntity", new Order());
        return "peijian/add";
    }

    /**
     * 添加动作
     *
     * @param httpServletRequest
     * @param response
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@ModelAttribute("orderEntity") Order orderEntity, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
        orderEntity.setBuyId(System.nanoTime());
        orderEntity.setBuyDate(new Timestamp(new Date().getTime()));
        orderEntity.setInputDate(new Timestamp(new Date().getTime()));
        orderEntity.setInputPersonId("3");
//        orderService.save(orderEntity);
        return getStringResponseEntity(new DwzActionResult());
    }


//    private void redirect(HttpServletResponse response, String url) throws IOException {
//        response.sendRedirect(url); //内部跳转, 如果直接返回url并不会跳转
//    }

    /**
     * 编辑
     *
     * @param orderEntity 表单提交封装
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> edit(@ModelAttribute("orderEntity") Order orderEntity, ModelMap model, HttpServletResponse response) throws Exception {
        orderService.edit(orderEntity);
        return getStringResponseEntity(new DwzActionResult());
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

        return "peijian/edit";
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
    @ResponseBody
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ResponseEntity<String> del(@PathVariable String id) throws Exception {
        orderService.remove(id);
        return getStringResponseEntity(new DwzActionResult());
    }

    private ResponseEntity<String> getStringResponseEntity(DwzActionResult dwzActionResult) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(dwzActionResult);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", "application/json;charset=UTF-8");
        return new ResponseEntity<String>(s, responseHeaders, HttpStatus.OK);
    }
}