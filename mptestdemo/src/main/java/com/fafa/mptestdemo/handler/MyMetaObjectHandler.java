package com.fafa.mptestdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Sire
 * @version 1.0
 * @date 2022-01-30 15:04
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 执行添加时的操作
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        // 添加时的默认 version 是 1
        this.setFieldValByName("version", 1, metaObject);
        this.setFieldValByName("deleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        // 修改删除状态
        this.setFieldValByName("deleted", 1, metaObject);
    }
}
