package com.hudada.exam1116.mvp.presenter;

import com.hudada.exam1116.bean.LoginBean;
import com.hudada.exam1116.mvp.contract.LoginContract;
import com.hudada.exam1116.mvputil.IPresenterImpl;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginPresenter extends IPresenterImpl<LoginContract.loginModel,LoginContract.loginView> {
    public LoginPresenter(LoginContract.loginModel mModel, LoginContract.loginView mView) {
        super(mModel, mView);
    }
    public void login_presenter(){
        mModel.loginmodel_(new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                mView.onOk(loginBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },mView.getName(),mView.getPwd());
    }
}
