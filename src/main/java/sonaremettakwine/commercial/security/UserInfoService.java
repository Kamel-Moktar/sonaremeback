package sonaremettakwine.commercial.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = repository.findByName(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public UserInfo addUser(UserInfo userInfo) {
        String psw = userInfo.getPassword();
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);

        try {
            sendEmailPassword(userInfo, psw);

        } catch (MailException e) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + e.getMessage());
        }


        return userInfo;
    }

    public List<UserInfo> getAll() {

        return repository.getAllOrderByName();
    }

    public UserInfo getUserById(Long id) {
        return repository.getUserById(id);
    }

    public void deleteUser(UserInfo userInfo) {
        repository.delete(userInfo);
    }

    public void updateUser(UserInfo userInfo) {

        UserInfo userInfo1 = repository.getReferenceById(userInfo.getId());
        userInfo1.setName(userInfo.getName());
        userInfo1.setEmail(userInfo.getEmail());
        userInfo1.setActive(userInfo.getActive());
        userInfo1.setRoles(userInfo.getRoles());


    }

    public void sendEmailPassword(UserInfo user, String password) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("noreply@sonaremettakwin.com");
        msg.setTo(user.getEmail());
        msg.setSubject("A/S votre compte sur la platforme 'TASYIR'");
        String contente = "Bonjour [[userName]],\n" +
                "   -Votre nouveau mot de passe est : [[password]]. \n" +
                " Salutations ";
        contente = contente.replace("[[userName]]", user.getName());
        contente = contente.replace("[[password]]", "" + password);
        msg.setText(contente);
        javaMailSender.send(msg);


    }


    public void rinitPassword(UserInfo userInfo) {
        UserInfo userInfo1=repository.getReferenceById(userInfo.getId());
        String psw =Math.floor(Math.random()*1000)+"";
        userInfo1.setPassword(encoder.encode(psw));
        userInfo1.setName(userInfo.getName());
        userInfo1.setEmail(userInfo.getEmail());
        try {
            sendEmailPassword(userInfo1, psw);

        } catch (MailException e) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + e.getMessage());
        }

    }





    public UserInfo getUserByName(String name) {
        return repository.findUserByName(name);
    }

    public void changePassword(UserInfo userInfo, String password) {
        UserInfo userInfo1=repository.getReferenceById(userInfo.getId());

        userInfo1.setPassword(encoder.encode(password));
        userInfo1.setName(userInfo.getName());
        userInfo1.setEmail(userInfo.getEmail());
        try {
            sendEmailPassword(userInfo1, password);

        } catch (MailException e) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + e.getMessage());
        }

    }
}
