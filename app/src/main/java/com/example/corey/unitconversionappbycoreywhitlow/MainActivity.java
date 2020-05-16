package com.example.corey.unitconversionappbycoreywhitlow;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    Spinner spinnerConversions;
    TextView conversionFrom, conversionTo, outputResult;
    EditText userInput;
    List<String> list = new ArrayList<>();
    Button clearButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversionFrom = findViewById(R.id.fromValue);
        conversionTo = findViewById(R.id.toValue);
        outputResult = findViewById(R.id.resultOutput);
        userInput = findViewById(R.id.numInput);
        spinnerConversions = findViewById(R.id.conversionSpinner);


        list.add("<Select Conversion Type>");
        list.add("Miles to Kilometers");
        list.add("Kilometers to Miles");
        list.add("Inches to Centimeters");
        list.add("Centimeters to Inches");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerConversions.setAdapter(adapter);


        spinnerConversions.setOnItemSelectedListener(this);

        clearButton = findViewById(R.id.resetButton);

        clearButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                setClearButton();
            }
        });




    }






    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Double d = 0.00;
        try {
            d = Double.parseDouble(userInput.getText().toString().trim());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }


        switch (pos) {
            case 0:
                outputResult.setText("0.00");
                conversionFrom.setText("Select Conversion Type");
                conversionTo.setText("Select Conversion Type");


                break;

            case 1:
                outputResult.setText(d * 1.6093+"");
                conversionFrom.setText("Miles");
                conversionTo.setText("Kilometers");

                break;

            case 2:
                outputResult.setText(d * 0.6214+"");
                conversionFrom.setText("Kilometers");
                conversionTo.setText("Miles");



                break;

            case 3:
                outputResult.setText(d * 2.54+"");
                conversionFrom.setText("Inches");
                conversionTo.setText("Centimeters");

                break;

            case 4:
                outputResult.setText(String.format("%s", d * 0.3937));
                conversionFrom.setText("Centimeters");
                conversionTo.setText("Inches");

                break;



        }


    }


    private void setClearButton(){
        spinnerConversions.setSelection(0);
        outputResult.setText("0.00");
        conversionFrom.setText("Select Conversion Type");
        conversionTo.setText("Select Conversion Type");
        userInput.setText("");
    }

    public void onNothingSelected(AdapterView<?> parent){}





}
