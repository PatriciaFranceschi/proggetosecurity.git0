package com.dotcomtirocinio.esercizio040;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.TimeOnlyTypeHandler;

@Mapper
public interface TabelaMapper {

    @Insert("INSERT INTO tabela (result, parametros, browser, campos, created_at) VALUES(#{result},#{parametros},#{browser},cast (#{campos} as JSONB) ,now())")
    int insertUser(NovaTabela novaTabela);

}

