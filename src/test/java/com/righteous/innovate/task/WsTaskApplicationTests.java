package com.righteous.innovate.task;

import com.righteous.innovate.task.entity.TasksEntity;
import com.righteous.innovate.task.service.TasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false)
class WsTaskApplicationTests {

    @Autowired
    TasksService tasksService;
    @Test
    void contextLoads() {
        TasksEntity tasksEntity = new TasksEntity();
        tasksEntity.setTaskName("测试任务1");
        tasksEntity.setTaskDescription("用于单元测试");
        tasksEntity.setTaskType("测试");
        tasksService.save(tasksEntity);
        System.out.println("保存成功。。。");
    }

}
