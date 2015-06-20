package com.example.aidan.takepills;

/**
 * Created by Aidan on 6/21/15.
 */

import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

public class Alert extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Reminder!");
        builder.setMessage("TAKE YOR FUKCIN MEDS");
        //builder.
        return null;
    }
}
