package br.com.desafiomercadolivre.modelos;

public enum StatusRetornoPagSeguro {


    SUCESSO,
    ERRO;

    public StatusTransacao retornarStatus(){
        if(this.equals(SUCESSO)){
            return StatusTransacao.Sucesso;
        }

        return StatusTransacao.Erro;
    }


}
