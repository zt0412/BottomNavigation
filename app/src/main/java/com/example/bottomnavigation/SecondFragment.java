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

public class SecondFragment extends Fragment {
    private ImageView mImageView;
    private SecondViewModel mViewModel;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);
        mImageView = rootView.findViewById(R.id.imageView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(requireActivity()).get(SecondViewModel.class);
        mImageView.setScaleX(mViewModel.scaleFactor);
        mImageView.setScaleY(mViewModel.scaleFactor);
        // TODO: Use the ViewModel

        final ObjectAnimator objAnimatorX = ObjectAnimator.ofFloat(mImageView, "scaleX", 0, 0);
        objAnimatorX.setDuration(500);
        final ObjectAnimator objAnimatorY = ObjectAnimator.ofFloat(mImageView, "scaleY", 0, 0);
        objAnimatorY.setDuration(500);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objAnimatorX.isRunning()){
                    objAnimatorX.setFloatValues(mImageView.getScaleX() + 0.1f);
                    objAnimatorY.setFloatValues(mImageView.getScaleY() + 0.1f);
                    mViewModel.scaleFactor += 0.1f;
                    objAnimatorX.start();
                    objAnimatorY.start();
                }
            }
        });
    }

}
