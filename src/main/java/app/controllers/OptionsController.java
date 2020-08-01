package app.controllers;

import app.models.Users;
import app.repository.UserRepository;
import app.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/")

public class OptionsController {

    private UserService userService;
    private static Logger logger = LoggerFactory.getLogger(OptionsController.class);
    private String data = null;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;



    @Autowired
    public OptionsController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/options/create", method = RequestMethod.POST)
    public String loginValidation(Users users, String password, Model model, String name, BindingResult result, @RequestParam(value = "error", required = false)
            String error) throws NoSuchAlgorithmException {

        Users personFromBd = userRepository.getName(name);
        if (personFromBd != null) {
            model.addAttribute("error", name);
            return "error";
        } else {
//            PasswordCoder passwordCoder = new PasswordCoder(password);
            users.setPassword(encoder.encode(password));
            userService.addUser(users);
            model.addAttribute("personToPopUp", users);
            logger.info(users.getRegDate() + " " + users.getName() + " with ID " + users.getId() + " " + "Was Created");
            return "create";
        }
    }

    @RequestMapping(value = "options/personsList")
    public String getAll(Model model) throws InterruptedException {
        List<Users> personsForms = userService.getAll();
        model.addAttribute("personsList", personsForms);
//        setData(String.valueOf(model));
        return "registration";
    }
}
