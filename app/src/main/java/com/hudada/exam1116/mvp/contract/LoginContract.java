package com.hudada.exam1116.mvp.contract;

import com.hudada.exam1116.bean.LoginBean;
import com.hudada.exam1116.mvputil.IModel;
import com.hudada.exam1116.mvputil.IView;

import io.reactivex.Observer;

public interface LoginContract {
    interface loginModel extends IModel{
        void loginmodel_(Observer<LoginBean> observer,String name,String pwd);
    }
    interface loginView extends IView{
        void onOk(LoginBean loginBean);
        String getName();
        String getPwd();
    }
}
