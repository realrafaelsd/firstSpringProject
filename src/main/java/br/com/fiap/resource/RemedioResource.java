package br.com.fiap.resource;

import br.com.fiap.bo.RemedioBO;
import br.com.fiap.to.RemedioTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//classe que conversa com as classes DAO e que serve para definir regras de negocio do projeto

@RestController //dizendo para o Spring que essa classe funcionara como Controller (MVC)
@RequestMapping("/megafarma") //definindo outro endpoint
public class RemedioResource {
    private RemedioBO remedioBO = new RemedioBO();


    @GetMapping
    //sempre que minha aplicacao receber uma requisisão do metodo get,
    // será executado a lista para a exibição dos remedios presentes
    public ResponseEntity<List<RemedioTO>> findAll(){
        List<RemedioTO> remedios = remedioBO.findAll();
        if (remedios != null) {
            return ResponseEntity.status(HttpStatus.OK).body(remedios); //configurando o retorno com status ok -200- e
            // a lista de remedios encontrados
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(remedios); //configurando o retorno com status Not_found-404- e
            // a lista de remedios encontrados

        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> findByCodigo(@PathVariable Long codigo){
        RemedioTO remedio = remedioBO.findByCodigo(codigo);
        if (remedio != null) {
            return ResponseEntity.status(HttpStatus.OK).body(remedio);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rémedio não encontrado");

        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid RemedioTO remedio) {
        //requestBody é o corpo da requisição, ou seja, o arquivo JSON
        //Valid irá 'ligar' o bean validation
        try {
            RemedioTO  resultado = remedioBO.save(remedio);
            return ResponseEntity.status(HttpStatus.CREATED).body(remedio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar remédio");
        }
    }

    @DeleteMapping("/{codigo}") // Anotação para apagar o registro de acordo com o codigo
    public ResponseEntity<String> delete (@PathVariable Long codigo) {
        if (remedioBO.delete(codigo)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Reméxdio deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Remédio não encontrado");

        }
    }

    @PutMapping ("/{codigo}")//Anotação para inserir algo
    public ResponseEntity<?> update (@PathVariable Long codigo,@RequestBody @Valid RemedioTO remedio){ //a primeira anotação refere-se que o codigo virá
    //da URL e a segunda que o remedio seguirá o corpo da requisição
        try {
            remedio.setCodigo(codigo);
            RemedioTO resultado = remedioBO.update((remedio));
            return ResponseEntity.status(HttpStatus.CREATED).body(remedio);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar o remédio");
        }



    }

}
