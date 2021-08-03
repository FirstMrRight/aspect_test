package org.liutx.aspect_demo.service;

import lombok.extern.slf4j.Slf4j;
import org.liutx.aspect_demo.Metrics;
import org.liutx.aspect_demo.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Metrics(ignoreException = true)
public class UserService {

    public void createUser(UserEntity entity) {
        if (entity.getName().contains("test")) {
            throw new RuntimeException("invalid username!");
        }
    }

    public int getUserCount(String name) {
        return Integer.MAX_VALUE;
    }
}
