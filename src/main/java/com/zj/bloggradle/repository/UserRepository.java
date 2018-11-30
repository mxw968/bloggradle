package com.zj.bloggradle.repository;

import com.zj.bloggradle.domain.User;

import java.util.List;

/**
 * User Repository 接口
 * @author 周杰
 * @date 2018/11/30
 */
public interface UserRepository {
    /**
     * 插入/更新用户信息
     *
     * @param user 用户对象
     * @return 用户对象
     * @author 周杰
     * @date 2018/11/30
     */
    User saveOrUpdateUser(User user);

    /**
     * 根据主键删除用户信息
     *
     * @param id 用户标识
     * @return void
     * @author 周杰
     * @date 2018/11/30
     */
    void deleteUser(Long id);

    /**
     * 根据主键查询单个用户信息
     *
     * @param id 用户标识
     * @return 用户信息
     * @author 周杰
     * @date 2018/11/30
     */
    User getUserById(Long id);

    /**
     * 获取多个用户信息
     * @return 用户信息List
     * @author 周杰
     * @date 2018/11/30
     */
    List<User> listUser();
}
