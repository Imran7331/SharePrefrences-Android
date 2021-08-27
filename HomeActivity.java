package com.example.sharedprefrences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView editText_firstName, editText_lastName, editText_email, editText_phone, editText_address;
    Button button_save;
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
        setContentView(R.layout.activity_home);

        editText_firstName = findViewById(R.id.fname);
        editText_lastName = findViewById(R.id.lname);
        editText_email    = findViewById(R.id.email);
        editText_phone    = findViewById(R.id.phone);
        editText_address  = findViewById(R.id.address);

        button_save       = findViewById(R.id.savebtn);

        sharedPreferences = getSharedPreferences(SHARED_PREF_Name,MODE_PRIVATE);
        String fname = sharedPreferences.getString(KEY_FIRSTNAME,null);
        String lname = sharedPreferences.getString(KEY_LASTNAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        String phone = sharedPreferences.getString(KEY_PHONE,null);
        String address = sharedPreferences.getString(KEY_ADDRESS,null);

        if (fname != null || lname != null || email != null || phone != null || address != null){
            editText_firstName.setText("First Name:"+ fname);
            editText_lastName.setText("Last Name"+lname);
            editText_email.setText("Email"+email);
            editText_phone.setText("Phone number" +phone);
            editText_address.setText("Address"+address);
        }
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(HomeActivity.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

