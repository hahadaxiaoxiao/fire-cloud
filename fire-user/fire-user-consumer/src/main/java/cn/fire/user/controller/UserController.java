package cn.fire.user.controller;

import cn.fire.common.web.core.R;
import cn.fire.user.api.exception.UserException;
import cn.fire.user.api.pojo.entity.UserDO;
import cn.fire.user.feign.UserServiceFeignClient;
import cn.fire.user.pojo.ao.UserRegisterAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: wangzc
 * @Date: 2020/7/29 16:35
 */

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @PostMapping("/reg")
    public R<String> register(@Valid @RequestBody UserRegisterAO param) {

        return R.ok("dfdf");
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/test")
    public R<UserDO> test() {
        return R.ok(userServiceFeignClient.getById(1l));
    }


    @PostMapping("/exception")
    public R<String> exception() {
        throw UserException.instance(UserException.USER_NOT_EXIST,"用户不存在");
    }

}
