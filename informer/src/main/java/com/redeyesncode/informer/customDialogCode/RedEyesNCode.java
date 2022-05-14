package com.redeyesncode.informer.customDialogCode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.snackbar.Snackbar;
import com.redeyesncode.informer.R;

public class RedEyesNCode {
    private  Context context;
    private Dialog dialog;
    private onClicks onClicks;


    public RedEyesNCode(Context context) {
        this.context = context;
        this.dialog = dialog;
        dialog = new Dialog(context, R.style.RoundedCornersDialog);

    }
    public RedEyesNCode(Context context,onClicks onClicks) {
        this.context = context;
        this.dialog = dialog;
        this.onClicks = onClicks;
        dialog = new Dialog(context, R.style.RoundedCornersDialog);

    }

    public void intitateInteractiveDialog(Context context,String messageTitle,String message, String optionOneText, String optionTwoText,boolean isCancelable){
        dialog.setContentView(R.layout.common_dialog_box_error);
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCancelable);
        dialog.show();
        LinearLayout btnPositive, btnNegative;
        btnPositive = dialog.findViewById(R.id.btnPositive);
        btnNegative = dialog.findViewById(R.id.btnNegative);
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicks.onNegative();
            }
        });
        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicks.onPositive();
            }
        });
    }
    public interface onClicks{
        void onPositive();
        void onNegative();

    }



    public void intiateErrorDialog(Context context,String errorTitle, String message, boolean isCancelable, boolean isCancelableOutsideTouch){
        dialog.setContentView(R.layout.common_dialog_box_error);
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCancelableOutsideTouch);
        dialog.show();
        TextView textViewMessage, textViewSuccess;
        textViewMessage = dialog.findViewById(R.id.tvSetText);
        textViewSuccess = dialog.findViewById(R.id.successTitle);
        textViewMessage.setText(message);
        textViewSuccess.setText(errorTitle);
        LinearLayout btnOk, btnCancel;
        btnOk = dialog.findViewById(R.id.btnOk);
        btnCancel = dialog.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



    }

    public void intiateWarningDialog(Context context,String warningTitle, String message, boolean isCancelable, boolean isCancelableOutsideTouch){
        dialog.setContentView(R.layout.common_dialog_box_warning);
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCancelableOutsideTouch);
        dialog.show();
        TextView textViewMessage, textViewSuccess;
        textViewMessage = dialog.findViewById(R.id.tvSetText);
        textViewSuccess = dialog.findViewById(R.id.successTitle);
        textViewMessage.setText(message);
        textViewSuccess.setText(warningTitle);
        LinearLayout btnOk, btnCancel;
        btnOk = dialog.findViewById(R.id.btnOk);
        btnCancel = dialog.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



    }


    public void initiateSuccessDialog(Context context, String successTitle,String message,boolean isCancelable,boolean isCanceledonOutsideTouch){
        dialog.setContentView(R.layout.common_dialog_box_success);
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCanceledonOutsideTouch);
        dialog.show();
        TextView textViewMessage, textViewSuccess;
        textViewMessage = dialog.findViewById(R.id.tvSetText);
        textViewSuccess = dialog.findViewById(R.id.successTitle);
        textViewMessage.setText(message);
        textViewSuccess.setText(successTitle);

        LinearLayout btnOk, btnCancel;
        btnOk = dialog.findViewById(R.id.btnOk);
        btnCancel = dialog.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });






        if(isCancelable && isCanceledonOutsideTouch){
            btnCancel.setVisibility(View.VISIBLE);
        }else {
            btnCancel.setVisibility(View.GONE);
        }


    }

    public void dissmiss(){

        dialog.dismiss();
    }

    public void  showSuccessSnackBar(View view,String successMessage, boolean isLong){

        Snackbar snackbar;
        if(isLong){
            snackbar = Snackbar.make(view,successMessage,Snackbar.LENGTH_LONG);

        }else {
            snackbar = Snackbar.make(view,successMessage,Snackbar.LENGTH_SHORT);
        }

        //Steps to create a custom snack bar.. first get the simple snackbar object from snackbar.show()
        // Get the snackBar layout and hide the textview inside the snackbar layout
        // TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text); [Not Supported Now]
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

        TextView textView = layout.findViewById(com.google.android.material.R.id.snackbar_text);
        //Hiding the default snackbar textView.
        textView.setVisibility(View.INVISIBLE);

        //Loading our custom view
        View snackView = LayoutInflater.from(snackbar.getContext()).inflate(R.layout.custom_success_snackbar,null);


        layout.setPadding(0,0,0,0);

        layout.addView(snackView);

        snackbar.show();






    }
    public void showErrorSnackBar(View view, String errorMessage, boolean isLong){
        Snackbar snackbar;
        if(isLong){
            snackbar = Snackbar.make(view,errorMessage,Snackbar.LENGTH_LONG);

        }else {
            snackbar = Snackbar.make(view,errorMessage,Snackbar.LENGTH_SHORT);
        }
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        TextView textView = layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);
        View snackView = LayoutInflater.from(snackbar.getContext()).inflate(R.layout.custom_error_snackbar,null);
        TextView viewError = (TextView) snackView.findViewById(R.id.tvViewError);
        viewError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intiateErrorDialog(context,"Error !",errorMessage,true,true);
                snackbar.dismiss();
            }
        });


        layout.setPadding(0,0,0,0);

        layout.addView(snackView);

        snackbar.show();





    }
    public void showWarningSnackBar(View view,String warningMessage, boolean isLong){
        Snackbar snackbar;
        if(isLong){
            snackbar = Snackbar.make(view,warningMessage,Snackbar.LENGTH_LONG);

        }else {
            snackbar = Snackbar.make(view,warningMessage,Snackbar.LENGTH_SHORT);
        }
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        TextView textView = layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);
        View snackView = LayoutInflater.from(snackbar.getContext()).inflate(R.layout.custom_warning_snackbar,null);
        TextView viewError = (TextView) snackView.findViewById(R.id.tvViewError);
        viewError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intiateWarningDialog(context,"Warning !",warningMessage,true,true);
                snackbar.dismiss();
            }
        });
        layout.setPadding(0,0,0,0);
        layout.addView(snackView);

        snackbar.show();
    }

}
