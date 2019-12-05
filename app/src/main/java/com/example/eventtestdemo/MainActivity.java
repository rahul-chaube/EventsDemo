package com.example.eventtestdemo;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextServerName,editTextMobileNumber;
    Button buttonSubmit;

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextServerName= (EditText) findViewById(R.id.editTextServerName);
        editTextMobileNumber= (EditText) findViewById(R.id.editTextPort);
        buttonSubmit= (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextServerName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Server Name ", Toast.LENGTH_SHORT).show();
                }else
                if (editTextMobileNumber.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Port Number ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    PrefManager prefManager=new PrefManager(MainActivity.this);
                    prefManager.setMobileNumber(editTextMobileNumber.getText().toString().trim());
                    prefManager.setServerName(editTextServerName.getText().toString().trim());
                    startActivity(new Intent(MainActivity.this,OperationActivity.class));
                }
            }
        });
    }
}
