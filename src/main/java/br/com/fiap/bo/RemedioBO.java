package br.com.fiap.bo;


import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.to.RemedioTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;

//classe que conversa com as classes DAO e que serve para definir regras de negocio do projeto
public class RemedioBO {

    private RemedioDAO remedioDAO;


    public ArrayList<RemedioTO>findAll(){
        remedioDAO = new RemedioDAO();
        //aqui se implementa as regras de negocio

        return remedioDAO.findAll();
    }

    public RemedioTO save (RemedioTO remedio){
        remedioDAO = new RemedioDAO();
        //regras de negocio

        //A validação de validade foi substituido pelas Bean validation
//        //verificando se o remedio esta vencido
//        if (remedio.getDataDeValidade().isBefore(LocalDate.now())){
//            //se a data de validade for 'antes',
//            // significa que o remedio esta vencido e retorna-se null
//            return null;
//        }
        return remedioDAO.save(remedio);

    }

    public RemedioTO findByCodigo(Long codigo){
        remedioDAO = new RemedioDAO();
        //aqui se implementa a regra de negocios
        return remedioDAO.findByCodigo(codigo);
    }

}



