package kodlamaio.hrms.core.configurations.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryImageService {

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager() {
		super();
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "lkutsall",
				"api_key", "442523395967199",
				"api_secret", "l_Jn4kbnSsJE1aYCchicvDnvOb4"));
	}

	
	
	  @Override public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
	  try {
	  
	  @SuppressWarnings("unchecked") Map<String, String> resultMap =(Map<String,
	  String>) cloudinary.uploader().upload(imageFile.getBytes(),
	  ObjectUtils.emptyMap()); return new SuccessDataResult<Map>(resultMap); }
	  catch (IOException e) { e.printStackTrace();
	  
	  } return new ErrorDataResult<Map>(); }
	 

}
