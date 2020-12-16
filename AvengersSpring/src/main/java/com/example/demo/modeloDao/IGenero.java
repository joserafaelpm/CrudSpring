package com.example.demo.modeloDao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Genero;

public interface IGenero extends JpaRepository<Genero, String>  {

}
