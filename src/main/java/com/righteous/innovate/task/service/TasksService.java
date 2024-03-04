package com.righteous.innovate.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.task.entity.TasksEntity;

import java.util.Map;

/**
 * 任务表
 *
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
public interface TasksService extends IService<TasksEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

