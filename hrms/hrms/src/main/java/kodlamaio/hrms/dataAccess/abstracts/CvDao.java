/*
 * package kodlamaio.hrms.dataAccess.abstracts;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * import kodlamaio.hrms.entities.dtos.CvViewModelDto;
 * 
 * public interface CvDao extends JpaRepository<CvViewModelDto, Integer>{
 * 
 * 
 * @Query("Select new kodlamaio.hrms.entities.dtos.CvViewModelDto(e.id, e.firstName, e.lastName, e.email, ed, ex, s, l, li, c) From Employee e inner join e.educations ed inner join e.experiences ex inner join e.skills s inner join e.languages l e.links li inner join e.coverLetter c "
 * ) CvViewModelDto getCvViewModelDto();
 * 
 * }
 */
