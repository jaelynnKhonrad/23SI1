package uph.edu.m23si1.aplikasikedua;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import uph.edu.m23si1.aplikasikedua.adapter.MahasiswaAdapter;
import uph.edu.m23si1.aplikasikedua.model.Mahasiswa;

public class ListMahasiswaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_mahasiswa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Realm realm = Realm.getDefaultInstance();

        final ArrayList<Mahasiswa> arrayList = new ArrayList<>();
        RealmResults<Mahasiswa> results = realm.where(Mahasiswa.class).findAll();
        if (results != null) {
            arrayList.addAll(realm.copyFromRealm(results));
        }

        MahasiswaAdapter numbersArrayAdapter = new MahasiswaAdapter(this, arrayList);
        ListView numberListView = findViewById(R.id.lsvMahasiswa);
        numberListView.setAdapter(numbersArrayAdapter);
    }
}