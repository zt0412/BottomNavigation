package com.example.bottomnavigation;

import androidx.lifecycle.ViewModelProviders;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FirstFragment extends Fragment {

    private FirstViewModel mViewModel;
    private ImageView mImageView;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.first_fragment, container, false);
        mImageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 第一个参数决定ViewModel生命周期， fragment or activey or ...
        mViewModel = ViewModelProviders.of(requireActivity()).get(FirstViewModel.class);
        mImageView.setRotation(mViewModel.rotation);

        // 属性动画
        final ObjectAnimator objAnimator = ObjectAnimator.ofFloat(mImageView, "rotation", 0, 0);
        objAnimator.setDuration(500);
        mImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!objAnimator.isRunning()){
                    mViewModel.rotation += 90;
                    objAnimator.setFloatValues(mImageView.getRotation(), mImageView.getRotation()+90);
                    objAnimator.start();
                }
            }
        });
    }

}
