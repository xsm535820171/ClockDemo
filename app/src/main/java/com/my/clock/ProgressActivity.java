package com.my.clock;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.Random;

/**
 * Created by AOW on 2018/3/29.
 */

public class ProgressActivity extends Activity {
    @ViewInject(R.id.horiz_progress)
    ProgressBar horiz_progress;
    @ViewInject(R.id.horiz_progress_value)
    TextView horiz_progress_value;
    @ViewInject(R.id.seekerbar)
    SeekBar seekerbar;
    @ViewInject(R.id.iv_seekbar)
    ImageView iv_seekbar;
    @ViewInject(R.id.rating_bar)
    RatingBar rating_bar;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x011:
                    horiz_progress.setProgress(status);
                    horiz_progress.incrementProgressBy(10);
                    horiz_progress_value.setText(status+"%");
            }

        }
    };
    int status=0;
    int hasData=0;
    int[] data=new int[100];
    @OnClick({R.id.showDialog})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.showDialog:
                ProgressDialog dialog = new ProgressDialog(ProgressActivity.this);
                // 设置对话框参数
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("软件下载");
                dialog.setMessage("软件下载进度：");
                dialog.setCancelable(false);
                // 设置进度条参数
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMax(100);
                dialog.incrementProgressBy(20);
                dialog.setIndeterminate(false); // 填false表示是明确显示进度的 填true表示不是明确显示进度的
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ProgressActivity.this , "确定" , Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ProgressActivity.this , "取消" , Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);
        ViewUtils.inject(this);

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (status<100) {
                    status=doWork();
                    if(status>20){
                        Message msg=new Message();
                        msg.what=0x011;
                        handler.sendMessage(msg);
                    }
                }
            }
        }.start();
        seekerbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                iv_seekbar.setAlpha(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                iv_seekbar.setAlpha((int)(v*255/5));
            }
        });
    }
    public int doWork(){
        data[hasData]=(int)(Math.random())*100;
        hasData++;
        try {

            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return hasData;
    }

}
