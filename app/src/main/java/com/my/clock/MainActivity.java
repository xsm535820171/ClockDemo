package com.my.clock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.autotext_bt)
    Button autotext_bt;
    @ViewInject(R.id.clock_bt)
    Button clock_bt;
    @ViewInject(R.id.img_bt)
    Button img_bt;

    @OnClick({R.id.clock_bt,R.id.img_bt,R.id.autotext_bt,R.id.progress_bt,R.id.notification_bt,R.id.menu_bt})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.autotext_bt:
                Intent intent1=new Intent(MainActivity.this,AutocompleteTextActicity.class);
                startActivity(intent1);
                break;
            case R.id.img_bt:
                Intent intent2=new Intent(MainActivity.this,ImageActivity.class);
                startActivity(intent2);
                break;
            case R.id.clock_bt:
                Intent intent3=new Intent(MainActivity.this,ClockActivity.class);
                startActivity(intent3);
                break;
            case R.id.progress_bt:
                Intent intent4=new Intent(MainActivity.this,ProgressActivity.class);
                startActivity(intent4);
                break;
            case R.id.notification_bt:
                Intent intent5=new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent5);
            case R.id.menu_bt:
                Intent intent6=new Intent(MainActivity.this,MenuActivty.class);
                startActivity(intent6);
                break;
            default:
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
    }
}
