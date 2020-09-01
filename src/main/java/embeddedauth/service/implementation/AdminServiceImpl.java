package embeddedauth.service.implementation;


import embeddedauth.DAO.interfaces.AdminDAO;
import embeddedauth.entity.AdminDetail;
import embeddedauth.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Transactional
    public int saveAdminDetail(AdminDetail adminDetail) {
        AdminDetail detail = adminDAO.save(adminDetail);
        return detail.getAdminID();
    }

    @Transactional
    public int adminLogin(String emailId, String password) {
        AdminDetail detail = adminDAO.findByEmailIdAndPassword(emailId, password);
        return detail.getAdminID();
    }

    @Transactional
    public List<AdminDetail> getAdminData() {
        return (List<AdminDetail>) adminDAO.findAll();
    }


}
