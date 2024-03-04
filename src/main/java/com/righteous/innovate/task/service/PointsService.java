package com.righteous.innovate.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.task.entity.PointsEntity;

import java.util.Map;

/**
 * 积分表
 *
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
public interface PointsService extends IService<PointsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

