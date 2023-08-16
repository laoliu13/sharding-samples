package com.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = -1205226416664488559L;

    private Long id;

    private String city;

    private String name;
}
