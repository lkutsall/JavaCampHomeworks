package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "SchoolName")
	@NotNull
	@NotBlank
	private String schoolName;
	
	@Column(name = "Department")
	@NotNull
	@NotBlank
	private String department;
	
	@Column(name = "StartDate")
	private Date startDate;
	
	@Column(name = "GraduationDate")
	private Date graduationDate;
	
	@ManyToOne()
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
