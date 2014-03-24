package empregado;

import utilitarios.Data;
import utilitarios.Tempo;
import java.util.Calendar;

/**
 * @author i131252
 */
public class Empregado {

    private String primeiroNome;
    private String ultimoNome;    
    private Data dataContrato;    
    private Tempo horaEntrada;   
    private Tempo horaSaida;
    
    public static final int DIAS_TRABALHO = 5;
    public static final String PRIMEIRO_NOME_PREDEFINIDO = "sem primeiro nome";
    public static final String ULTIMO_NOME_PREDEFINIDO = "sem ultimo nome";
    
    public Empregado(String primeiroNome, String ultimoNome, int anoContrato,
            int mesContrato, int diaContrato, int horaEntrada,
            int minutoEntrada, int horaSaida, int minutoSaida){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(anoContrato, mesContrato, diaContrato);
        this.horaEntrada = new Tempo(horaEntrada, minutoEntrada );
        this.horaSaida = new Tempo(horaSaida, minutoSaida);
    }
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        this.horaEntrada = new Tempo(horaEntrada);
        this.horaSaida = new Tempo(horaSaida);
    }
    
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato){
        this(primeiroNome, ultimoNome, dataContrato, new Tempo(), new Tempo());
    }
    //public Empregado(NOME OMISSAO E TAL)
    
    //CONST COPIA
    
    public Data getDataContrato(){
        return new Data(this.dataContrato);
    }
    
    public void setDataContrato(Data dataContrato){
        this.dataContrato.setData(dataContrato.getAno(), dataContrato.getMes(),
                dataContrato.getDia());
    }
    
    

    @Override
    public boolean equals(Object outroObject){
        
    }
    
    public float horasSemanais(){
        int segundos = horaSaida.diferencaEmSegundos(horaEntrada);
        if(horaEntrada.isMaior(horaSaida)){
            segundos = 24 * 3600 - segundos;
        }
        return (float) segundos / 3600 * 5;
    }
    
    public int antiguidade(){
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) +1;
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
        
        int anos = anoAtual - dataContrato.getAno();
        if(anos > 0 && (dataContrato.getMes() > mesAtual || 
                (dataContrato.getMes() == mesAtual && dataContrato.getDia() > diaAtual))){
            anos--;
        }
        return anos;
    }
    
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Tempo getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada.setTempo(horaEntrada.getHora(), horaEntrada.getMinuto(),horaEntrada.getSegundo());
    }

    public Tempo getHoraSaida() {
        return horaSaida;
    }
    
    public void setHoraSaida(Tempo horaSaida){
        this.horaSaida.setTempo(horaEntrada.getHora(), horaEntrada.getMinuto(),horaEntrada.getSegundo());
    }

    
}
