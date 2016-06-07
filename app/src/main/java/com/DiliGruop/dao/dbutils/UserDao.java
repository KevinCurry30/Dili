package com.DiliGruop.dao.dbutils;

import android.content.Context;

import com.DiliGruop.dao.table.DBUser;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class UserDao {
    private Context context;
    private Dao<DBUser, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(DBUser.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加一个用户
     *
     * @param user
     * @throws SQLException
     */
    public void addUser(DBUser user) {
        /*//事务操作
        TransactionManager.callInTransaction(helper.getConnectionSource(),
				new Callable<Void>()
				{

					@Override
					public Void call() throws Exception
					{
						return null;
					}
				});*/
        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据id删除一个user
     *
     * @param id
     */
    public void deleteUserById(int id) {
        try {
            userDaoOpe.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(DBUser user) {
        try {

            userDaoOpe.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        {

        }
    }

    public void updataUser(DBUser user) {
        try {
            userDaoOpe.update(user);
            //	userDaoOpe.u
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updataUserById(DBUser user, int id) {
        try {
            userDaoOpe.updateId(user, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DBUser queryUser(int id) {
        DBUser user = null;
        try {
            user = userDaoOpe.queryForId(id);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  查询所有的 user
     * @return
     */
    public List<DBUser> queryListUser() {
        List<DBUser> list_user = null;
        try {
            list_user = userDaoOpe.queryForAll();
            return list_user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
