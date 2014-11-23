package pl.edu.pk.plagiarism.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="files", schema="zpiproject")
public class File {
	
	
	
	private int id;
	private String path;
	private String name;
	
		@Id
    	@Column(name="id", unique = true, nullable = false)
    	public int getId() {
        return id;
    	}
	
		public void setId(int id) {
	        this.id = id;
	    }
	 
	 
	    @Column(name="name", unique = true, nullable = false)
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    @Column(name="path", unique = true, nullable = false)
	    public String getPath() {
	        return path;
	    }
	    
	    public void setPath(String surname) {
	        this.path = surname;
	    }


}
