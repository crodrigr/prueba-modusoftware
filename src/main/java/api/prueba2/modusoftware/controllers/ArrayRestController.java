package api.prueba2.modusoftware.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.prueba2.modusoftware.models.entities.Array;
import api.prueba2.modusoftware.models.services.IArrayService;




@RestController
@RequestMapping("/api")
public class ArrayRestController {

	@Autowired
	private IArrayService arrayService;
	
	@GetMapping("/array/{id}")
	public Array show(@PathVariable Long id){
		return arrayService.findById(id);
	}
	
	@GetMapping("/resultado/{id}/{interaciones}")
	public ArrayList<Integer> getVasos(@PathVariable Long id, @PathVariable int interaciones){
		
	     Array lista=arrayService.findById(id);
	     return getResultado(lista.getListA(),interaciones);
		
	}
	
	private ArrayList<Integer> getResultado(ArrayList<Integer> listaA, int interaciones){
		
		  ArrayList<Integer> resultado=new ArrayList<Integer>();
		  ArrayList<Integer> p=new ArrayList<Integer>();
		  p.add(2);
		  p.add(3);
		  p.add(5);
		  p.add(7);
		  p.add(11);
		  p.add(13);
		  p.add(17);
		  
		  for(int i=0;i<interaciones;i++){
			  
			  for(int j=0;j<listaA.size();j++){
				  if(listaA.get(j)%p.get(i)==0){
					 resultado.add(listaA.get(j));
					 listaA.remove(j);
				  }
			  }
			  
		  }
		
		return resultado;
		
	}
	
	
	
	
}
