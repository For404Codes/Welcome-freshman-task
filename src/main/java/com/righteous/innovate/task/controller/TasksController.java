package com.righteous.innovate.task.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.task.entity.TasksEntity;
import com.righteous.innovate.task.service.TasksService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.R;



/**
 * 任务表
 *
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@RestController
@RequestMapping("task/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("task:tasks:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tasksService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{taskId}")
    //@RequiresPermissions("task:tasks:info")
    public R info(@PathVariable("taskId") Integer taskId){
		TasksEntity tasks = tasksService.getById(taskId);

        return R.ok().put("tasks", tasks);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("task:tasks:save")
    public R save(@RequestBody TasksEntity tasks){
		tasksService.save(tasks);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("task:tasks:update")
    public R update(@RequestBody TasksEntity tasks){
		tasksService.updateById(tasks);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("task:tasks:delete")
    public R delete(@RequestBody Integer[] taskIds){
		tasksService.removeByIds(Arrays.asList(taskIds));

        return R.ok();
    }

}
