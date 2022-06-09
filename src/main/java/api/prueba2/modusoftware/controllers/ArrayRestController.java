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
	
	/**
	 * Endpoint que obtiene el array por id
	 * @param id es el id de array que se va ha obtener. 
	 * @return retorna el objeto array que trae de la base de datos. 
	 * */
	@GetMapping("/array/{id}")
	public Array show(@PathVariable Long id){
		return arrayService.findById(id);
	}
	
	/**
	 * Este metodo calcula la lista de los vasos seleccionados apartir del algoritmo de seleccion
	 * que usa la lista de primos con el número de interaciones. 
	 * @param id es el id del array de vasos a probar
	 * @param interaciones numero de intaraciones que va aplicar sobre el array de primos
	 * @return la lista de vasos seleccionados.
	 */
	@GetMapping("/resultado/{id}/{interaciones}")
	public ArrayList<Integer> getVasos(@PathVariable Long id, @PathVariable int interaciones){
		
	     Array lista=arrayService.findById(id);
	     return getResultado(lista.getListA(),interaciones);
		
	}
	
	/**
	 * Algoritmo que selecciona los vasos a partir de la lista de primos y numero de interacciones
	 * @param listaA lista de vasos a examinar
	 * @param interaciones numero de interaciones que se aplica sobre la lista de los primos
	 * @return lista de vasos seleccionados
	 */
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
