package api.prueba2.modusoftware.models.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arrays")
public class Array implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String inputArray;
	
	
	public ArrayList<Integer> getListA(){
		
		String datos[]=inputArray.split(",");
		ArrayList<Integer> listNumber=new ArrayList<Integer>();
		for(int i=0;i<datos.length;i++){
		    listNumber.add(Integer.parseInt(datos[i]));	
		}		
		return listNumber;
	}	
		
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}

    

	
	public String getInputArray() {
		return inputArray;
	}

	public void setInputArray(String inputArray) {
		this.inputArray = inputArray;
	}







	private static final long serialVersionUID = 1L;

}
