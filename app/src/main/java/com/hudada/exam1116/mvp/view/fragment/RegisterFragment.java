package com.hudada.exam1116.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hudada.exam1116.R;
import com.hudada.exam1116.bean.KeyBean;
import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.mvp.contract.RegisterContract;
import com.hudada.exam1116.mvp.model.RegisterModel;
import com.hudada.exam1116.mvp.presenter.RegisterIPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterContract.register_view {
    private EditText registerUsername;
    private EditText registerUserpwd;
    private EditText registerEmil;
    private Button registerButt;
    private RegisterIPresenter registerIPresenter;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_register, container, false);

        registerIPresenter=new RegisterIPresenter(new RegisterModel(),this);
        registerUsername = (EditText) inflate.findViewById(R.id.register_username);
        registerUserpwd = (EditText) inflate.findViewById(R.id.register_userpwd);
        registerEmil = (EditText) inflate.findViewById(R.id.register_emil);
        registerButt = (Button) inflate.findViewById(R.id.register_butt);
        registerButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerIPresenter.register_presenter();
            }
        });
        return inflate;
    }

    @Override
    public void onOk(KeyBean keyBean) {
        int code = keyBean.getCode();
        if(code==200){
            getActivity().getSharedPreferences("user", Context.MODE_PRIVATE).edit()
                    .putString("key",keyBean.getResult().getApikey()).commit();
        }
        showMsg(code+"");
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
    public String getEmil() {
        String emil = registerEmil.getText().toString().trim();
        return emil;
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }

}
