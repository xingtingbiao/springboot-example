package com.example.gradlespringboot.mapper.db2;

import com.example.gradlespringboot.datasource.DSAnnotation;
import com.example.gradlespringboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
@DSAnnotation(value = "datasource2")
public interface UserDB2Mapper {
    User findUserByName(String name);
}
