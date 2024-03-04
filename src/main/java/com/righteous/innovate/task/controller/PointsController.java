package com.righteous.innovate.task.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.task.entity.PointsEntity;
import com.righteous.innovate.task.service.PointsService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.R;



/**
 * 积分表
 *
 * @author zrj
 * @email zrj2214537@163.com
 * @date 2024-03-03 17:07:34
 */
@RestController
@RequestMapping("task/points")
public class PointsController {
    @Autowired
    private PointsService pointsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("task:points:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pointsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordId}")
    //@RequiresPermissions("task:points:info")
    public R info(@PathVariable("recordId") Integer recordId){
		PointsEntity points = pointsService.getById(recordId);

        return R.ok().put("points", points);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("task:points:save")
    public R save(@RequestBody PointsEntity points){
		pointsService.save(points);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("task:points:update")
    public R update(@RequestBody PointsEntity points){
		pointsService.updateById(points);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("task:points:delete")
    public R delete(@RequestBody Integer[] recordIds){
		pointsService.removeByIds(Arrays.asList(recordIds));

        return R.ok();
    }

}
