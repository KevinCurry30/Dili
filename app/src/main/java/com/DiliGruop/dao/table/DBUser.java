package com.DiliGruop.dao.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * 用户表
 */
@DatabaseTable(tableName = "tb_user")
public class DBUser 
{
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(columnName = "name")
	private String name;
	@DatabaseField(columnName = "age")
	private int age;
	@ForeignCollectionField
	private Collection<DBOrder> order_list;
	@DatabaseField(columnName = "sex")
	public int sex;
	@DatabaseField(columnName = "email")
	public String email;
	@DatabaseField(columnName = "phone")
	public String phone;
	@DatabaseField(columnName = "address")
	public String address;
	public Collection<DBOrder> getArticles()
	{
		return order_list;
	}

	public void setArticles(Collection<DBOrder> order_list)
	{
		this.order_list = order_list;
	}

	public DBUser()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", articles=" + order_list
				+ "]";
	}

	


	
}
