package abc;

import javax.ejb.Stateless;


@Stateless
public class TestEJBean {
	
	private String name = "John Doe";
	
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
    
}
