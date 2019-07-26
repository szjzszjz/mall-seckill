package com.szjz.mallseckill.context.base;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** 基础的实体类 所有实体类的父类*/
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {


    private static final long serialVersionUID = 4272710411056094979L;

    /**
     * 自增长ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Column(nullable = false, updatable = false)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(nullable = false)
    private Date gmtModified;

    /**
     * 是否已删除
     */
    @Column(nullable = false)
    private Boolean isDeleted;


}
