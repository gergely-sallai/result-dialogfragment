package gergely.sallai.tools.resultfragment.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import gergely.sallai.tools.resultfragment.sample.fragment.ExampleFragmentDialog;


public class ActivityStartsDialogFragment extends ActionBarActivity implements ExampleFragmentDialog.ResultListener {

    TextView resultView;
    View showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_starts_dialog_fragment);
        showDialog = findViewById(R.id.show_dialog);
        resultView = (TextView) findViewById(R.id.result_text);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleFragmentDialog.showDialog(getFragmentManager());
            }
        });
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
