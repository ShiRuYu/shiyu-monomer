package com.shiyu.service.impl;

import com.shiyu.mapper.UserMapper;
import com.shiyu.model.convert.UserConvertMapper;
import com.shiyu.model.po.User;
import com.shiyu.model.vo.UserVO;
import com.shiyu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static com.baomidou.mybatisplus.extension.toolkit.Db.lambdaQuery;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserConvertMapper userConvertMapper;

    @Override
    public UserVO selectById(Long id) {
        User user = userMapper.selectById(id);
        return userConvertMapper.toVo(user);
    }

    @Override
    public UserVO selectByPwd(String name, String pwd) {
        User user = lambdaQuery(User.class)
                .and(wrapper -> wrapper.eq(User::getPhone, name)
                        .or()
                        .eq(User::getEmail, name))
                .eq(User::getPassword, pwd)
                .one();

        return userConvertMapper.toVo(user);
    }

}
