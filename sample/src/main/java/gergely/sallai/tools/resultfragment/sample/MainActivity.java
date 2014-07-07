package gergely.sallai.tools.resultfragment.sample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import gergely.sallai.tools.resultfragment.sample.fragment.ExampleFragmentDialog;


public class MainActivity extends ActionBarActivity {

    View activityListensExample;
    View targetFragmentListensExample;
    View manualListenerExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityListensExample = findViewById(R.id.activity_listens);
        targetFragmentListensExample = findViewById(R.id.targetfragment_listens);
        manualListenerExample = findViewById(R.id.manual_listener);

        activityListensExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityStartsDialogFragment.class));
            }
        });
        targetFragmentListensExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityTargetFragmentExample.class));
            }
        });
        // TODO others
    }
}
