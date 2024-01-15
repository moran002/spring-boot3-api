package com.moran.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author moran
 * @since 2024-01-15 15:09:05
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @TableField("`name`")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
        "id = " + id +
        ", name = " + name +
        "}";
    }
}
