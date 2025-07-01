package uph.edu.m23si1.aplikasikedua;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.realm.Realm;
import uph.edu.m23si1.aplikasikedua.model.Mahasiswa;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout llyProfil, llyListMahasiswa;
    TextView txvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        llyProfil = findViewById(R.id.llyProfil);
        llyProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProfil();
            }
        });

        llyListMahasiswa = findViewById(R.id.llyListMahasiswa);
        llyListMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toListMahasiswa();
            }
        });

        txvHasil = findViewById(R.id.txvHasil);
        Realm realm = Realm.getDefaultInstance();
        Mahasiswa mhs = realm.where(Mahasiswa.class).findFirst();
        if (mhs != null) {
            txvHasil.setText(mhs.toString());
        }
    }

    public void toProfil(){
        String nama = getIntent().getStringExtra("nama");
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("nama",nama);
        startActivity(intent);
    }

    public void toListMahasiswa(){
        Intent intent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(intent);
    }
}