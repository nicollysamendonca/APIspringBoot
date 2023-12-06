package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    List<Curriculo> findByEmail(String email);
    
}

