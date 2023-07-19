package com.example.converter_temperature;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spn1 = findViewById(R.id.spn1);
        Spinner spn = findViewById(R.id.spn);
        EditText edit = findViewById(R.id.edit);
        TextView edit1 = findViewById(R.id.edit1);
        Button btn = findViewById(R.id.btn);

        ArrayList<String> my = new ArrayList<String>();
        my.add("Celsius");
        my.add("Fahrenheit");
        my.add("Kelvin");

        ArrayAdapter<String> you = new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,my);
        you.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(you);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> my1 = new ArrayList<String>();
        my1.add("Celsius");
        my1.add("Fahrenheit");
        my1.add("Kelvin");

        ArrayAdapter<String> you1 = new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,my1);
        you1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn1.setAdapter(you1);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                Double aDouble = Double.parseDouble(s);
                if(spn.getSelectedItem().toString()=="Celsius" && spn1.getSelectedItem().toString()=="Kelvin") {
                    Double k = aDouble+273;
                    edit1.setText(Double.toString(k));
                }
                else if(spn.getSelectedItem().toString()=="Celsius" && spn1.getSelectedItem().toString()=="Celsius") {
                    edit1.setText(Double.toString(aDouble));
                }
                else if(spn.getSelectedItem().toString()=="Celsius" && spn1.getSelectedItem().toString()=="Fahrenheit") {
                    Double f = (aDouble*9/5)+32;
                    edit1.setText(Double.toString(f));
                }
                else if(spn.getSelectedItem().toString()=="Kelvin" && spn1.getSelectedItem().toString()=="Celsius") {
                    Double k = aDouble-273;
                    edit1.setText(Double.toString(k));
                }
                else if(spn.getSelectedItem().toString()=="Kelvin" && spn1.getSelectedItem().toString()=="Fahrenheit") {
                    Double f = ((aDouble-274)*9/5)+32;
                    edit1.setText(Double.toString(f));
                }
                else if(spn.getSelectedItem().toString()=="Kelvin" && spn1.getSelectedItem().toString()=="Kelvin") {
                    edit1.setText(Double.toString(aDouble));
                }
                else if(spn.getSelectedItem().toString()=="Fahrenheit" && spn1.getSelectedItem().toString()=="Celsius") {
                    Double c = (aDouble-32)*5/9;
                    edit1.setText(Double.toString(c));
                }
                else if(spn.getSelectedItem().toString()=="Fahrenheit" && spn1.getSelectedItem().toString()=="Fahrenheit") {
                    edit1.setText(Double.toString(aDouble));
                }
                else if(spn.getSelectedItem().toString()=="Fahrenheit" && spn1.getSelectedItem().toString()=="Kelvin") {
                    Double c = ((aDouble-32)*5/9)+273;
                    edit1.setText(Double.toString(c));
                }
            }
        });
    }
}