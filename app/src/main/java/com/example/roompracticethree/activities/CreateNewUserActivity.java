package com.example.roompracticethree.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roompracticethree.R;
import com.example.roompracticethree.activities.database.UserDatabase;
import com.example.roompracticethree.activities.entities.User;

public class CreateNewUserActivity extends AppCompatActivity {
    private EditText userFirstName, userLastName, userAge;
    private Button saveUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
        userFirstName = findViewById(R.id.userFirstName);
        userLastName = findViewById(R.id.userLastName);
        userAge = findViewById(R.id.userAge);
        saveUser = findViewById(R.id.saveNewUser);

        saveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(userFirstName.getText().toString(), userLastName.getText().toString(), userAge.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String lastName, String age) {
        UserDatabase db = UserDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserAge(Integer.parseInt(String.valueOf(age)));
        db.userDao().insertUser(user);

        finish();


    }

}

