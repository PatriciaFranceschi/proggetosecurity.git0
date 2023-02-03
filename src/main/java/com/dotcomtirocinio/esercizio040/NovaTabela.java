package com.dotcomtirocinio.esercizio040;

//import org.hibernate.annotations.ColumnDefault;
//import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;


    public class NovaTabela
    {

        private Long id;

        private Double result;

        private String parametros;

        private String browser;


        private String campos;


        public String getCampos(String parametri) {
            return campos;
        }

        public void setCampos(String campos) {
            this.campos = campos;
        }


        //@ColumnDefault(value = "now()")  //cambiare para sys_timestamp
       // @CreationTimestamp
        private LocalDateTime createdAt;

        public NovaTabela() {}

        public Long getId()
        {
            return this.id;
        }

        public NovaTabela setId(Long id)
        {
            this.id = id;
            return this;
        }

        public Double getResult(Double valoretotale)
        {
            return this.result;
        }

        public NovaTabela setResult(Double result)
        {
            this.result = result;
            return this;
        }

        public String getParametros(String toCalc)
        {
            return parametros;
        }

        public NovaTabela setParametros(String parametros)
        {
            this.parametros = parametros;
            return this;
        }

        public String getBrowser()
        {
            return this.browser;
        }

        public NovaTabela setBrowser(String browser)
        {
            this.browser = browser;
            return this;
        }

        public LocalDateTime getCreatedAt()
        {
            return this.createdAt;
        }

        public NovaTabela setCreatedAt()
        {
            this.createdAt = createdAt;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NovaTabela that = (NovaTabela) o;
            return id.equals(that.id) && result.equals(that.result) && parametros.equals(that.parametros) && browser.equals(that.browser) && campos.equals(that.campos) && createdAt.equals(that.createdAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, result, parametros, browser, campos, createdAt);
        }
    }

