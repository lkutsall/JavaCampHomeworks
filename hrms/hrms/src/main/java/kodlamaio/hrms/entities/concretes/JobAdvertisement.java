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
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JobAdvertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	@NotEmpty
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "job_description")
	private String jobDescription;

	@NotBlank
	@NotNull
	@Column(name = "salary_range_min")
	private double salaryRangeMin;

	@NotBlank
	@NotNull
	@Column(name = "salary_range_max")
	private double salaryRangeMax;

	@NotBlank
	@NotNull
	@Column(name = "number_of_positions")
	private String numberOfPositions;

	@NotNull
	@Column(name = "create_date")
	private Date createDate;
	
	@NotNull
	@Column(name = "expiration_date")
	private Date expirationDate;

	@NotBlank
	@NotNull
	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
}
