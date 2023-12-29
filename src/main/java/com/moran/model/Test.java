package com.moran.model;

import com.moran.conf.tk.DynamicTableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 表名：test
*/
@Getter
@Setter
public class Test extends DynamicTableName {
    @Id
    @Column(name = "`id`")
    private Long id;

    @Column(name = "`name`")
    private String name;
}