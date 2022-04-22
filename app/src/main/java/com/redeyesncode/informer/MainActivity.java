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
        RedEyesNCode redEyesNCode = new RedEyesNCode(MainActivity.this);
        //Created the default libary module and Added. The libary in the local of the Sample Project itself.
        binding.btnShowSuccessDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Making the Object of the class declared in the libary

                redEyesNCode.initiateSuccessDialog(MainActivity.this,"Success !","This is a success dialog",false,false);

            }
        });
        //Creating the default error dialog.
        binding.btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redEyesNCode.intiateErrorDialog(MainActivity.this,"Error !","This is a sample error Message !",true,true);

            }
        });
        //Creating the Deafault warning dialog.
        binding.btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redEyesNCode.intiateWarningDialog(MainActivity.this,"Warning !","This is sample warning message !",true,true);
            }
        });








    }
}