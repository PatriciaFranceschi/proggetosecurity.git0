package com.dotcomtirocinio.esercizio040;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Select;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
public class UsuarioControle {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/login")
    public String login(Principal principal) {


        return "/login";
    }

    @GetMapping("/insert")
    public String insert(HttpServletRequest request) {



        Usuario tusuario = new Usuario();
        tusuario.setUsername("patricia");
        tusuario.setPassword("123");
        tusuario.setRole("adm");
        //salva nel database
        userMapper.insertUser(tusuario);

        return "/login";
    }
    @Autowired
    private UserMapper mapper;



    // @RequestMapping("/insert")
    // public int insert(Usuario user) {
    //     return mapper.insertUser(user.getId((Usuario) mapper));
    //}

    // @RequestMapping("/update")
    // public int update(Usuario user) {
    //return mapper.updateUser(user);
    //  }

    //@RequestMapping("/delete")
    //public int delete(String name) {
    // return mapper.deleteUser(name);
    //}
}

