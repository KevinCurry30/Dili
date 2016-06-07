package com.DiliGruop.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.DiliGruop.R;
import com.DiliGruop.dao.dbutils.OrderDao;
import com.DiliGruop.dao.dbutils.UserDao;
import com.DiliGruop.dao.table.DBOrder;
import com.DiliGruop.dao.table.DBUser;
import com.DiliGruop.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 测试 数据库操作 View
 */
public class DBTestActivity extends AppCompatActivity {
    @Bind(R.id.bt_add)
    Button bt_add;
    @Bind(R.id.bt_delete)
    Button bt_delete;
    @Bind(R.id.bt_updata)
    Button bt_updata;
    @Bind(R.id.bt_query)
    Button bt_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_add)
    public void add(View v) {
        ToastUtil.showLong(this, "ADD");
        DBUser user = new DBUser();
        user.setName("OYSB");
        user.setId(1);
//        user.setAddress("北京朝阳区呼家楼");
//        user.setAge(33);
//        user.setPhone("13323233233");
//        user.setEmail("wtjandjay@sina.com");
//        user.setSex(2);
        new UserDao(this).addUser(user);
        DBOrder order=new DBOrder();
        order.setOrder_id(0000000000000003);
        order.setAddress("北京国贸光华路333号");
        new OrderDao(this).addOrder(order);
    }

    @OnClick(R.id.bt_delete)
    public void delete(View v) {
        ToastUtil.showShort(this, "Delete");
        new UserDao(this).deleteUserById(1);
    }
//
    @OnClick(R.id.bt_updata)
    public void updata(View v) {
        new UserDao(this).updataUser(null);
    }

    @OnClick(R.id.bt_query)
    public void query(View v) {

    }

}
