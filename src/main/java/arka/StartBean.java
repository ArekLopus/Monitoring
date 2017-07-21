package arka;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class StartBean implements Serializable {
	private static final long serialVersionUID = -6746806481518377966L;
	
	private String name = "Guest";
	
	public StartBean() {
		
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
