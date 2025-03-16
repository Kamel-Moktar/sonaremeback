package sonaremettakwine.commercial.controller.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import sonaremettakwine.commercial.security.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService service;

    @Autowired
    RoleService roleService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/user")
    public List<UserInfo> getAllUser() {
        return service.getAll();
    }


    @GetMapping("/user/{id}")
    public UserInfo getUser(@PathVariable Long id) {

        return service.getUserById(id);

    }


    @PostMapping("/user")
    public UserInfo addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserInfo userInfo) {
        service.updateUser(userInfo);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        UserInfo userInfo = service.getUserById(id);
        service.deleteUser(userInfo);
    }

    @PostMapping("/changePassword")
    public void changePassword(@RequestBody Param param) {
        UserInfo userInfo=service.getUserById(param.userId);
        service.changePassword(userInfo,param.getPassword());

    }

    @PostMapping("/rinitPassword")
    public void rinitPassword(@RequestBody UserInfo userInfo) {
        service.rinitPassword(userInfo);
    }


    @GetMapping("/roles")
    public List<Role> getAllRole() {
        return roleService.getAll();
    }


    @PostMapping("/login")
    public Response authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return new Response(jwtService.generateToken(authRequest.getUsername()), null, null, null,null,null);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    @PostMapping("/currentUser")
    public UserInfo getCurentUser(@RequestBody Response response) {
        return service.getUserByName(response.getName());
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Response {
    String token;
    private Long id;
    private String name;
    private String email;
    private String role;
    private String active;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Param{
    Long  userId;
    private String  password;


}
