package com.dotcomtirocinio.esercizio040;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

        public interface UserMapper {

        @Insert("INSERT INTO public.usuario (username, password, role) VALUES(#{username}, #{password}, #{role});")
                int insertUser(Usuario usuario);



        @Select("SELECT password FROM public.usuario WHERE username =#{username};")
        String getLogin(String username);

}