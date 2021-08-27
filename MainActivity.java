package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_firstName, editText_lastName, editText_email, editText_phone, editText_address;
    Button button_save, button_update, button_show;
    SharedPreferences sharedPreferences;

    //Shared Preference name and key value
    private static final String SHARED_PREF_Name = "mypref";
    private static final String KEY_FIRSTNAME    = "firstname";
    private static final String KEY_LASTNAME    = "lastname";
    private static final String KEY_EMAIL       = "email";
    private static final String KEY_PHONE       = "phone";
    private static final String KEY_ADDRESS     = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_main);
        editText_firstName = findViewById(R.id.fname);
        editText_lastName = findViewById(R.id.lname);
        editText_email    = findViewById(R.id.email);
        editText_phone    = findViewById(R.id.phone);
        editText_address  = findViewById(R.id.address);

        button_save       = findViewById(R.id.savebtn);
        button_update     = findViewById(R.id.update);
        button_show       = findViewById(R.id.show);

        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREF_Name, MODE_PRIVATE);
        //when open activity first check sharedpreferneces data available or not
        String name = sharedPreferences.getString(KEY_FIRSTNAME,null);
//        if (name != null){
//            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//            startActivity(intent);
//
//        }


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_FIRSTNAME,editText_firstName.getText().toString());
                editor.putString(KEY_LASTNAME,editText_lastName.getText().toString());
                editor.putString(KEY_EMAIL,editText_email.getText().toString());
                editor.putString(KEY_PHONE,editText_phone.getText().toString());
                editor.putString(KEY_ADDRESS,editText_address.getText().toString());
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Save Data",Toast.LENGTH_SHORT).show();
            }
        });
    }
}