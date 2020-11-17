package com.hudada.exam1116.mvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.mythreecache.CacheUtil;
import com.hudada.exam1116.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private StandardGSYVideoPlayer standardvideo;
    private ImageView headImg;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);

        //初始化控件并且设置视频地址开始播放视频
        standardvideo = (StandardGSYVideoPlayer) inflate.findViewById(R.id.standardvideo);
        standardvideo.setUp("http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8",false,"电影");
        standardvideo.startPlayLogic();
        headImg = (ImageView) inflate.findViewById(R.id.head_img);
        //这是我自己封装的三级缓存机制
        CacheUtil.getInstance(getContext()).setImageToView("http://p1.music.126.net/yC_df5u0myXVp-bM99K3Lw==/5870292580832850.jpg",headImg);
        return inflate;
    }
}
