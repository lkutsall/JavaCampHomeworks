package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterModelForEmployerDto {

	@NotBlank
	@NotBlank
	private String companyName;
	
	@NotBlank
	@NotNull
	private String webSite;
	
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private String passwordRepeat;
}
