package com.hudada.exam1116.mvputil;

public class IPresenterImpl<M extends IModel,V extends IView> implements IPresenter{
    protected M mModel;
    protected V mView;

    public IPresenterImpl(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void destroy() {
        if(mModel!=null){
            mModel.destroy();
            mModel=null;
        }
        System.gc();
    }
}
