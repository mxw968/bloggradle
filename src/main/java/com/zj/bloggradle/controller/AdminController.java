package com.zj.bloggradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器
 *
 * @author 周杰
 * @date 2019/1/6
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    /**
     * 获取后台管理主页面
     * @return
     * @author 周杰
     * @date 2019/1/6
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        return new ModelAndView("admin/index", "menuList", model);
    }


}
