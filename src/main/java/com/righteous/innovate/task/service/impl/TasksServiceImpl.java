package com.righteous.innovate.task.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.task.dao.TasksDao;
import com.righteous.innovate.task.entity.TasksEntity;
import com.righteous.innovate.task.service.TasksService;


@Service("tasksService")
public class TasksServiceImpl extends ServiceImpl<TasksDao, TasksEntity> implements TasksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TasksEntity> page = this.page(
                new Query<TasksEntity>().getPage(params),
                new QueryWrapper<TasksEntity>()
        );

        return new PageUtils(page);
    }

}