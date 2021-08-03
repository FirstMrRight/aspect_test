package org.liutx.aspect_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.liutx.aspect_demo.Metrics;
import org.liutx.aspect_demo.anno.SysLog;
import org.liutx.aspect_demo.entity.UserEntity;
import org.liutx.aspect_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("metricstest")
@Metrics(logParameters = false, logReturn = false)
public class MetricsController {
    @Autowired
    private UserService userService;


    @SysLog("测试")
    @GetMapping("transaction")
    public int transaction(@RequestParam("name") String name) {
        try {
            userService.createUser(new UserEntity(name));
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
        return userService.getUserCount(name);
    }
}
