package com.example.gradlespringboot.mapper;

import com.example.gradlespringboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User findUserByName(String name);
}
