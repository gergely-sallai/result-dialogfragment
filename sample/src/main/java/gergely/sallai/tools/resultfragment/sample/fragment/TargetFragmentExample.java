package gergely.sallai.tools.resultfragment.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import gergely.sallai.tools.resultfragment.sample.R;

public class TargetFragmentExample extends Fragment implements ExampleFragmentDialog.ResultListener {

    TextView resultView;
    View showDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_target_fragment_example, container, false);
        showDialog = rootView.findViewById(R.id.show_dialog);
        resultView = (TextView) rootView.findViewById(R.id.result_text);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleFragmentDialog.showDialog(getFragmentManager(), TargetFragmentExample.this);
            }
        });
        return rootView;
    }

    @Override
    public void onApply(String result) {
        resultView.setText(result);
    }

    @Override
    public void onCancel() {
        resultView.setText(null);
    }
}
