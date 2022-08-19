package com.example.demo_layout1.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_layout1.App;
import com.example.demo_layout1.R;
import com.example.demo_layout1.databinding.ActivityPermissionBinding;

public class PermissionActivity extends AppCompatActivity {
    ActivityPermissionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPermissionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setClick();
    }

    public void setClick() {
        binding.cbPermission.setOnCheckedChangeListener((compoundButton, b) -> {
            if (binding.cbPermission.isChecked()) {
                binding.btnStart.setBackground(getDrawable(R.drawable.color_button_start_on));
                binding.tvStart.setTextColor(getColor(R.color.white));
            } else {
                binding.btnStart.setBackground(getDrawable(R.drawable.color_button_start_off));
                binding.tvStart.setTextColor(getColor(R.color.color_AAADA7));
            }
        });
        binding.btnStart.setOnClickListener(v -> {
            App.sharePref.setIsConfirm(true);
            Intent intent = new Intent(PermissionActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }

}