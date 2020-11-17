package com.hudada.exam1116.mvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hudada.exam1116.R;
import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.mvp.contract.ReContract;
import com.hudada.exam1116.mvp.model.ReModel;
import com.hudada.exam1116.mvp.presenter.RePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReFragment extends Fragment implements ReContract.register_view {
    private EditText registerUsername;
    private EditText registerUserpwd;
    private Button registerButt;
    private RePresenter rePresenter;
    public ReFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_re, container, false);

        rePresenter=new RePresenter(new ReModel(),this);
        registerUsername = (EditText) inflate.findViewById(R.id.register_username);
        registerUserpwd = (EditText) inflate.findViewById(R.id.register_userpwd);
        registerButt = (Button) inflate.findViewById(R.id.register_butt);
        registerButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rePresenter.Re_presenter();
            }
        });
        return inflate;
    }

    @Override
    public void onOk(RegisterBean registerBean) {
        int code = registerBean.getCode();
        if(code==200){
            showMsg("注册成功");
        }else {
            showMsg("注册失败");
        }
    }

    @Override
    public String getName() {
        String name = registerUsername.getText().toString().trim();
        return name;
    }

    @Override
    public String getPwd() {
        String pwd = registerUserpwd.getText().toString().trim();
        return pwd;
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
