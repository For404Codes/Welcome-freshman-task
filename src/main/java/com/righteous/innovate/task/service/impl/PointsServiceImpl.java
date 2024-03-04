package com.righteous.innovate.task.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.task.dao.PointsDao;
import com.righteous.innovate.task.entity.PointsEntity;
import com.righteous.innovate.task.service.PointsService;


@Service("pointsService")
public class PointsServiceImpl extends ServiceImpl<PointsDao, PointsEntity> implements PointsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PointsEntity> page = this.page(
                new Query<PointsEntity>().getPage(params),
                new QueryWrapper<PointsEntity>()
        );

        return new PageUtils(page);
    }

}