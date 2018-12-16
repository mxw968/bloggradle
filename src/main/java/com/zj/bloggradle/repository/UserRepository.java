package com.zj.bloggradle.repository;

import com.zj.bloggradle.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User Repository 接口
 * @author 周杰
 * @date 2018/11/30
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
