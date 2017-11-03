package com.example.pedrokuchpil.avaliacaoelias;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.pedrokuchpil.avaliacaoelias.R.id.adress_recyclerUser;
import static com.example.pedrokuchpil.avaliacaoelias.R.id.inputEmail;

public class SignupActivity extends AppCompatActivity {

    EditText emailSignup, senhaSignup, nomeSignup, enderecoSignup, telefoneSignup;
    Button criarConta;
    User user;

    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Usuario");

    protected void setUpUser(){
        user = new User();
        user.setUserName(nomeSignup.getText().toString());
        user.setUserEmail(emailSignup.getText().toString());
        user.setUserAdress(enderecoSignup.getText().toString());
        user.setUserPhone(telefoneSignup.getText().toString());
    }
    private void createNewAccount(String email, String password){
        if(!validateForm()){
            return;
        }
        setUpUser(); //create user.Name and user.Email
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Auth Failed. Maybe you're already registered.", Toast.LENGTH_SHORT).show();
                        }else{
                            onAuthenticationSuccess(task.getResult().getUser());
                        }
                    }
                });
    }

    private void onAuthenticationSuccess(FirebaseUser myUser){
        saveNewUser(myUser.getUid(), user.getUserName(), user.getUserEmail(), user.getUserAdress(), user.getUserPhone());

        startActivity(new Intent(SignupActivity.this, MainActivity.class));
        finish();
    }

    private void saveNewUser(String userId, String name, String email, String adress , String phone) {
        User user = new User(userId, name, email, adress, phone);

        myRef.child(userId).child("userAdress").setValue(user.getUserAdress());
        myRef.child(userId).child("userEmail").setValue(user.getUserEmail());
        myRef.child(userId).child("userName").setValue(user.getUserName());
        myRef.child(userId).child("userPhone").setValue(user.getUserPhone());

    }

    private boolean validateForm() {
        boolean valid = true;

        String userEmail = emailSignup.getText().toString();
        if(TextUtils.isEmpty(userEmail)){
            emailSignup.setError("Required");
            valid = false;
        }else if(!isValidEmail(userEmail)){
            emailSignup.setError("E-mail invalido");
            valid = false;
        }else{
            emailSignup.setError(null);
        }

        String userName = nomeSignup.getText().toString();
        if(TextUtils.isEmpty(userName)){
            nomeSignup.setError("Required");
            valid = false;
        }else{
            nomeSignup.setError(null);
        }

        String userPassword = senhaSignup.getText().toString();
        if(TextUtils.isEmpty(userPassword)) {
            senhaSignup.setError("Required");
            valid = false;
        }else if(userPassword.length() < 6){
            senhaSignup.setError("Senha muito curta");
            valid = false;
        }else{
            senhaSignup.setError(null);
        }

        String userAdress = enderecoSignup.getText().toString();
        if(TextUtils.isEmpty(userAdress)){
            enderecoSignup.setError("Required");
            valid = false;
        }else{
            enderecoSignup.setError(null);
        }

        String userPhone = telefoneSignup.getText().toString();
        if(TextUtils.isEmpty(userPhone)){
            telefoneSignup.setError("Required");
            valid = false;
        }else{
            telefoneSignup.setError(null);
        }

        return valid;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        emailSignup = (EditText) findViewById(R.id.emailSignup);
        senhaSignup = (EditText) findViewById(R.id.senhaSignup);
        nomeSignup = (EditText) findViewById(R.id.nomeSignup);
        enderecoSignup = (EditText) findViewById(R.id.enderecoSignup);
        telefoneSignup = (EditText) findViewById(R.id.telefoneSignup);

        criarConta = (Button) findViewById(R.id.buttonCriarSignup);

        criarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNewAccount(emailSignup.getText().toString(), senhaSignup.getText().toString());
            }
        });


    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
