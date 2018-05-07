/*
.
.
.
Application by Pramukh Dayananda Bagur - K00405790

--In this application, the logic used is as ffollows :
--when any type of unit is selected to convert, it is converted to centimeters first
and centimeters is converted to the required distance format
--centimeters is chosen as the type to be converted because it is the smallest unit
-- The keyboard opens numberpad directly for ease of use.
-- All the RadioButtons are cleared
.
.
 */

package com.example.pramu.assignment2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup Rgroup1;
    RadioGroup Rgroup2;

    RadioButton inch1;
    RadioButton Foot1;
    RadioButton Yard1;
    RadioButton Centimeter1;
    RadioButton Meter1;
    RadioButton Kilometer1;
    RadioButton Mile1;
    RadioButton NauticalMile1;
    RadioButton inch2;
    RadioButton Foot2;
    RadioButton Yard2;
    RadioButton Centimeter2;
    RadioButton Meter2;
    RadioButton Kilometer2;
    RadioButton Mile2;
    RadioButton NauticalMile2;

    EditText Value;
    double Result, temp, finalResult;
    TextView ResultTextView, GithubTextView;
    Button Convert;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        Convert.setOnClickListener(this);
        GithubTextView.setOnClickListener(this);

        computeOnClick(Rgroup1);
    }

    protected void initComponents(){
        Rgroup1 = (RadioGroup) findViewById(R.id.RadioGroup1);
        Rgroup2 = (RadioGroup) findViewById(R.id.RadioGroup2);

        Convert = (Button) findViewById(R.id.CalculateButton);
        Value = (EditText) findViewById(R.id.EditTextValue);

        ResultTextView = (TextView) findViewById(R.id.TextviewResult);
        GithubTextView= (TextView) findViewById(R.id.TextViewGithub);

        inch1 = (RadioButton) findViewById(R.id.inch1);
        inch2 = (RadioButton) findViewById(R.id.inch2);

        Foot1 = (RadioButton) findViewById(R.id.foot1);
        Foot2 = (RadioButton) findViewById(R.id.foot2);

        Yard1 = (RadioButton) findViewById(R.id.yard1);
        Yard2 = (RadioButton) findViewById(R.id.yard2);

        Mile1 = (RadioButton) findViewById(R.id.mile1);
        Mile2 = (RadioButton) findViewById(R.id.mile2);

        Centimeter1 = (RadioButton) findViewById(R.id.centimeter1);
        Centimeter2 = (RadioButton) findViewById(R.id.centimeter2);

        Meter1 = (RadioButton) findViewById(R.id.meter1);
        Meter2 = (RadioButton) findViewById(R.id.mile2);

        Kilometer1 = (RadioButton) findViewById(R.id.Kilometer1);
        Kilometer2 = (RadioButton) findViewById(R.id.Kilometer2);

        NauticalMile1 = (RadioButton) findViewById(R.id.NauMile1);
        NauticalMile2 = (RadioButton) findViewById(R.id.NauMile2);
    }

    protected void computeOnClick(RadioGroup Rgroup){

        Rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                Result = Double.parseDouble(Value.getText().toString());
                temp = Result;

                if(checkedId == R.id.inch1)
                    temp = Result * 2.54;

                else if(checkedId == R.id.foot1)
                    temp = Result * 30.48;

                else if(checkedId == R.id.yard1)
                    temp = Result * 91.44;

                else if(checkedId == R.id.mile1)
                    temp = Result * 160934;

                else if (checkedId == R.id.centimeter1)
                    temp = Result;

                else if (checkedId == R.id.meter1)
                    temp = Result * 100;

                else if (checkedId == R.id.Kilometer1)
                    temp = Result * 100000;

                else if (checkedId == R.id.NauMile1)
                    temp = Result * 185200;

                else {
                    Toast.makeText(getApplicationContext(), "please select a unit", Toast.LENGTH_SHORT).show();
                    exit(0);
                }

                calculate(temp);
            }
        });

    }

    protected void calculate(double value){

        final double temp;
        temp = value;
        finalResult = 0;

        Rgroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                if(checkedId == R.id.inch2)
                    finalResult = temp * 0.393701;

                else if(checkedId == R.id.foot2)
                    finalResult = temp * 0.0328084;

                else if(checkedId == R.id.yard2)
                    finalResult = temp * 0.0109361;

                else if(checkedId == R.id.mile2)
                    finalResult = temp * 6.21371e-6;

                else if (checkedId == R.id.centimeter2)
                    finalResult = temp;

                else if (checkedId == R.id.meter2)
                    finalResult = temp * 0.01;

                else if (checkedId == R.id.Kilometer2)
                    finalResult = temp * 1e-5;

                else if (checkedId == R.id.NauMile2)
                    finalResult = temp * 0.00000539957;

                else {
                    Toast.makeText(getApplicationContext(), "please select a unit", Toast.LENGTH_SHORT).show();
                    exit(0);
                }
            }
        });
    }

    @Override
    public void onClick(View v){

        if(v.equals(Convert))
            ResultTextView.setText("" + finalResult);

        else if(v.equals(GithubTextView)){
            Uri uri = Uri.parse("https://github.com/Pugmark");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        return;
    }
}