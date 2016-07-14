package com.lyyj.hellomvp;


import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.Presenter {



    private final MainContract.View mMainView;
    private final Repository mRepository;


    public MainPresenter( @NonNull Repository repo,@NonNull MainContract.View mainView) {

        mMainView = checkNotNull(mainView, "mainView cannot be null!");
        mRepository = repo;
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {
       // mMainView.changeText("文本onresume presnter start");
        mRepository.getData(new DataSource.GetDataCallback() {
            @Override
            public void onDataLoaded(String s) {
                mMainView.changeText("文本onresume presnter start"+(TextUtils.isEmpty(s)? "":s));
            }
        });

    }

    @Override
    public void saveData(String s) {
        mRepository.saveData("文本presenter save data"+s);

    }

    @Override
    public void getData( ) {
        mRepository.getData(new DataSource.GetDataCallback() {
            @Override
            public void onDataLoaded(String s) {
                mMainView.changeText("文本presenter get data"+(TextUtils.isEmpty(s)? "":s));
            }
        });
    }
}