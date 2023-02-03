package com.dotcomtirocinio.esercizio040;


import org.json.JSONObject;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;


@RestController
public class ParamentriController {

    @Autowired
    private Parametri parametri;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TabelaMapper tabelaMapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private EncoderConfig passwordEncoder;


    @GetMapping("/")
    public ModelAndView home() {

        return new ModelAndView("index");
    }

    @GetMapping("/inizia")
    public ModelAndView carregaForm() throws JAXBException, IOException {

        ModelAndView mav = new ModelAndView("inizia.html");
        mav.addObject("parametri", this.parametri);

        return mav;
    }

    @PostMapping("/result")
    public ModelAndView submitFormRegister(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("result.html");
        Enumeration<String> inputs = request.getParameterNames();
        ArrayList<Valore> listaValori = new ArrayList<>();

//        String toCalc = AppMarshaller.XmlCalField; // Riga di XML per calcolo
        String toCalc = this.parametri.getRisultato(); // Riga di XML per calcolo

        Map<String, Double> fields = new HashMap<String, Double>();

        while (inputs.hasMoreElements()) {

            String key = inputs.nextElement();
            Double val = Double.parseDouble(request.getParameter(key));

            fields.put(key, val);  //associare i valori dall'input

            // Per mostrare in Html
            Valore v = new Valore();  //instacia classe Valore
            v.setNome(key);
            v.setValore(val);
            listaValori.add(v);
        }

        // APPLICARE EXPRESSIONBUILDER
        Double valoretotale = (new ExpressionBuilder(toCalc)) //iniziare ExpressionBuilder che chiama riga XML risultato
                .variables(fields.keySet()) //aggiungi campi XML -- fields = Map<String, Double> fields = new HashMap<String, Double>();
                .build().setVariables(fields) //aggiungi  inputs
                .evaluate(); //eseguire il calcolo


        // RESTITUZIONE DEI DATI IN HTML
        mav.addObject("valoretotale", valoretotale);

        //ELENCO DI VALORI
        mav.addObject("lista", listaValori);
        mav.addObject("FieldsToSum", toCalc);

        //Utilizare Json
        JSONObject jsonObject = new JSONObject();


        //Utilizare user-Agent
        String userAgent = request.getHeader("User-Agent");

        // Data Base
        NovaTabela novaTabela = new NovaTabela();
        novaTabela.setResult(valoretotale);
        novaTabela.getId();
        novaTabela.setBrowser(userAgent);
        novaTabela.setCampos(String.valueOf(jsonObject.put("parametri", JSONObject.wrap(fields))));
        novaTabela.setParametros(toCalc);
        novaTabela.getCreatedAt();

        //salva nel database
         tabelaMapper.insertUser(novaTabela);
        System.out.println("salvu");


//         tabelaMapper.insertUser(novaTabela.getId());
//         tabelaMapper.insertUser(novaTabela.setBrowser(userAgent));
////         tabelaMapper.insertUser(novaTabela.setCampos(String.valueOf(jsonObject.put("parametri", JSONObject.wrap(fields))));
//        tabelaMapper.insertUser(novaTabela.setParametros(toCalc));

//        salva nel database login-password



        return mav;

    }

    //lista result, parametros, browser, createdAt
    @GetMapping("/value")
    public ModelAndView newshowAll() {
        System.out.println("entrou no value");
        ModelAndView modelA = new ModelAndView("novatabela.html");
        modelA.addObject("repositorioDue", tabelaMapper.insertUser((NovaTabela) tabelaMapper));
        return modelA;

    }



//    @GetMapping("/login")
//    public ModelAndView login() {
//        ModelAndView modelAndView = new ModelAndView("login.html");
//        modelAndView.addObject("incluiMaybatis", userMapper);
//
//        return modelAndView;
//
//    }

}