package com.parneet.guraya.cookingtime;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.parneet.guraya.cookingtime.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
private String fromUnit;
private String toUnit;
    private static final String TO_UNITVALUEKEY ="com.parneet.guraya.cookingtime.TO_UNITVALUEKEY";
private static final String FROM_UNITVALUEKEY ="com.parneet.guraya.cookingtime.FROM_UNITVALUEKEY";
private static final String RESULT_VALUEKEY ="com.parneet.guraya.cookingtime.RESULT_VALUEKEY";
private String[] unitArr;

private String resultValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        if(savedInstanceState != null){
           fromUnit =  savedInstanceState.getString(FROM_UNITVALUEKEY);
           toUnit =  savedInstanceState.getString(TO_UNITVALUEKEY);
            resultValue = savedInstanceState.getString(RESULT_VALUEKEY);
        }

        setView();

        unitArr = getResources().getStringArray(R.array.cooking_units);

        ArrayAdapter<String> Unit1 = new ArrayAdapter<>(this,R.layout.drop_down_unit_item,unitArr);

        ArrayAdapter<String> Unit2 = new ArrayAdapter<>(this,R.layout.drop_down_unit_item,unitArr);

        mainBinding.unitMenu1.setAdapter(Unit1);
        mainBinding.unitMenu2.setAdapter(Unit1);


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
                        getResult(enterText);
                    }
                }
            }
        });

    }

    private void getResult(double enterText){
        this.resultValue = new UnitConverter(fromUnit,toUnit,enterText).convertUnit();
        setView();
    }

    private void setView(){
        if(resultValue!=null){
            mainBinding.resultView.setText(resultValue);
        }
        else {
            mainBinding.resultView.setText("0.00");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FROM_UNITVALUEKEY,fromUnit);
        outState.putString(TO_UNITVALUEKEY,toUnit);
        outState.putString(RESULT_VALUEKEY,resultValue);
    }
}