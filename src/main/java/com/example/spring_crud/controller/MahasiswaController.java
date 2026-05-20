package com.example.spring_crud.controller;

import com.example.spring_crud.service.MahasiswaService;
import com.example.spring_crud.model.Mahasiswa;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
@CrossOrigin(origins = "http://localhost:5173")
public class MahasiswaController {
    private final MahasiswaService mahasiswaService;

    public MahasiswaController(MahasiswaService mahasiswaService){
        this.mahasiswaService = mahasiswaService;
    }

    // get semua data
    @GetMapping
    public List<Mahasiswa> getAllMahasiswa(){
        return mahasiswaService.getAllMahasiswa();
    }

    @PostMapping
    public Mahasiswa create(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaService.save(mahasiswa);
    }

    // GET detail data
    @GetMapping("/{id}")
    public Mahasiswa getById(@PathVariable Long id) {
        return mahasiswaService.getMahasiswaById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
    }

    // PUT update data
    @PutMapping("/{id}")
    public Mahasiswa update(
            @PathVariable Long id,
            @RequestBody Mahasiswa mahasiswa
    ) {
        return mahasiswaService.update(id, mahasiswa);
    }

    // DELETE data
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        mahasiswaService.delete(id);
        return "Data berhasil dihapus";
    }

}
