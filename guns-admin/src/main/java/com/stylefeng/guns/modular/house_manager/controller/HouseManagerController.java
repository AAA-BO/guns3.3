package com.stylefeng.guns.modular.house_manager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.HouseManager;
import com.stylefeng.guns.modular.house_manager.service.IHouseManagerService;

/**
 * 房屋管理控制器
 *
 * @author fengshuonan
 * @Date 2019-04-21 19:36:20
 */
@Controller
@RequestMapping("/houseManager")
public class HouseManagerController extends BaseController {

    private String PREFIX = "/house_manager/houseManager/";

    @Autowired
    private IHouseManagerService houseManagerService;

    /**
     * 跳转到房屋管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "houseManager.html";
    }

    /**
     * 跳转到添加房屋管理
     */
    @RequestMapping("/houseManager_add")
    public String houseManagerAdd() {
        return PREFIX + "houseManager_add.html";
    }

    /**
     * 跳转到修改房屋管理
     */
    @RequestMapping("/houseManager_update/{houseManagerId}")
    public String houseManagerUpdate(@PathVariable Integer houseManagerId, Model model) {
        HouseManager houseManager = houseManagerService.selectById(houseManagerId);
        model.addAttribute("item",houseManager);
        LogObjectHolder.me().set(houseManager);
        return PREFIX + "houseManager_edit.html";
    }

    /**
     * 获取房屋管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return houseManagerService.selectList(null);
    }

    /**
     * 新增房屋管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(HouseManager houseManager) {
        houseManagerService.insert(houseManager);
        return SUCCESS_TIP;
    }

    /**
     * 删除房屋管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer houseManagerId) {
        houseManagerService.deleteById(houseManagerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改房屋管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(HouseManager houseManager) {
        houseManagerService.updateById(houseManager);
        return SUCCESS_TIP;
    }

    /**
     * 房屋管理详情
     */
    @RequestMapping(value = "/detail/{houseManagerId}")
    @ResponseBody
    public Object detail(@PathVariable("houseManagerId") Integer houseManagerId) {
        return houseManagerService.selectById(houseManagerId);
    }
}
