package com.shiyu.service;

import com.shiyu.model.vo.UserVO;

public interface UserService {

    UserVO selectById(Long id);

    UserVO selectByPwd(String name, String pwd);
}
