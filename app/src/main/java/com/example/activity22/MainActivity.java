package com.example.activity22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView salary;
    Button btnadd;
    ListView listView;
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.editTextTextPersonName);
        salary = (TextView) findViewById(R.id.editTextTextPersonName2);
        btnadd = findViewById(R.id.button);
        listView= findViewById(R.id.lst);


        String[] arraySpinner = new String[] {
                "Full time", "Part time"
        };
       s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }



    public void Save() {
        Employee[] Employees = new Employee[3];
        Employees[0] = new Employee( name.getText().toString(),salary.getText().toString(),s.getSelectedItem().toString());
        Employees[1] = new Employee( name.getText().toString(),salary.getText().toString(),s.getSelectedItem().toString());
        Employees[2] = new Employee( name.getText().toString(),salary.getText().toString(),s.getSelectedItem().toString());

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String EmployeesString = gson.toJson(Employees);

        editor.putString("123", EmployeesString);
        editor.commit();
        Toast.makeText(this,listView + EmployeesString,
                Toast.LENGTH_SHORT).show();

    }
    public void btnLoadOnClick() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("123", "");
        Employee[] Employees = gson.fromJson(str, Employee[].class);

        Toast.makeText(this, "number of Employees" + Employees.length
                , Toast.LENGTH_SHORT).show();
    }


}