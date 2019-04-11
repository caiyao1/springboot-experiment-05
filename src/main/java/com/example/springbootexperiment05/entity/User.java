package com.example.springbootexperiment05.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String userName;
    //当序列化对象时，忽略密码属性
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String detail;

    public User(int id,String userName,String password,String detail){
        this.id=id;
        this.userName=userName;
        this.password=password;
        this.detail=detail;
    }
}
