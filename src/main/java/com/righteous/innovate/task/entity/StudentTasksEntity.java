package com.righteous.innovate.task.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生任务关联表
 * 
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@Data
@TableName("student_tasks")
public class StudentTasksEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录ID
	 */
	@TableId
	private Integer recordId;
	/**
	 * 学生ID
	 */
	private Integer studentId;
	/**
	 * 任务ID
	 */
	private Integer taskId;
	/**
	 * 完成状态
	 */
	private Integer completionStatus;
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
