package com.example.demo.modeloDao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Clasificacion;

public interface IClasificacion extends JpaRepository<Clasificacion, String>  {

}
