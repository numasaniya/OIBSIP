package com.example.unitconverter2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.unitconverter2.R;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Spinner unit;
    private TextView km, m, cm, mm, microm, nm, mile, yard, foot, inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        microm = findViewById(R.id.microm);
        nm = findViewById(R.id.nm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        double km_in = 1.0;

        // Set up the spinner with unit options
        String[] units = {"km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit.setAdapter(adapter);

1        // Set listeners for spinner selection and text changes
        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }
        });
    }

    private void update() {
        // Ensure input is not empty and a unit is selected
        if (!input.getText().toString().isEmpty() && unit.getSelectedItem() != null) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "km":
                    setKm(in);
                    break;
                case "m":
                    setKm(in / 1000);
                    break;
                case "cm":
                    setKm(in / 100000);
                    break;
                case "mm":
                    setKm(in / 1000000);
                    break;
                case "microm":
                    setKm(in / 1000000000);
                    break;
                case "nm":
                    double d = 1000000 * 1000000;
                    setKm(in / d);
                    break;
                case "mile":
                    setKm(in * 1.609);
                    break;
                case "yard":
                    setKm(in / 1094);
                    break;
                case "foot":
                    setKm(in / 3281);
                    break;
                case "inch":
                    setKm(in / 39370);
                    break;
                default:
                    break;
            }
        }
    }

    private void setKm(double km_in) {
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in * 1000));
        cm.setText(String.valueOf(km_in * 100000));
        mm.setText(String.valueOf(km_in * 1000000));
        microm.setText(String.valueOf(km_in * 1000000000));
        nm.setText(String.valueOf(km_in * 1000000 * 1000000));
        mile.setText(String.valueOf(km_in / 1.609));
        yard.setText(String.valueOf(km_in * 1094));
        foot.setText(String.valueOf(km_in * 3281));
        inch.setText(String.valueOf(km_in * 39370));
    }
}

