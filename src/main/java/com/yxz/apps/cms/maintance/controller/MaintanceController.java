package com.yxz.apps.cms.maintance.controller;

import com.yxz.apps.cms.common.CommonUtil;
import com.yxz.apps.cms.common.Pagination;
import com.yxz.apps.cms.maintance.service.MaintanceService;
import com.yxz.apps.cms.common.DwzActionResult;
import com.yxz.apps.cms.po.hibernate.Maintance;
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
import java.util.List;

/**
 * 配件业务控制器
 */
@RequestMapping("/maintance")
@Controller
public class MaintanceController {

    @Resource
    private MaintanceService maintanceService;

    /**
     * 对应路径 /template
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index2() {
        return "maintance/index";
    }

    /**
     * 显示主页 , 实际的路径是/maintance/
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "maintance/list";
    }

    /**
     * 分页显示所有的用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        List<Maintance> list = maintanceService.queryMaintance();
        model.addAttribute("MaintanceEntityList", list);
        return "maintance/show";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String searchByList(HttpServletRequest request, Model model) throws Exception {
        int rowsPerPage = 10;
        List<Maintance> list = maintanceService.queryMaintance("from " + Maintance.class.getName());
        int totalCount = list.size();
        if (totalCount > rowsPerPage) {
            list = list.subList(0, rowsPerPage - 1);
        }
        model.addAttribute("maintanceList", list);

        int currentPageNum = 1;

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);
        doList(model, pagination);
        return "maintance/list";      //  返回到页面
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model) throws Exception {
        String maintanceId = request.getParameter("maintanceId");
        String condition = "";
//        buyId = "1077852873274";
        if (StringUtils.isNotEmpty(maintanceId)) {
            //   build Condition
            condition = "  maintanceId='" + maintanceId + "'";
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

        int totalCount = maintanceService.getTotalCount();
        List<Maintance> list = maintanceService.queryByPagination((currentPageNum - 1) * rowsPerPage, rowsPerPage);
        model.addAttribute("maintanceId", maintanceId);
        model.addAttribute("maintanceList", list);

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);

        doList(model, pagination);
        return "maintance/list";      //  返回到页面
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
        Maintance MaintanceEntity = maintanceService.getBeanById(id);
        System.out.println(MaintanceEntity.toString());
        if (MaintanceEntity != null) {
            model.addAttribute("MaintanceEntity", MaintanceEntity);
        }
        return "maintance/view";
    }

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
    public String advancedSearch() {
        return "maintance/advancedSearch";
    }

    /**
     * 添加界面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        Maintance maintance = new Maintance();
        maintance.setMaintanceId(CommonUtil.getCurrentTime() + CommonUtil.genID(4));
        model.addAttribute("maintance", maintance); //  默认m
        return "maintance/add";
    }

    /**
     * 添加动作
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@ModelAttribute Maintance maintance) throws Exception {
        maintanceService.save(maintance);
        return getStringResponseEntity(new DwzActionResult());
    }


//    private void redirect(HttpServletResponse response, String url) throws IOException {
//        response.sendRedirect(url); //内部跳转, 如果直接返回url并不会跳转
//    }

    /**
     * 编辑
     *
     * @param MaintanceEntity 表单提交封装
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> edit(@ModelAttribute("MaintanceEntity") Maintance MaintanceEntity, ModelMap model, HttpServletResponse response) throws Exception {
        maintanceService.edit(MaintanceEntity);
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
        Maintance MaintanceEntity = maintanceService.getBeanById(id);
        if (MaintanceEntity != null) {
            model.addAttribute("MaintanceEntity", MaintanceEntity);      // 隐藏表单
        } else {
            //  没有发现这个
            return "";
        }

        return "maintance/edit";
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
        maintanceService.remove(id);
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