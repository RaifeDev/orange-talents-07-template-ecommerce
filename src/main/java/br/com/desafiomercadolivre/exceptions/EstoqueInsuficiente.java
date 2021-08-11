package br.com.desafiomercadolivre.exceptions;

public class EstoqueInsuficiente extends RuntimeException{

    public EstoqueInsuficiente(String msg){
        super(msg);
    }


}
