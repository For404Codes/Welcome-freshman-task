package com.righteous.innovate.task.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 子任务表
 * 
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@Data
@TableName("sub_tasks")
public class SubTasksEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 子任务ID
	 */
	@TableId
	private Integer subTaskId;
	/**
	 * 父任务ID
	 */
	private Integer taskId;
	/**
	 * 子任务名称
	 */
	private String subTaskName;
	/**
	 * 子任务描述
	 */
	private String subTaskDescription;
	/**
	 * 子任务类型
	 */
	private String subTaskType;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 任务等级
	 */
	private Integer level;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建者用户ID
	 */
	private Integer createdUser;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新者用户ID
	 */
	private Integer updatedUser;
	/**
	 * 是否删除（1是，0否）
	 */
	private Integer isDelete;

}
