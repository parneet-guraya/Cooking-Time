package com.parneet.guraya.cookingtime;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.parneet.guraya.cookingtime.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
private String fromUnit;
private String toUnit;
private final String LOGKEY ="MYCUSTOMTAGGURAYA";
private String[] unitArr;

private double resultValue = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        unitArr = getResources().getStringArray(R.array.cooking_units);

        ArrayAdapter<String> Unit1 = new ArrayAdapter<>(this,R.layout.drop_down_unit_item,unitArr);

        ArrayAdapter<String> Unit2 = new ArrayAdapter<>(this,R.layout.drop_down_unit_item,unitArr);

        mainBinding.unitMenu1.setAdapter(Unit1);
        mainBinding.unitMenu2.setAdapter(Unit2);


        mainBinding.unitMenu1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition(position);
                    fromUnit = (String) obj;
            }
        });

        mainBinding.unitMenu2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition(position);
                toUnit = (String) obj;
            }
        });


        mainBinding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable editable = mainBinding.unitValue.getText();
                if(editable!=null){
                    if(!(editable.toString().equals(""))){
                        double enterText = Double.parseDouble(editable.toString());
                       resultValue =  new UnitConverter(fromUnit,toUnit,enterText).convertUnit();
                        Log.d(LOGKEY,String.valueOf(resultValue));
                    }
                }
            }
        });

    }



}