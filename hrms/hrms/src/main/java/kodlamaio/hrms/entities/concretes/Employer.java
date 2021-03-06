package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisemens"})
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "CompanyName")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name = "PhoneNumber")
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@Column(name = "WebAddress")
	@NotNull
	@NotBlank
	private String webAddress;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
}
