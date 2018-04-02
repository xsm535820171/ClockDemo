package com.my.clock;

import android.app.Activity;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Notification详细信息参考 https://www.cnblogs.com/travellife/p/Android-Notification-xiang-jie.html
 * Created by AOW on 2018/3/30.
 * Notification，是一种具有全局效果的通知，可以在系统的通知栏中显示。当 APP 向系统发出通知时，
 * 它将先以图标的形式显示在通知栏中。用户可以下拉通知栏查看通知的详细信息。
 * 通知栏和抽屉式通知栏均是由系统控制，用户可以随时查看
 * Notification的功能和用法,程序一般通过NotificationManager服务来发送Notification
 * 发送通知的步骤：
 * 1，调用getSystemService(NOTIFICATION_SERVICE)方法获取系统的NotificationManager服务
 * 2，通过构造器创建一个Notification对象
 * 3，为Notification设置各种属性
 * 4，通过NotificationManager发送Notification
 *
 * 创建一个简单的 Notification 。主要有以下三步：
         获取 NotificationManager 实例
         实例化 NotificationCompat.Builder 并设置相关属性
         通过 builder.build() 方法生成 Notification 对象,并发送通知
 */

//通知的目的是告知用户 App 事件。在平时的使用中，通知主要有以下几个作用：
//        显示接收到短消息、及时消息等信息（如QQ、微信、新浪、短信）
//        显示客户端的推送消息，如广告、优惠、版本更新、推荐新闻等，常用的第三方 SDK 有： JPush 、 个推 、 信鸽 、 网易云信(偏重 IM ) 、 阿里云推送
//        显示正在进行的事物，例如：后台运行的程序，如音乐播放进度、下载进度等
//        其中，前两点可以归结为与用户交互，第三点是实时的任务提醒，但不可否认的是，第三点也会与用户交互。

public class NotificationActivity extends Activity {

    static final int NITIFICATION_id=0x111;
    @ViewInject(R.id.ok_bt)
    Button ok_bt;
    @ViewInject(R.id.cancel_bt)
    Button cancel_bt;

    @OnClick({R.id.ok_bt,R.id.cancel_bt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ok_bt:
//                Intent intent=new Intent(NotificationActivity.this,ProgressActivity.class);
//                PendingIntent pi=PendingIntent.getActivities(NotificationActivity.this,0, new Intent[]{intent},0);
//                Notification notification=new Notification();
//                //图标
//                notification.icon=R.mipmap.dog;
//                //通知文本
//                notification.tickerText="启动其他activity的通知";
////                发送时间
//                notification.when=System.currentTimeMillis();
////                设置声音
//                notification.defaults = Notification.DEFAULT_SOUND;
//                notification.defaults = Notification.DEFAULT_LIGHTS;
                long[] vibrate = new long[]{0, 500, 1000, 1500};

                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder notification= (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.dog)
                        .setContentTitle("标题")
                        .setLights(0xFF0000, 3000, 3000)
//
//               android.resource:表示在res文件夹下 com.my.clock：包名  R.raw.wind：文件名字
                        .setSound(Uri.parse("android.resource://com.my.clock/" + R.raw.wind))
                        .setVibrate(vibrate)
                        .setContentText("标题，小图标，内容");
                notificationManager.notify(NITIFICATION_id,notification.build());
                break;
            case R.id.cancel_bt:
                NotificationManager notificationManager1= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager1.cancel(NITIFICATION_id);
                break;

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        ViewUtils.inject(this);
    }
}
