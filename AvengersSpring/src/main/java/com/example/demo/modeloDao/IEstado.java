package com.example.demo.modeloDao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Estado;

public interface IEstado extends JpaRepository<Estado, String>  {

}
