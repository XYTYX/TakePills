package com.example.aidan.takepills;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class displayAddAlertActivity extends Activity {

    private EditText name_entry;
    private EditText dosage_entry;
    private EditText dateend_entry;
    private CheckBox morning;
    private CheckBox noon;
    private CheckBox night;
    private Spinner dosage_spinner;
    private Button submit_check;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_add_alert);

        // Dosage spinner element
        dosage_spinner = (Spinner) findViewById(R.id.dosage_spinner);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Pills(s)");
        categories.add("Teaspoon(s)");
        categories.add("mL");
        categories.add("Shot(s)");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        dosage_spinner.setAdapter(dataAdapter);

        addListenerOnSpinnerItemSelection();
        //addListenerOnButton();

        name_entry = (EditText) findViewById(R.id.name_entry);
        dosage_entry = (EditText) findViewById(R.id.dosage_entry);
        dateend_entry = (EditText) findViewById(R.id.dateend_entry);
        morning = (CheckBox) findViewById(R.id.morning_check);
        noon = (CheckBox) findViewById(R.id.noon_check);
        night = (CheckBox) findViewById(R.id.night_check);

        findViewById(R.id.submit_check).setOnClickListener(new OnClickListener()

            @Override
            public void onClick(View arg0) {

                final String name = name_entry.getText().toString();
                if (name.isEmpty()) {
                    name_entry.setError("Please enter");
                }

                final String dosage = dosage_entry.getText().toString();
                else if (dosage.isEmpty()) {
                    dosage_entry.setError("Please enter");
                }

                final String dateend = dateend_entry.getText().toString();
                else if (dateend.isEmpty()) {
                    dateend_entry.setError("Please enter");
                }

                else if(!(morning.isChecked()) && !(noon.isChecked()) && !(night.isChecked())){
                    Toast.makeText(MainActivity.this,"Please select alert time",Toast.LENGTH_LONG).show();
                }

                else {

                Toast.makeText(MainActivity.this,"Entry Successful",Toast.LENGTH_LONG).show();
                }

            });

    public void addListenerOnSpinnerItemSelection(){

        dosage_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {

        dosage_spinner = (Spinner) findViewById(R.id.dosage_spinner);

        submit_check = (Button) findViewById(R.id.submit_check);

        submit_check.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(displayAddAlertActivity.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(dosage_spinner.getSelectedItem()),
                        Toast.LENGTH_LONG).show();
            }

        });
    }
}