package api.prueba2.modusoftware.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.prueba2.modusoftware.models.dao.IArrayDao;
import api.prueba2.modusoftware.models.entities.Array;

@Service
public class ArrayServiceImp implements IArrayService{
	
	@Autowired private IArrayDao arrayDao;

	@Override
	@Transactional(readOnly=true)
	public Array findById(Long id) {
		return  arrayDao.findById(id).orElse(null);
		
	}

}
