package uph.edu.m23si1.aplikasikedua.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mahasiswa extends RealmObject {
    @PrimaryKey
    private int idMahasiswa;
    private String nama, jenisKelamin, prodi, hobi;
    private int nilaiBisnis, nilaiMobile;

    public Mahasiswa(){}


    public Mahasiswa(int idMahasiswa, String nama, String jenisKelamin, String prodi, String hobi, int nilaiBisnis, int nilaiMobile) {
        this.idMahasiswa = idMahasiswa;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.prodi = prodi;
        this.hobi = hobi;
        this.nilaiBisnis = nilaiBisnis;
        this.nilaiMobile = nilaiMobile;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public int getNilaiBisnis() {
        return nilaiBisnis;
    }

    public void setNilaiBisnis(int nilaiBisnis) {
        this.nilaiBisnis = nilaiBisnis;
    }

    public int getNilaiMobile() {
        return nilaiMobile;
    }

    public void setNilaiMobile(int nilaiMobile) {
        this.nilaiMobile = nilaiMobile;
    }


    @Override
    public String toString() {
        return "Mahasiswa{" +
                "idMahasiswa=" + idMahasiswa +
                ", nama='" + nama + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", prodi='" + prodi + '\'' +
                ", hobi='" + hobi + '\'' +
                ", nilaiBisnis=" + nilaiBisnis +
                ", nilaiMobile=" + nilaiMobile +
                '}';
    }
}
