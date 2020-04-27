package com.chnn10.community.dao;

import com.chnn10.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *  user实体类得接口
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
