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

public class ThirdFragment extends Fragment {
    private ImageView mImageView;
    private ThirdViewModel mViewModel;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.third_fragment, container, false);
        mImageView = rootView.findViewById(R.id.imageView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ThirdViewModel.class);
        mImageView.setX(mViewModel.x);
        // TODO: Use the ViewModel
        final ObjectAnimator objAnimator = ObjectAnimator.ofFloat(mImageView, "x", 0, 0);
        objAnimator.setDuration(500);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objAnimator.isRunning()){
                    objAnimator.setFloatValues(mImageView.getX() + 100);
                    mViewModel.x += 100;
                    objAnimator.start();
                }
            }
        });
    }

}
