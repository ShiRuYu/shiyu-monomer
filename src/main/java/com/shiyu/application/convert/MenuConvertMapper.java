package com.shiyu.application.convert;

import cn.hutool.core.date.DateUtil;
import com.shiyu.application.vo.MenuVO;
import com.shiyu.domain.dto.MenuDTO;
import com.shiyu.infrastructure.model.Menu;
import com.shiyu.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 10:39
 * @version:1.0
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,imports = {DateUtil.class, DateUtils.class})
public interface MenuConvertMapper {

    @Mapping(target = "createTime",expression = "java( DateUtil.format(menu.getCreateTime(), DateUtils.DATETIME_FORMAT_ONE) )")
    @Mapping(target = "updateTime",expression = "java( DateUtil.format(menu.getUpdateTime(), DateUtils.DATETIME_FORMAT_ONE) )")
    MenuVO toVo(Menu menu);

    Menu DTOtoPo(MenuDTO menuDTO);

    List<MenuVO> toVoList(List<Menu> menuList);
}
