package uph.edu.m23si1.aplikasikedua.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import java.util.ArrayList;

import uph.edu.m23si1.aplikasikedua.ProfileActivity;
import uph.edu.m23si1.aplikasikedua.R;
import uph.edu.m23si1.aplikasikedua.model.Mahasiswa;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {
    public MahasiswaAdapter(@NonNull Context context, ArrayList<Mahasiswa> arrayList) {
        super(context, 0, arrayList);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.mahasiswa_layout, parent, false);
        }

        Mahasiswa currentNumberPosition = getItem(position);

        ImageView numbersImage = currentItemView.findViewById(R.id.imvMahasiswa);
        if (currentNumberPosition.getJenisKelamin().equals("Perempuan")){
            numbersImage.setImageResource(R.drawable.user3);
        }
        else {
            numbersImage.setImageResource(R.drawable.user2);
        }
        assert currentNumberPosition != null;

        TextView textView1 = currentItemView.findViewById(R.id.txvNama);
        textView1.setText(currentNumberPosition.getNama());

        TextView textView2 = currentItemView.findViewById(R.id.txvProdi);
        textView2.setText(currentNumberPosition.getProdi());

        LinearLayout llyItemMahasiswa = currentItemView.findViewById(R.id.llyItemMahasiswa);
        llyItemMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("nama", currentNumberPosition.getNama());
                getContext().startActivity(intent);
            }
        });

        return currentItemView;
    }

}
