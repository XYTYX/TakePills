package com.example.aidan.takepills;

/**
 * Created by Byron on 6/21/15.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DatabaseActivity extends ActionBarActivity {

    TextView idView;
    EditText medBox;
    EditText doseBox;
    EditText statusBox;
    EditText dateBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_add_alert);

        idView = (TextView) findViewById(R.id.title_alert);
        medBox = (EditText) findViewById(R.id.name_entry);
        doseBox = (EditText) findViewById(R.id.dosage_entry);
        statusBox = (EditText) findViewById(R.id.morning);
        dateBox = (EditText) findViewById(R.id.dateend_entry);
    }

    public void newMed (View view) {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);

        takePillsDb name = new takePillsDb();

        dbHandler.addMeds(name);
        medBox.setText("");
        doseBox.setText("");
        statusBox.setText("");
        dateBox.setText("");
    }


}