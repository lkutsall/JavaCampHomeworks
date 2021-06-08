package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.configurations.cloudinary.CloudinaryImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryImageService cloudinaryImageService;

	@Autowired
	public ImageManager(ImageDao imageDao, CloudinaryImageService cloudinaryImageService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryImageService = cloudinaryImageService;
	}
	
	public Result add(Image image, MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.cloudinaryImageService.uploadImageFile(imageFile).getData();
		image.setImageUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Your image added to database successfully.");
	}

	@Override
	public DataResult<Image> getImageByEmployeeId(int id) {
		Image imageToGet = imageDao.getImageByEmployee_Id(id);
		return new SuccessDataResult<Image>(imageToGet, "Image successfully listed.");
	}
}
