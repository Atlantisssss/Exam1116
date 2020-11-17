package com.hudada.exam1116.mvp.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hudada.exam1116.R;
import com.hudada.exam1116.bean.LoginBean;
import com.hudada.exam1116.mvp.contract.LoginContract;
import com.hudada.exam1116.mvp.model.LoginModel;
import com.hudada.exam1116.mvp.presenter.LoginPresenter;
import com.hudada.exam1116.mvp.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.loginView {
    private EditText loginUsername;
    private EditText loginUserpwd;
    private Button loginButt;
    private LoginPresenter loginPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_login, container, false);
        loginPresenter=new LoginPresenter(new LoginModel(),this);
        loginUsername = (EditText) inflate.findViewById(R.id.login_username);
        loginUserpwd = (EditText) inflate.findViewById(R.id.login_userpwd);
        loginButt = (Button) inflate.findViewById(R.id.login_butt);
        loginButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login_presenter();
            }
        });
        return inflate;
    }

    @Override
    public void onOk(LoginBean loginBean) {
        int code = loginBean.getCode();
        //如果登录的返回码是200就登录成功跳转页面
        if(code==200){
            getActivity().getSharedPreferences("user", Context.MODE_PRIVATE).edit()
                    .putBoolean("islogin",true)
                    .commit();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
        showMsg(code+"");
    }

    @Override
    public String getName() {
        String name = loginUsername.getText().toString().trim();
        return name;
    }

    @Override
    public String getPwd() {
        String pwd = loginUserpwd.getText().toString().trim();
        return pwd;
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
