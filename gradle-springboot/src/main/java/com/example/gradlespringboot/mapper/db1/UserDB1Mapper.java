package com.example.gradlespringboot.mapper.db1;

import com.example.gradlespringboot.datasource.DSAnnotation;
import com.example.gradlespringboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
@DSAnnotation(value = "datasource1")
public interface UserDB1Mapper {
    User findUserByName(String name);
}
