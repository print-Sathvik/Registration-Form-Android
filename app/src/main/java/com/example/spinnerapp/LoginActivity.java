package com.example.spinnerapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
    EditText t1,t2;
    Button b;
    String userid,passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        t1=findViewById(R.id.userId);
        t2=findViewById(R.id.password);
        b=findViewById(R.id.loginButton);
    }

    public void clickSubmit(View v)
    {
        userid=t1.getText().toString();
        passwd=t2.getText().toString();
        if(userid.equals("cbit") && passwd.equals("123"))
        {
            Toast.makeText(getApplicationContext(),"Login Successfull User ID:"+userid+" Password "
                    +passwd,Toast.LENGTH_SHORT).show();
            Log.d("Login","Login Successfull User ID "+userid+"Passwrd "+passwd);
            Intent i=new Intent(LoginActivity.this,HomeActivity.class);
            i.putExtra("userid",userid);
            i.putExtra("passwd",passwd);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Login Not Successfull "+userid + passwd,Toast.LENGTH_SHORT).show();
        }

    }

    public void openForgot(View v)
    {
        Intent i=new Intent(LoginActivity.this,ForgotActivity.class);
        i.putExtra("userid",userid);
        i.putExtra("passwd",passwd);
        startActivity(i);
    }

    public void openFacebook(View v)
    {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com"));
        startActivity(i);
    }

    public void openGoogle(View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
        startActivity(i);
    }

}
