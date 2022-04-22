package com.redeyesncode.informer.customDialogCode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.redeyesncode.informer.R;

public class RedEyesNCode {
    private  Context context;
    private Dialog dialog;


    public RedEyesNCode(Context context) {
        this.context = context;
        this.dialog = dialog;
        dialog = new Dialog(context, R.style.RoundedCornersDialog);
        dialog.setContentView(R.layout.common_dialog_box_success);
    }
    public void initiateSuccessDialog(Context context, String successTitle,String message,boolean isCancelable,boolean isCanceledonOutsideTouch){
        dialog.setCancelable(isCancelable);
        dialog.setCanceledOnTouchOutside(isCanceledonOutsideTouch);
        dialog.show();
        TextView textViewMessage, textViewSuccess;
        textViewMessage = dialog.findViewById(R.id.tvSetText);
        textViewSuccess = dialog.findViewById(R.id.successTitle);
        textViewMessage.setText(message);
        textViewSuccess.setText(successTitle);

        LinearLayout btnOk, btnCancel;
        btnCancel = dialog.findViewById(R.id.btnCancel);






        if(isCancelable && isCanceledonOutsideTouch){
            btnCancel.setVisibility(View.VISIBLE);
        }else {
            btnCancel.setVisibility(View.GONE);
        }


    }

    public void dissmiss(){

        dialog.dismiss();
    }


}