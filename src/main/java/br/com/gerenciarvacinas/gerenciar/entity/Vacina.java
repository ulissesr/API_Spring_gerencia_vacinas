package br.com.gerenciarvacinas.gerenciar.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor //cria construtor com todos argumentos
@NoArgsConstructor //cria construtor sem argumentos
@Document(collection = "Vacinas")
//Expressão em JavaScript que será executada durante a validação
//@ScriptAssert(lang = "javascript", script = "_this.validade.isAfter(LocalDateTime.now())", message = "A data de validade deve ser futura")
public class Vacina {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private int codigo;
    @NotBlank(message = "O nome da vacina não foi informado!")
    private String nome;
    @NotBlank(message = "O nome do fabricante não foi informado!")
    private String fabricante;
    @NotNull
    @Min(value = 1, message = "Informe um número maior que 0!")
    private String lote;
    @NotNull
    @Future(message = "A data de validade deve ser futura!")
    private Date validade;
    @NotNull
    @Min(value = 1, message = "Informe um número maior que 0!")
    private int doses; // Número de doses
    private int intervaloEntreDoses = 0;// Intervalo mínimo entre doses em dias
}
