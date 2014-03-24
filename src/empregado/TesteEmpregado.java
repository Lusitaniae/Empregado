package empregado;

import utilitarios.Data;
import utilitarios.Tempo;

public class TesteEmpregado {

    
    public static void main(String[] args) {

    Data d1 = new Data();
    System.out.println("Data d = " + d1.toAnoMesDiaString());
    
    Tempo t1 = new Tempo(04,0);
    System.out.println("Tempo t1 = " + t1.toStringHHMMSS());
    
    Tempo t2 = new Tempo (12,30);
    System.out.println("Tempo t2 = " + t2.toStringHHMMSS());
    
    Empregado e1 = new Empregado("John","Galt",d1, t1, t2);
    
    Empregado e2 = new Empregado("Cato", ",The Elder",d1, t1, t2);
    
    //Data iguais?
    
    if(e1.getDataContrato().equals(e2.getDataContrato()))
        System.out.println("Atributos de data com referencias partilhadas");
    
    //Tempo Iguais
    if(e1.getHoraEntrada().equals(e2.getHoraEntrada()) && e1.getHoraSaida().equals(e2.getHoraSaida()))
        System.out.println("Atributos de tempo com referencias partilhadas");
    
    
}

   
    
}
