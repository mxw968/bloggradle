package com.zj.bloggradle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Blog 控制器
 *
 * @author 周杰
 * @date 2018/12/20
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @GetMapping
    public ModelAndView listBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
                                  @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        System.out.println("order:" + order + "; keyword:" + keyword);
        return new ModelAndView("redirect:/index?order="+order+"&keyword="+keyword);
    }
}
