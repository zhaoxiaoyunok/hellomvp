package com.lyyj.hellomvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.UUID;

public class MainView extends RelativeLayout implements MainContract.View {

    private TextView mtvHello;

    private MainContract.Presenter mPresenter;


    public MainView(Context context) {
        super(context);
        init();
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        inflate(getContext(), R.layout.main_view_content, this);
        mtvHello = (TextView) findViewById(R.id.tv_main_hello);
        mtvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //changeText("文本被点击了！");
                mPresenter.saveData("文本被点击了！"+ UUID.randomUUID());
            }
        });

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

    }



    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void changeText(String s) {
        mtvHello.setText("文本已改变："+ (TextUtils.isEmpty(s)? "":s));
    }




}