package com.my.clock;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by AOW on 2018/4/2.
 * 创建选项菜单的核心步骤：

 （1）重写Activity的onCreateOptionMenu(Menu menu)方法，当菜单第一次被加载时调用
 （2）调用Menu 的add( )方法添加菜单项(MenuItem)，同时可以调用MenuItem的setIcon()方法为菜单项设置图标（注：Android 3.0之后，即使添加了图标也不会显示）
 （3）重写Activity的OptionsItemSelected(MenuItem item)来响应菜单项(MenuItem)的点击事件
 */

public class MenuActivty extends Activity implements MenuItem.OnMenuItemClickListener{
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        button=findViewById(R.id.bt_pop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popupMenu=new PopupMenu(MenuActivty.this,view);
                //获取菜单填充器
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) MenuActivty.this);
                popupMenu.show();
            }
        });
    }

    //弹出式菜单的单击事件处理
     @Override
     public boolean onMenuItemClick(MenuItem item) {
                 // TODO Auto-generated method stub
                 switch (item.getItemId()) {
                     case R.id.start:
                             Toast.makeText(this, "复制···", Toast.LENGTH_SHORT).show();
                             break;

                     case R.id.over:
                             Toast.makeText(this, "删除···", Toast.LENGTH_SHORT).show();
                             break;
                     default:
                             break;
                    }
                 return false;
             }

    //    重写onCreateOptionMenu(Menu menu)方法，当菜单第一次被加载时调用
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
//    重写OptionsItemSelected(MenuItem item)来响应菜单项(MenuItem)的点击事件（根据id来区分是哪个item）
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.start:
                Toast.makeText(this,"开始",Toast.LENGTH_LONG).show();
                break;
            case R.id.over:
                Toast.makeText(this,"结束",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
