package com.example.demo.modeloDao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Heroe;

public interface IHeroe extends JpaRepository<Heroe, Integer>  {

}
