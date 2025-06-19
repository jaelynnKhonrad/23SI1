package uph.edu.m23si1.aplikasikedua;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText edtName;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // inisialisasi
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

//        ketika dijalankan, bakal kosong...karna cuman di onCreate aja pada saat itu
//        editor.putString(getString(R.string.username_key), edtName.getText().toString());
//        editor.apply();


        edtName = findViewById(R.id.edtName);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast toast = Toast.makeText(getApplicationContext(), "Tombol Register ditekan", Toast.LENGTH_LONG);
                //toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0,0);
                //toast.show();
                toDashboard();
            }
        });
    }

    public void toProfil(){
        String nama = edtName.getText().toString();
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("nama",nama);
        startActivity(intent);

    }

    public void toDashboard(){
        String nama = edtName.getText().toString();
        editor.putString(getString(R.string.username_key), nama);
        editor.apply();

        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtra("nama",nama);
        startActivity(intent);

    }
}