package info.devexchanges.disabledviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import info.devexchanges.disabledviewpager.pojo.User;

public class ResultActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView age;
    private TextView gender;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        age = (TextView) findViewById(R.id.age);
        gender = (TextView) findViewById(R.id.gender);

        //get Data from Intent
        user = (User) getIntent().getExtras().getSerializable("USER INFO");
    }

    @Override
    protected void onStart() {
        super.onStart();

        //set data to View
        name.setText(user.getName());
        email.setText(user.getEmail());
        age.setText("" + user.getAge());
        gender.setText(user.getGender());
    }
}
