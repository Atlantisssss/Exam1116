package com.hudada.exam1116.mvp.contract;

import com.hudada.exam1116.bean.KeyBean;
import com.hudada.exam1116.bean.LoginBean;
import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.mvputil.IModel;
import com.hudada.exam1116.mvputil.IView;

import io.reactivex.Observer;

public interface RegisterContract {
    interface register_model extends IModel{
        void loginmodel_(Observer<KeyBean> observer, String name, String pwd, String emil);
    }
    interface register_view extends IView{
        void onOk(KeyBean  keyBean);
        String getEmil();
        String getName();
        String getPwd();
    }
}
