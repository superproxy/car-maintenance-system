package com.yxz.apps.cms.carowner.controller;

import com.yxz.apps.cms.carowner.form.CarOwnerRes;
import com.yxz.apps.cms.carowner.service.CarOwnerService;
import com.yxz.apps.cms.common.DwzActionResult;
import com.yxz.apps.cms.common.Pagination;
import com.yxz.apps.cms.po.hibernate.CarOwner;
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
import java.util.ArrayList;
import java.util.List;

import static com.yxz.apps.cms.common.CommonUtil.buildJson;
import static com.yxz.apps.cms.common.CommonUtil.buildJsonByObject;

/**
 * 配件业务控制器
 */
@RequestMapping("/carOwner")
@Controller
public class CarOwnerController {

    @Resource
    private CarOwnerService carOwnerService;

    /**
     * 对应路径 /template
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index2() {
        return "carOwner/index";
    }

    /**
     * 显示主页 , 实际的路径是/carOwner/
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "carOwner/list";
    }

    /**
     * 分页显示所有的用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        List<CarOwner> list = carOwnerService.queryCarOwner();
        model.addAttribute("carOwnerList", list);
        return "carOwner/show";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String searchByList(HttpServletRequest request, Model model) throws Exception {
        int rowsPerPage = 10;
        List<CarOwner> list = carOwnerService.queryCarOwner("from " + CarOwner.class.getName());
        int totalCount = list.size();
        if (totalCount > rowsPerPage) {
            list = list.subList(0, rowsPerPage - 1);
        }
        model.addAttribute("carOwnerList", list);

        int currentPageNum = 1;

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);
        doList(model, pagination);
        return "carOwner/list";      //  返回到页面
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model) throws Exception {
        String carOwnerName = request.getParameter("carOwnerName");
        String condition = "";
//        buyId = "1077852873274";
        if (StringUtils.isNotEmpty(carOwnerName)) {
            //   build Condition
            condition = "  carOwnerName like '%" + carOwnerName + "%'";
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

        int totalCount = carOwnerService.getTotalCount(condition);
        List<CarOwner> list = carOwnerService.queryByPagination((currentPageNum - 1) * rowsPerPage, rowsPerPage, condition
        );
        model.addAttribute("carOwnerName", carOwnerName);
        model.addAttribute("carOwnerList", list);

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);

        doList(model, pagination);
        return "carOwner/list";      //  返回到页面
    }


    /**
     * lookup
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryCarOwner", method = RequestMethod.POST)
    public ResponseEntity<String> query(HttpServletRequest request, Model model) throws Exception {
        String carOwnerName = request.getParameter("carOwnerName");
        String condition = "";
//        buyId = "1077852873274";
        if (StringUtils.isNotEmpty(carOwnerName)) {
            //   build Condition
            condition = "  carOwnerName like '%" + carOwnerName + "%'";
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

        List<CarOwner> list = carOwnerService.queryByPagination((currentPageNum - 1) * rowsPerPage, rowsPerPage, condition);

        List<CarOwnerRes> carOwnerResList = new ArrayList<CarOwnerRes>(list.size());
        for (CarOwner carOwner : list) {
            CarOwnerRes carOwnerRes = new CarOwnerRes();
            carOwnerRes.setCarOwnerId(carOwner.getCarOwnerId());
            carOwnerRes.setCarOwnerName(carOwner.getCarOwnerName());
            carOwnerRes.setCarOwnerPhone(carOwner.getCarOwnerPhone());
            carOwnerRes.setCarOwnerAddress(carOwner.getCarOwnerAddress());

            carOwnerResList.add(carOwnerRes);
        }

        return buildJsonByObject(carOwnerResList);
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
        CarOwner CarOwnerEntity = carOwnerService.getBeanById(id);
        System.out.println(CarOwnerEntity.toString());
        if (CarOwnerEntity != null) {
            model.addAttribute("carEntity", CarOwnerEntity);
        }
        return "carOwner/view";
    }

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
    public String advancedSearch() {
        return "carOwner/advancedSearch";
    }

    /**
     * 添加界面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "carOwner/add";
    }

    /**
     * 添加动作
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@ModelAttribute CarOwner carOwner) throws Exception {
        carOwner.setInputTime(new Timestamp(System.currentTimeMillis()));  // 本地时间，但是客户端在不同的时区
        carOwnerService.save(carOwner);
//       DwzActionResult OK = new DwzActionResult("200", "操作成功", "navTab", "main", "closeCurrent", "");
        return buildJsonByObject(new DwzActionResult());
    }


//    private void redirect(HttpServletResponse response, String url) throws IOException {
//        response.sendRedirect(url); //内部跳转, 如果直接返回url并不会跳转
//    }

    /**
     * 编辑
     *
     * @param car   表单提交封装
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> edit(@ModelAttribute("car") CarOwner car, ModelMap model, HttpServletResponse response) throws Exception {
        carOwnerService.edit(car);
        return buildJsonByObject(new DwzActionResult());
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
        CarOwner carOwner = carOwnerService.getBeanById(id);
        if (carOwner != null) {
            model.addAttribute("carOwner", carOwner);      // 隐藏表单
        } else {
            //  没有发现这个
            return "";
        }

        return "carOwner/edit";
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
        carOwnerService.remove(id);
        return buildJsonByObject(new DwzActionResult());
    }


}