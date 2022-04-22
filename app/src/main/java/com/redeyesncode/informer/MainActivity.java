package com.redeyesncode.informer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.redeyesncode.informer.customDialogCode.RedEyesNCode;
import com.redeyesncode.informer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Created the default libary module and Added. The libary in the local of the Sample Project itself.
        binding.btnShowSuccessDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Making the Object of the class declared in the libary
                RedEyesNCode redEyesNCode = new RedEyesNCode(MainActivity.this);
                redEyesNCode.initiateSuccessDialog(MainActivity.this,"Important Alert !","This is a success dialog",false,false);

            }
        });







    }
}