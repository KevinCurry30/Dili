package com.DiliGruop.dao.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * 数据库订单表;
 * Created by Kevin on 2016/5/9.
 */
@DatabaseTable
public class DBOrder implements Serializable {

    @DatabaseField(generatedId =true)public String id;
    @DatabaseField(columnName = "address") public  String address;
    @DatabaseField(columnName = "order_id") public int order_id;
    @DatabaseField(columnName = "order_desc") public String order_desc;
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
