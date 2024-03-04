package com.righteous.innovate.task.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.task.entity.StudentTasksEntity;
import com.righteous.innovate.task.service.StudentTasksService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.R;



/**
 * 学生任务关联表
 *
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@RestController
@RequestMapping("task/studenttasks")
public class StudentTasksController {
    @Autowired
    private StudentTasksService studentTasksService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("task:studenttasks:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentTasksService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordId}")
    //@RequiresPermissions("task:studenttasks:info")
    public R info(@PathVariable("recordId") Integer recordId){
		StudentTasksEntity studentTasks = studentTasksService.getById(recordId);

        return R.ok().put("studentTasks", studentTasks);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("task:studenttasks:save")
    public R save(@RequestBody StudentTasksEntity studentTasks){
		studentTasksService.save(studentTasks);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("task:studenttasks:update")
    public R update(@RequestBody StudentTasksEntity studentTasks){
		studentTasksService.updateById(studentTasks);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("task:studenttasks:delete")
    public R delete(@RequestBody Integer[] recordIds){
		studentTasksService.removeByIds(Arrays.asList(recordIds));

        return R.ok();
    }

}
