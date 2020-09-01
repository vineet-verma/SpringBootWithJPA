package embeddedauth.DAO.interfaces;


import embeddedauth.entity.AdminDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends CrudRepository<AdminDetail, Long> {

    public AdminDetail findByEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);
}
