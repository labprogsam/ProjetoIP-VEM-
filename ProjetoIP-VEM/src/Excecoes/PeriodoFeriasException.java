package Excecoes;

public class PeriodoFeriasException extends Exception {

    public PeriodoFeriasException()
    {
        super("Só é possível obter o bônus de férias no período de férias");
    }
}
