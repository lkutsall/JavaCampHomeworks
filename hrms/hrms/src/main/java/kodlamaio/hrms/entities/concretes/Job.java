package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name ="Id")
	private int id;
	
	@Column(name ="JobTitle")
	private String jobTitle;

}
