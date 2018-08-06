package com.ronit.annotation.processing.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ronit.binder.Binding;
import com.ronit.binder.lib.annotations.BindView;
import com.ronit.binder.lib.annotations.OnClick;

/**
 * @author by Ronit on 2/8/18.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Binding.bind(this);
        tvContent.setText("Hello World!");
    }

    @OnClick(R.id.bt_1)
    void bt1Click(View view){
        tvContent.setText("Button1 Clicked");
    }

    @OnClick(R.id.bt_2)
    void bt2Click(View view){
        tvContent.setText("Button2 Clicked");
    }

}
