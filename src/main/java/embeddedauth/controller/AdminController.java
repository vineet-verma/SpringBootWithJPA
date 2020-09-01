package embeddedauth.controller;

import embeddedauth.entity.AdminDetail;
import embeddedauth.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/saveAdmin")
    public int saveAdminDetail(@RequestBody AdminDetail adminDetail) {
        return adminService.saveAdminDetail(adminDetail);
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody AdminDetail adminDetail) {
        int status;
        HttpHeaders httpHeader = null;

        // Authenticate User.
        status = adminService.adminLogin(adminDetail.getEmailId(), adminDetail.getPassword());
        return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);


    }
}
