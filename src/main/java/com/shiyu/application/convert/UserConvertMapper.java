package com.shiyu.application.convert;

import cn.hutool.core.date.DateUtil;
import com.shiyu.infrastructure.model.po.User;
import com.shiyu.application.vo.UserVO;
import com.shiyu.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,imports = {DateUtil.class, DateUtils.class})
public interface UserConvertMapper {

    @Mapping(target = "createTime",expression = "java( DateUtil.format(user.getCreateTime(), DateUtils.DATETIME_FORMAT_ONE) )")
    @Mapping(target = "updateTime",expression = "java( DateUtil.format(user.getUpdateTime(), DateUtils.DATETIME_FORMAT_ONE) )")
    UserVO toVo(User user);
}
