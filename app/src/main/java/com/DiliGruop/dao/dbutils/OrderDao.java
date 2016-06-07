package com.DiliGruop.dao.dbutils;

import android.content.Context;

import com.DiliGruop.dao.table.DBOrder;
import com.DiliGruop.dao.table.DBUser;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class OrderDao
{
	private Dao<DBOrder, Integer> articleDaoOpe;
	private DatabaseHelper helper;

	@SuppressWarnings("unchecked")
	public OrderDao(Context context)
	{
		try
		{
			helper = DatabaseHelper.getHelper(context);
			articleDaoOpe = helper.getDao(DBOrder.class);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 添加一个order
	 * 
	 * @param article
	 */
	public void addOrder(DBOrder article)
	{
		try
		{
			articleDaoOpe.create(article);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 通过Id得到一个Article
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DBOrder getOrderWithUser(int id)
	{
		DBOrder order = null;
		try
		{
			order = articleDaoOpe.queryForId(id);
			helper.getDao(DBUser.class).refresh(order.getOrder_id());

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return order;
	}

	/**
	 * 通过Id得到一篇文章
	 * 
	 * @param id
	 * @return
	 */
	public DBOrder getOrder(int id)
	{
		DBOrder order = null;
		try
		{
			order = articleDaoOpe.queryForId(id);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return order;
	}

	/**
	 * 通过UserId获取所有的文章
	 * 
	 * @param userId
	 * @return
	 */
	public List<DBOrder> listByUserId(int userId)
	{
		try
		{
			/*QueryBuilder<Article, Integer> articleBuilder = articleDaoOpe
					.queryBuilder();
			QueryBuilder userBuilder = helper.getDao(User.class).queryBuilder();
			articleBuilder.join(userBuilder);
			
			
			Where<Article, Integer> where = queryBuilder.where();
			where.eq("user_id", 1);
			where.and();
			where.eq("name", "xxx");

			// 或者
			articleDaoOpe.queryBuilder().//
					where().//
					eq("user_id", 1).and().//
					eq("name", "xxx");
			//
			articleDaoOpe.updateBuilder().updateColumnValue("name","zzz").where().eq("user_id", 1);
			where.or(
					//
					where.and(//
							where.eq("user_id", 1), where.eq("name", "xxx")),
					where.and(//
							where.eq("user_id", 2), where.eq("name", "yyy")));*/

			return articleDaoOpe.queryBuilder().where().eq("user_id", userId)
					.query();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
