package com.fafa.mptestdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fafa.mptestdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Sire
 * @version 1.0
 * @date 2022-01-30 12:29
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
