package com.example.springbootexperiment05.controller;

import com.example.springbootexperiment05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    private static List<User> users=create();
    public static List<User> create(){
        users=new ArrayList<>();
        User user = new User(1, "andy", "123456", "956");
        User user1 = new User(2, "scott", "1122", "1021");
        User user2 = new User(3, "james", "5544", "1221");
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }

    @GetMapping("/index")
    public Map getIndex(){
        return Map.of("index","main");
    }

    @GetMapping("/users")
    public Map getUsers(){
        return Map.of("users",users);
    }

    /**
     * 获取请求地址user ID参数，基于参数从users集合中获取对象，封装到map返回。注意Map.of()不能添加null，因此需处理如果集合中没有指定ID对象的实现
     * @param uid
     * @return
     */
    @GetMapping("/users/{uid}")
    public Map getUser(@PathVariable int uid){
        log.debug("{}", uid);
        User user=users.stream()
                .filter(u -> u.getId()==uid)
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(user)
                .map(u->Map.of("user",u))
                .orElse(Map.of());
    }
}
