package com.dut2.colormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EmptyStackException;

public class Connexion extends AppCompatActivity {

    private EditText mEditTextMail;
    private EditText mEditTextPassword;
    private Button mValidButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        mEditTextMail = findViewById(R.id.etm_mail);
        mEditTextMail = findViewById(R.id.etp_password);
        mValidButton = findViewById(R.id.btn_valid);

        mValidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(VConnexion()) {
                    Intent intent = new Intent(Connexion.this, GameMenu.class);
                    Bundle bundle = new Bundle();
                    String[] user = new String[4];
                    String name = ""; String firstName= ""; String mail= ""; String password= "";
                    user[0] = name; user[1] = firstName; user[2] = mail; user[3] = password;
                    bundle.putStringArray("user", user);
                    startActivityForResult(intent, 3000);
                }
            }
        });
    }

    private boolean VConnexion() {
        boolean isValid = true;

        //Vérification de l'existance de l'utilisateur dans la base de données

        return isValid;
    }
}