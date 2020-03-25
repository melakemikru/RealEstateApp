package com.melake.realestateapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private ProgressBar progressBar;
    FirebaseAuth mAuth;
    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
      //  Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        mAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.name);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
        preferenceConfig=new SharedPreferenceConfig(getApplicationContext());

        if(preferenceConfig.readLoginStatus()){

            Intent intent = new Intent(MainActivity.this,Navigation2.class);
            startActivity(intent);
            finish();
        }

    }


    public void btnClick(View view) {
        String em=email.getText().toString();
        String pas=password.getText().toString();
        if(em.isEmpty() || pas.isEmpty()){
            email.setError("there is an empty field or ..");
            password.setError("password can't be empty");

        }

        else {

            registered();

        }

    }

    public void btnClick2(View view) {
        Intent intent = new Intent(this,RegsterActivity.class);
        startActivity(intent);
    }



    private void registered() {

        String userNam = email.getText().toString();
        String word=password.getText().toString();
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(MainActivity.this, "please wait a minute ......",Toast.LENGTH_LONG).show();
        mAuth.signInWithEmailAndPassword(userNam,word).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    progressBar.setVisibility(View.INVISIBLE);
                    //startActivity(new Intent(MainActivity.this, Navigation2.class));
                    Intent intent = new Intent(MainActivity.this,Navigation2.class);
                    startActivity(intent);
                    preferenceConfig.writeLoginStatus(true);
                    finish();

                } else {
                    // If sign in fails, display a message to the user.
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
