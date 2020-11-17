package com.hudada.exam1116.mvp.presenter;

import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.mvp.contract.ReContract;
import com.hudada.exam1116.mvputil.IPresenterImpl;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RePresenter extends IPresenterImpl<ReContract.register_model, ReContract.register_view> {
    public RePresenter(ReContract.register_model mModel, ReContract.register_view mView) {
        super(mModel, mView);
    }
    public void Re_presenter(){
        mModel.loginmodel_(new Observer<RegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterBean registerBean) {
                mView.onOk(registerBean);
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
