package com.righteous.innovate.task.dao;

import com.righteous.innovate.task.entity.SubTasksEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 子任务表
 * 
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@Mapper
public interface SubTasksDao extends BaseMapper<SubTasksEntity> {
	
}
