package embeddedauth.service.interfaces;


import embeddedauth.entity.AdminDetail;

import java.util.List;

public interface AdminService {

	public int saveAdminDetail(AdminDetail adminDetail);
	
	public int adminLogin(String emailId, String password);
	
	public List<AdminDetail> getAdminData();
}
