package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddModelForJobAdvertisementDto {

	@NotBlank
	@NotNull
	private String jobTitle;
	
	@NotBlank
	@NotNull
	private String cityName;
	
	@NotBlank
	@NotNull
	private String employerName;
	
	@NotBlank
	@NotNull
	private String jobDescription;
	
	@NotBlank
	@NotNull
	private String numberOfPositions;
	
	@NotBlank
	@NotNull
	private double salaryRangeMin;
	
	@NotBlank
	@NotNull
	private double salaryRangeMax;
	
	@NotNull
	private Date expirationtionDate;
}
