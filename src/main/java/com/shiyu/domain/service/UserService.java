package com.shiyu.domain.service;

import com.shiyu.application.vo.UserVO;

public interface UserService {

    UserVO selectById(Long id);

    UserVO selectByPwd(String name, String pwd);
}
