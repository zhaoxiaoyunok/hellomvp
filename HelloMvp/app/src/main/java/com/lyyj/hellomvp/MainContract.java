package com.lyyj.hellomvp;


import android.support.annotation.NonNull;

public interface  MainContract  {
    interface View extends BaseView<Presenter> {
          abstract void changeText(String s);
    }

    interface Presenter extends BasePresenter {
        abstract void saveData(String s);
        abstract void getData( );

    }
}
