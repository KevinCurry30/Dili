package com.DiliGruop.dao.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * 地址表
 * Created by Kevin on 2016/5/9.
 */
@DatabaseTable
public class DBAddress implements Serializable {
    @DatabaseField public String province;
    @DatabaseField public String shi;
    @DatabaseField public String xiang;
    @DatabaseField public String name;
}
