package com.example.spring_crud.repository;
import com.example.spring_crud.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

     
}
