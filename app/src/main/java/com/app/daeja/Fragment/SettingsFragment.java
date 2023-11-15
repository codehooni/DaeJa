package com.app.daeja.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.daeja.Activity.LoginActivity;
import com.app.daeja.Activity.Settings_Account;
import com.app.daeja.Activity.Settings_Location;
import com.app.daeja.Activity.Settings_Notification;
import com.app.daeja.Activity.Settings_Share;
import com.app.daeja.Activity.Settings_Support;
import com.app.daeja.Activity.Settings_change_profile;
import com.app.daeja.R;

public class SettingsFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_settings, container, false);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Account 버튼에 대한 클릭 이벤트 설정
        ImageView accountImageView = view.findViewById(R.id.imageView9);
        accountImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Settings_Account 액티비티로 이동하는 코드
                Intent intent = new Intent(getActivity(), Settings_Account.class);
                startActivity(intent);
            }
        });

        // Notification 버튼에 대한 클릭 이벤트 설정
        ImageView notificationImageView = view.findViewById(R.id.imageView1);
        notificationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Settings_Notification 액티비티로 이동하는 코드
                Intent notificationIntent = new Intent(getActivity(), Settings_Notification.class);
                startActivity(notificationIntent);
            }
        });

        // Location 버튼에 대한 클릭 이벤트 설정
        ImageView locationImageView = view.findViewById(R.id.imageVie42342);
        locationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Settings_Location 액티비티로 이동하는 코드
                Intent locationIntent = new Intent(getActivity(), Settings_Location.class);
                startActivity(locationIntent);
            }
        });

        // Support 버튼에 대한 클릭 이벤트 설정
        ImageView supportImageView = view.findViewById(R.id.imageVie2532);
        supportImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Settings_Support 액티비티로 이동하는 코드
                Intent supportIntent = new Intent(getActivity(), Settings_Support.class);
                startActivity(supportIntent);
            }
        });

        // Share 버튼에 대한 클릭 이벤트 설정
        ImageView shareImageView = view.findViewById(R.id.imageVie2679);
        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Settings_Share 액티비티로 이동하는 코드
                Intent shareIntent = new Intent(getActivity(), Settings_Share.class);
                startActivity(shareIntent);
            }
        });

        // Edit Profile 버튼에 대한 클릭 이벤트 설정
        ImageView editProfileImageView = view.findViewById(R.id.imageView4);
        editProfileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Settings_change_profile 액티비티로 이동하는 코드
                Intent editProfileIntent = new Intent(getActivity(), Settings_change_profile.class);
                startActivity(editProfileIntent);
            }
        });

        // 이미지 버튼에 대한 클릭 이벤트 설정
        ImageView loginButton = view.findViewById(R.id.imageVie2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지 버튼 클릭 시 LoginActivity로 이동하는 코드
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(loginIntent);
                // 현재 액티비티를 종료 (선택적으로)
                getActivity().finish();
            }
        });



    }
}
