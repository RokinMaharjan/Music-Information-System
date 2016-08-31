package com.majorprojectmodule.android.p2rsmusicstreamer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String PARAM_USERNAME ="username";
    private static final String PARAM_FIRSTNAME ="firstname";
    private static final String PARAM_LASTNAME ="lastname";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_DOB = "dob";
    private static final String PARAM_ADD = "address";
    private static final String PARAM_GENDER = "gender";

    EditText userName;

    EditText firstName;
    EditText lastName;

    EditText password;

    EditText address;

    EditText dob;

    RadioButton gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dob = (EditText) findViewById(R.id.dob);

        userName = (EditText) findViewById(R.id.username);

        firstName = (EditText) findViewById(R.id.first_name);

        lastName = (EditText) findViewById(R.id.last_name);

        password = (EditText) findViewById(R.id.password);

        address = (EditText) findViewById(R.id.address);

        gender = (RadioButton) findViewById(R.id.male);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new DatePickerFragment();

                newFragment.show(getSupportFragmentManager(),"datePicker");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int menuItem = item.getItemId();

        if(menuItem == R.id.submit){

            registerUser();

            Intent intentGetBack = new Intent(this,MainActivity.class);

            startActivity(intentGetBack);

        }

        return super.onOptionsItemSelected(item);
    }

    private void registerUser(){

        final String REG_URL = "http://192.168.100.6:8084/AdminApp/addUser";

        final String userNameValue = userName.getText().toString();

        final String firstNameValue = firstName.getText().toString();

        final String lastNameValue = lastName.getText().toString();

        final String passwordValue = password.getText().toString();

        final String dobVaue = dob.getText().toString();

        final String addressValue = address.getText().toString();

        String genderGET = "female";

        if(gender.isChecked()){

            genderGET = "male";
        }

        final String genderValue = genderGET;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REG_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.v("Login",response);

                SharedPreferences sharedPreferences = getSharedPreferences("USER",MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("userName",userNameValue);
                editor.commit();

                Toast.makeText(LoginActivity.this,"Created Account Successfully",Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.v("Login",error.getMessage());

                Toast.makeText(LoginActivity.this,"Account not Created",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put(PARAM_USERNAME, userNameValue);

                params.put(PARAM_FIRSTNAME,firstNameValue);

                params.put(PARAM_LASTNAME,lastNameValue);

                params.put(PARAM_PASSWORD,passwordValue);

                params.put(PARAM_DOB,dobVaue);

                params.put(PARAM_ADD,addressValue);

                params.put(PARAM_GENDER,genderValue);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }
}
