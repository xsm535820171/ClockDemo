package com.my.clock;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by AOW on 2018/3/28.
 */

public class AutocompleteTextActicity extends Activity {
    String[] books = {"11111","22222","33333"};
    @ViewInject(R.id.actv)
    AutoCompleteTextView actv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletetext);
        ViewUtils.inject(this);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.text,books);
        actv.setAdapter(arrayAdapter);

    }


}
