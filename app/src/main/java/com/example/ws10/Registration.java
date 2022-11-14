package com.example.ws10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;


public class Registration extends AppCompatActivity {
    private EditText email;
    private EditText username;
    private EditText phone;
    private EditText gender;
    private EditText dateofbirth;
    private ImageButton save;

    int numberOfRemainingLoginAttempts = 3;
    boolean isAllFieldsChecked = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        save = (ImageButton) findViewById(R.id.save);
        email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.username);
        phone=(EditText)findViewById(R.id.phone);
        gender=(EditText)findViewById(R.id.gender);
        dateofbirth=(EditText)findViewById(R.id.date);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    if (email.getText().toString().equals("") || username.getText().toString().equals("") || phone.getText().toString().equals("") || gender.getText().toString().equals("") || dateofbirth.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Поля не заполнены", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registration.this, Logo.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }


    private boolean CheckAllFields() {
        if (username.length() == 0 ) {
            username.setError( "Введите имя" );
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false ;
        }
        if (email.length() == 0 ) {
            email.setError( "Введите фамилию" );
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false ;
        }
        if (phone.length() == 0 ) {
            phone.setError( "Введите E-mail" );
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false ;
        }
        if (gender.length() == 0 ) {
            gender.setError( "Пароль" );
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false ;
        }
        if (dateofbirth.length() == 0 ) {
            dateofbirth.setError( "Повторите пароль" );
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false ;
        }
        return true ;
    }


    public void logo(View view) {
        Intent i;
        i=new Intent(Registration.this, Logo.class);
        startActivity(i);
    }

}