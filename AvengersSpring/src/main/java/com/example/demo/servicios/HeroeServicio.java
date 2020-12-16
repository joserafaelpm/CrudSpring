package com.example.demo.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Heroe;
import com.example.demo.modeloDao.IHeroe;
@Service
public class HeroeServicio implements IServicio<Heroe, Integer> {
	@Autowired
	IHeroe hDAO;
	
	
	@Override
	@Transactional(readOnly = true)
	public Heroe findById(Integer id) {
		return hDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Heroe> findAll() {
		return hDAO.findAll();
	}

	@Override
	@Transactional()
	public void save(Heroe t) {
		hDAO.save(t);	
	}

	@Override
	@Transactional()
	public void deleteById(Integer id) {
		hDAO.deleteById(id);
		
	}

}
