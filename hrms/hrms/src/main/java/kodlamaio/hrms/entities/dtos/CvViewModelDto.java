package kodlamaio.hrms.entities.dtos;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvViewModelDto {

	/*
	 * private int id; private String firstName; private String lastName; private
	 * String email;
	 */

	/*
	 * private List<Education> educations; private List<Experience> experiences;
	 * private List<Skill> skills; private List<Language> languages; private
	 * List<Link> links; private CoverLetter coverLetter;
	 */
	
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
