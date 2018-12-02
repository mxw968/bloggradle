package com.zj.bloggradle.controller;

import com.zj.bloggradle.domain.User;
import com.zj.bloggradle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

/**
 * User 控制器
 *
 * @author 周杰
 * @date 2018/11/30
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     *
     * @return
     * @author 周杰
     * @date 2018/11/30
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUser());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @param model
     * @return
     * @author 周杰
     * @date 2018/11/30
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * form页面映射
     *
     * @return
     * @author 周杰
     * @date 2018/12/2
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 保存或修改用户
     *
     * @return
     * @author 周杰
     * @date 2018/12/2
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users"); // 重定向到list页面
    }

    /**
     * 删除用户
     *
     * @return
     * @author 周杰
     * @date 2018/12/2
     */
    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users"); // 重定向到list页面
    }

    /**
     * 用户信息修改
     *
     * @return
     * @author 周杰
     * @date 2018/12/2
     */
    @GetMapping("modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
