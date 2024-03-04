package com.righteous.innovate.task.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.task.dao.StudentTasksDao;
import com.righteous.innovate.task.entity.StudentTasksEntity;
import com.righteous.innovate.task.service.StudentTasksService;


@Service("studentTasksService")
public class StudentTasksServiceImpl extends ServiceImpl<StudentTasksDao, StudentTasksEntity> implements StudentTasksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentTasksEntity> page = this.page(
                new Query<StudentTasksEntity>().getPage(params),
                new QueryWrapper<StudentTasksEntity>()
        );

        return new PageUtils(page);
    }

}