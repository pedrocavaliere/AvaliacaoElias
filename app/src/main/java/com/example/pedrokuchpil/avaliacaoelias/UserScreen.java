package com.example.pedrokuchpil.avaliacaoelias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserScreen extends AppCompatActivity {
    private TextView name, email, adress, phone;
    private Button adicionar;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myref = database.getReference("Usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        name = (TextView) findViewById(R.id.nomeUserScreen);
        email = (TextView) findViewById(R.id.emailUserScreen);
        adress = (TextView) findViewById(R.id.enderecoUserScreen);
        phone = (TextView) findViewById(R.id.telefoneUserScreen);
        adicionar = (Button) findViewById(R.id.addButton);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserScreen.this, MainActivity.class));
                retorna();
            }
        });
    }

    private void retorna(){
        addUser(name.getText().toString(),  adress.getText().toString(), phone.getText().toString(), email.getText().toString());
    }
    private void addUser(String name,
                         String adress,
                         String phone,
                         String email){
        User user = new User(name, adress, phone, email);
        myref.child(user.getUserEmail()).setValue(user);
    }
}
