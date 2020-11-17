package com.hudada.exam1116.mvp.contract;

import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.mvputil.IModel;
import com.hudada.exam1116.mvputil.IView;

import io.reactivex.Observer;

public interface ReContract {
    interface register_model extends IModel {
        void loginmodel_(Observer<RegisterBean> observer, String name, String pwd);
    }
    interface register_view extends IView {
        void onOk(RegisterBean  registerBean);
        String getName();
        String getPwd();
    }
}
