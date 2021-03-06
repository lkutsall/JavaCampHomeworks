package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends User {

	@Column(name = "FirstName")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name = "LastName")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name = "DateOfBirth")
	@NotNull
	@NotBlank
	private Date dateOfBirth;
	
	@Column(name = "NationalId")
	@NotNull
	@NotBlank
	private String nationalId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToOne(mappedBy = "employee")
	private Image image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Link> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Skill> skills;
}
