package com.whatsmename.hal9000.dialogs;

import com.whatsmename.hal9000.Shutdown;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.R;

public class AreYouSureDialog extends DialogFragment {
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are You Sure?")
        	.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int id) {
        			Shutdown.shutdown_sys();
        			}
        		})
	        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int id) {
	                 // User cancelled the dialog
	          	    }
                });
	       	// Create the AlertDialog object and return it
        return builder.create();
    }
}