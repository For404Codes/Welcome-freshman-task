package com.righteous.innovate.task.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.task.dao.SubTasksDao;
import com.righteous.innovate.task.entity.SubTasksEntity;
import com.righteous.innovate.task.service.SubTasksService;


@Service("subTasksService")
public class SubTasksServiceImpl extends ServiceImpl<SubTasksDao, SubTasksEntity> implements SubTasksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SubTasksEntity> page = this.page(
                new Query<SubTasksEntity>().getPage(params),
                new QueryWrapper<SubTasksEntity>()
        );

        return new PageUtils(page);
    }

}