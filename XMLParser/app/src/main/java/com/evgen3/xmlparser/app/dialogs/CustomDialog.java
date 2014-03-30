package com.evgen3.xmlparser.app.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.evgen3.xmlparser.app.R;

/**
 * Created by Евгений on 24.03.2014.
 */
public class CustomDialog extends DialogFragment {


    private Activity activity;
    SharedPreferences spref;
    final String saved_id = "saved_id";
    EditText editTextID;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog_layout, null);

        editTextID = (EditText) dialogView.findViewById(R.id.editTextID);

        builder.setView(dialogView)
                .setPositiveButton(R.string.custom_dialog_positive, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }
                )
                .

                        setNegativeButton(R.string.custom_dialog_negative, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dismiss();
                                    }
                                }
                        );

        return builder.create();
    }
}


