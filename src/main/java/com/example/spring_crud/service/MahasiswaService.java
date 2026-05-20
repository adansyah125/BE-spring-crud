package com.example.spring_crud.service;
import org.springframework.stereotype.Service;
import com.example.spring_crud.repository.MahasiswaRepository;
import com.example.spring_crud.model.Mahasiswa;

import java.util.List;
import java.util.Optional;
@Service
public class MahasiswaService {
    private final MahasiswaRepository mahasiswaRepository;

    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    // ambil semua data mahasiswa
    public List<Mahasiswa> getAllMahasiswa(){
        return mahasiswaRepository.findAll();
    }

    // tambah data mahasiswa
    public Mahasiswa save(Mahasiswa mahasiswa){
        return mahasiswaRepository.save(mahasiswa);
    }

    // detail data mahasiswa
    public Optional<Mahasiswa> getMahasiswaById(Long id){
        return mahasiswaRepository.findById(id);
    }

    // update data mahasiswa
    public Mahasiswa update(Long id, Mahasiswa dataBaru){
        Mahasiswa mahasiswa = mahasiswaRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        mahasiswa.setNim(dataBaru.getNim());
        mahasiswa.setNama(dataBaru.getNama());
        return mahasiswaRepository.save(mahasiswa);
    }

    // hapus data mahasiswa
    public void delete(Long id){
        mahasiswaRepository.deleteById(id);
    }

    public Object getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
}
