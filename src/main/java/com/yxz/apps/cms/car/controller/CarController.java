package com.yxz.apps.cms.car.controller;

import com.yxz.apps.cms.car.service.CarService;
import com.yxz.apps.cms.carowner.service.CarOwnerService;
import com.yxz.apps.cms.common.CommonUtil;
import com.yxz.apps.cms.common.DwzActionResult;
import com.yxz.apps.cms.common.Pagination;
import com.yxz.apps.cms.po.hibernate.Car;
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
import java.util.List;

/**
 * 配件业务控制器
 */
@RequestMapping("/car")
@Controller
public class CarController {

    @Resource
    private CarService carService;
    private CarOwnerService carOwnerService;

    /**
     * 对应路径 /template
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index2() {
        return "car/index";
    }

    /**
     * 显示主页 , 实际的路径是/Car/
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "car/list";
    }

    /**
     * 分页显示所有的用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        List<Car> list = carService.queryCar();
        model.addAttribute("carList", list);
        return "car/show";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String searchByList(HttpServletRequest request, Model model) throws Exception {
        int rowsPerPage = 10;
        List<Car> list = carService.queryCar("from " + Car.class.getName());
        int totalCount = list.size();
        if (totalCount > rowsPerPage) {
            list = list.subList(0, rowsPerPage - 1);
        }
        model.addAttribute("carList", list);

        int currentPageNum = 1;

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);
        doList(model, pagination);
        return "car/list";      //  返回到页面
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model) throws Exception {

        String condition = "";
//        buyId = "1077852873274";

        String carCard = request.getParameter("carCard");
        if (StringUtils.isNotEmpty(carCard)) {
            //   build Condition
            condition = "  carCard='" + carCard + "'";
        }


        String carId = request.getParameter("carId");
        if (StringUtils.isNotEmpty(carId)) {
            //   build Condition
            condition = "  carCard='" + carId + "'";
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

        int totalCount = carService.getTotalCount(condition);
        List<Car> list = carService.queryByPagination((currentPageNum - 1) * rowsPerPage, rowsPerPage, condition);
        model.addAttribute("carId", carId);
        model.addAttribute("carList", list);

        Pagination pagination = new Pagination();
        pagination.setCurrentPageNum(currentPageNum);
        pagination.setTotalCount(totalCount);
        pagination.setRowsPerPage(rowsPerPage);
        pagination.setTotalPageNum(totalCount / rowsPerPage + 1);

        doList(model, pagination);
        return "car/list";      //  返回到页面
    }


    @RequestMapping(value = "/queryCarCard", method = RequestMethod.POST)
    public ResponseEntity<String> queryCarCard(HttpServletRequest request, Model model) throws Exception {

        String condition = "";
//        buyId = "1077852873274";

        String carCard = request.getParameter("carCard");
        if (StringUtils.isNotEmpty(carCard)) {
            //   build Condition
            condition = "  carCard like '%" + carCard + "%'";
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

        List<Car> list = carService.queryByPagination((currentPageNum - 1) * rowsPerPage, rowsPerPage, condition);
        return CommonUtil.buildJsonByObject(list);
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
        Car CarEntity = carService.getBeanById(id);
        System.out.println(CarEntity.toString());
        if (CarEntity != null) {
            model.addAttribute("car", CarEntity);
        }
        return "car/view";
    }

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
    public String advancedSearch() {
        return "car/advancedSearch";
    }

    /**
     * 添加界面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "car/add";
    }

    /**
     * 添加动作
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@ModelAttribute Car car) throws Exception {
        car.setInputTime(new Timestamp(System.currentTimeMillis()));
        carService.save(car);
        return getStringResponseEntity(new DwzActionResult());
    }


//    private void redirect(HttpServletResponse response, String url) throws IOException {
//        response.sendRedirect(url); //内部跳转, 如果直接返回url并不会跳转
//    }

    /**
     * 编辑
     *
     * @param CarEntity 表单提交封装
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> edit(@ModelAttribute("carEntity") Car CarEntity, ModelMap model, HttpServletResponse response) throws Exception {
        carService.edit(CarEntity);
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
        Car car = carService.getBeanById(id);
        if (car != null) {
//            Integer carOwnerId = car.getCarOwnerId();
//            CarOwner carOwner = null;
//            if (carOwnerId == null) {
//                carOwner = new CarOwner();
//            } else {
//                carOwner = carOwnerService.getBeanById(String.valueOf(carOwnerId));
//            }
//            model.addAttribute("carOwner", carOwner);

            model.addAttribute("car", car);
        } else {
            //  没有发现这个
            return "";
        }

        return "car/edit";
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
        carService.remove(id);
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