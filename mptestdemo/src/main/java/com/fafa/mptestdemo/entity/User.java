package com.fafa.mptestdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 用户类
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-30 12:27
 */
@Data
public class User {
    /**
     * 主键策略
     * type = IdType.ASSIGN_ID（默认就是这个，不写也没事）
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private Integer age;

    private String email;
    /**
     * 乐观锁version
     * 更新时version会自动加一
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    /**
     * 是否被删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer deleted;

    /**
     * 自动填充
     * fill = FieldFill.INSERT（仅在添加的时候进行填充）
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * fill = FieldFill.INSERT_UPDATE(在添加或者更新时均会进行填充)
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
