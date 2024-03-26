package com.shiyu.application.convert;

import cn.hutool.core.date.DateUtil;
import com.shiyu.application.vo.RoleVO;
import com.shiyu.domain.dto.RoleDTO;
import com.shiyu.infrastructure.model.po.Role;
import com.shiyu.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 10:56
 * @version:1.0
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,imports = {DateUtil.class, DateUtils.class})
public interface RoleConvertMapper {

    @Mapping(target = "createTime",expression = "java( DateUtil.format(role.getCreateTime(), DateUtils.DATETIME_FORMAT_ONE) )")
    @Mapping(target = "updateTime",expression = "java( DateUtil.format(role.getUpdateTime(), DateUtils.DATETIME_FORMAT_ONE) )")
    RoleVO toVO(Role role);

    Role DTOtoPo(RoleDTO roleDTO);

    List<RoleVO> toVOList(List<Role> roleList);
}
