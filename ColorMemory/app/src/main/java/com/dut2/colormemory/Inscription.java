package com.dut2.colormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Inscription extends AppCompatActivity {

    private EditText mEditTextFirstName;
    private EditText mEditTextName;
    private EditText mEditTextMail;
    private EditText mEditTextPassword;
    private TextView mTextViewFirstName;
    private TextView mTextViewName;
    private TextView mTextViewMail;
    private TextView mTextViewPassword;
    private Button mValidButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        mEditTextFirstName = findViewById(R.id.et_firstName);
        mEditTextName = findViewById(R.id.et_name);
        mEditTextMail = findViewById(R.id.etm_mail_inscription);
        mEditTextPassword = findViewById(R.id.etp_password_inscription);
        mTextViewFirstName = findViewById(R.id.tv_error_firstName);
        mTextViewName = findViewById(R.id.tv_error_name);
        mTextViewMail = findViewById(R.id.tv_error_mail);
        mTextViewPassword = findViewById(R.id.tv_error_password);
        mValidButton = findViewById(R.id.btn_valid_inscription);

        mValidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vérification de la validité des champs
                boolean isValid = false;
                for(int i = 0; i < 4; i++) {
                    if (VInscription(mEditTextFirstName, mEditTextName, mEditTextMail, mEditTextPassword)[i] == "") {
                        isValid = true;
                    }
                }
                //Traitement des données valides : création d'un utilisateur et ajout de ses informations dans la base de données
                if(isValid){
                    User newUser = new User(mEditTextFirstName.toString(), mEditTextName.toString(), mEditTextMail.toString(), mEditTextPassword.toString());
                    newUser.addDataBase();
                    //Ajout d'un nouvel utilisateur dans la base de données
                    Intent intent = new Intent(Inscription.this, Connexion.class);
                    startActivityForResult(intent, 3000);
                } else {
                    //Affichage des messages d'erreurs
                    mTextViewFirstName.setText(VInscription(mEditTextFirstName, mEditTextName, mEditTextMail, mEditTextPassword)[0]);
                    mTextViewName.setText(VInscription(mEditTextFirstName, mEditTextName, mEditTextMail, mEditTextPassword)[1]);
                    mTextViewMail.setText(VInscription(mEditTextFirstName, mEditTextName, mEditTextMail, mEditTextPassword)[2]);
                    mTextViewPassword.setText(VInscription(mEditTextFirstName, mEditTextName, mEditTextMail, mEditTextPassword)[3]);
                }
            }
        });
    }

    private String[] VInscription(EditText firstName, EditText name, EditText mail, EditText password) {
        String[] errors = new String[4];

        for(int i = 0; i < 4; i++){
            errors[i] = "";
        }

        if(!(firstName.length() > 2 && firstName.length() < 16)){
            errors[0] = "Veuillez entrer un prénom valide (entre 2 et 16 caractères)";
        }
        if(!(name.length() > 2 && name.length() < 16)){
            errors[1] = "Veuillez entrer un nom valide (entre 2 et 16 caractères)";
        }
        if(!(mail.toString().contains("@"))){
            errors[2] = "Veuillez entrer un mail valide";
        } else if(mail.toString() == "") { //Email déjà existante ds la base de données
            errors[2] = "L'adresse e-mail est déjà prise";
        }
        if(!(password.length() > 3 && password.length() < 24)){
            errors[3] = "Veuillez entrer un mot de passe valide (entre 3 et 24 caractères)";
        }

        return errors;
    }
}