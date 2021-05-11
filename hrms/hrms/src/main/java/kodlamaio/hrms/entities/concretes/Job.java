package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "Jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name ="Id")
	private int Id;
	
	@Column(name ="JobTitle")
	private String JobTitle;
	
	public Job() {
		
	}
	
	public Job(int id, String jobTitle) {
		super();
		Id = id;
		JobTitle = jobTitle;
	}
}
