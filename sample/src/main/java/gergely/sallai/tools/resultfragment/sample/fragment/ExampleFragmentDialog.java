package gergely.sallai.tools.resultfragment.sample.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import gergely.sallai.tools.resultfragment.ResultDialogFragmentBase;
import gergely.sallai.tools.resultfragment.sample.R;

public class ExampleFragmentDialog extends ResultDialogFragmentBase<ExampleFragmentDialog.ResultListener> {

    private static final String DIALOG_TAG = ExampleFragmentDialog.class.getName();

    public interface ResultListener extends ResultDialogFragmentBase.ResultListener {
        void onApply(String result);
        void onCancel();
    }

    private EditText editText;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.d_example, null);
        editText = (EditText) dialogView.findViewById(R.id.text_edit);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.example_dialog)
                .setView(dialogView)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(ResultListener listener: getListeners()) {
                            listener.onApply(editText.getText().toString());
                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (ResultListener listener : getListeners()) {
                            listener.onCancel();
                        }
                    }
                })
                .create();
        return dialog;
    }

    public static void showDialog(FragmentManager fragmentManager) {
        showDialog(fragmentManager, null);
    }

    public static void showDialog(FragmentManager fragmentManager, Fragment targetFragment) {
        ExampleFragmentDialog dialog = (ExampleFragmentDialog) fragmentManager.findFragmentByTag(DIALOG_TAG);
        if (dialog == null) {
            dialog = newInstance();
            dialog.setTargetFragment(targetFragment, 0);
            dialog.show(fragmentManager, DIALOG_TAG);
        }
    }

    protected static ExampleFragmentDialog newInstance() {
        ExampleFragmentDialog dialog = new ExampleFragmentDialog();
        dialog.setCancelable(false);
        return dialog;
    }
}
