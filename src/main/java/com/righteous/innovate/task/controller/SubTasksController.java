package com.righteous.innovate.task.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.task.entity.SubTasksEntity;
import com.righteous.innovate.task.service.SubTasksService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.R;



/**
 * 子任务表
 *
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@RestController
@RequestMapping("task/subtasks")
public class SubTasksController {
    @Autowired
    private SubTasksService subTasksService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("task:subtasks:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = subTasksService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{subTaskId}")
    //@RequiresPermissions("task:subtasks:info")
    public R info(@PathVariable("subTaskId") Integer subTaskId){
		SubTasksEntity subTasks = subTasksService.getById(subTaskId);

        return R.ok().put("subTasks", subTasks);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("task:subtasks:save")
    public R save(@RequestBody SubTasksEntity subTasks){
		subTasksService.save(subTasks);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("task:subtasks:update")
    public R update(@RequestBody SubTasksEntity subTasks){
		subTasksService.updateById(subTasks);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("task:subtasks:delete")
    public R delete(@RequestBody Integer[] subTaskIds){
		subTasksService.removeByIds(Arrays.asList(subTaskIds));

        return R.ok();
    }

}
