package com.example.icoders;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;

    LinearLayout bt;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ed1 = findViewById(R.id.Name);
        ed2 = findViewById(R.id.Email);
        ed3 = findViewById(R.id.Rollno);
        ed4 = findViewById(R.id.Phoneno);
        ed5 = findViewById(R.id.Yp);
        ed6 = findViewById(R.id.Department);
        bt = findViewById(R.id.sbt);
        progressDialog = new ProgressDialog(signup.this);
        progressDialog.setMessage("Loading...");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentData();
                progressDialog.show();

            }
        });

    }
    public void addStudentData(){
        String Sname = ed1.getText().toString();
        String Semail = ed1.getText().toString();
        String Srollno = ed1.getText().toString();
        String Sphoneno = ed1.getText().toString();
        String Syp = ed1.getText().toString();
        String Sdepartment = ed1.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbzfMAnmrG1QmxBJiVJ5QeXeYj6ZyfX_dRzTAsxT5rHvc5jD_xy86ckCIGoStwk8oJyp/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(signup.this, response, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signup.this,Login.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(signup.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams(){
                Map<String,String>params = new HashMap<>();
                params.put("action","addStudent");
                params.put("stdname",Sname);
                params.put("stdemail",Semail);
                params.put("stdrollno",Srollno);
                params.put("stdphoneno",Sphoneno);
                params.put("stdyp",Syp);
                params.put("stddepartment",Sdepartment);
                return params;

            }
        };
        int socketTimeout = 5000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}