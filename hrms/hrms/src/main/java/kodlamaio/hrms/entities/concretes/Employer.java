package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
}
