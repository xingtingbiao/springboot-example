package com.example.gradlespringboot.mapper;

import com.example.gradlespringboot.domain.User;
import com.example.gradlespringboot.mapper.db1.UserDB1Mapper;
import com.example.gradlespringboot.mapper.db2.UserDB2Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapper {

    @Autowired private UserMapper userMapper;
    @Autowired private UserDB1Mapper userDB1Mapper;
    @Autowired private UserDB2Mapper userDB2Mapper;

    @Test
    public void name() {
        User tom = userMapper.findUserByName("tom");
        System.out.println();
        System.out.println(tom.getId());
    }

    @Test
    public void db1() {
        User tom = userDB1Mapper.findUserByName("jack1");
        System.out.println();
        System.out.println(tom.getId());
    }

    @Test
    public void db2() {
        User tom = userDB2Mapper.findUserByName("jack2");
        System.out.println();
        System.out.println(tom.getId());
    }
}
