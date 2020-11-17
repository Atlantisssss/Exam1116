package com.hudada.exam1116.mvp.presenter;

import com.hudada.exam1116.bean.KeyBean;
import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.mvp.contract.LoginContract;
import com.hudada.exam1116.mvp.contract.RegisterContract;
import com.hudada.exam1116.mvputil.IPresenterImpl;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RegisterIPresenter extends IPresenterImpl<RegisterContract.register_model,RegisterContract.register_view> {

    public RegisterIPresenter(RegisterContract.register_model mModel, RegisterContract.register_view mView) {
        super(mModel, mView);
    }

    public void register_presenter(){
        mModel.loginmodel_(new Observer<KeyBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(KeyBean keyBean) {
                mView.onOk(keyBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },mView.getName(),mView.getPwd(),mView.getEmil());
    }
}
