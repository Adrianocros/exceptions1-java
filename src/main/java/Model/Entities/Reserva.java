package Model.Entities;

import Model.Exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer NumeroDoQuarto;
    private Date checkIn;
    private Date checkOut;

    //Formatação da data
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) throws DomainException{
        if (!checkOut.after(checkIn)) {
            throw  new DomainException("#### Erro na reserva: A data de Check-out não pode ser menor que a data de Check-in ! ####");
        }
        NumeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroDoQuarto() {
        return NumeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        NumeroDoQuarto = numeroDoQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    //Datas nao podem ser altaradas a qualquer momento, no projeto tem um metodo para atualizar data atualizacaoData
//    public void setCheckIn(Date checkIn) {
//        this.checkIn = checkIn;
//    }

    public Date getCheckOut() {
        return checkOut;
    }
//Datas nao podem ser altaradas a qualquer momento, no projeto tem um metodo para atualizar data atualizacaoData
//    public void setCheckOut(Date checkOut) {
//        this.checkOut = checkOut;
//    }

    //Implementando diferença entre duas datas em milesegundos;
    public long duracao(){
        long diff = checkOut.getTime() - checkIn.getTime();
        //convertendo milesegundos em dias.
       return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    //Classe para atualizar datas
    public void atualizacaoData(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("#### Erro na reserva: As datas de reserva para atualização devem ser datas furutas ! ####");
        }
        if (!checkOut.after(checkIn)) {
            throw  new DomainException("#### Erro na reserva: A data de Check-out não pode ser menor que a data de Check-in ! ####");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    @Override
    public String toString(){
       return "Quarto "
            + getNumeroDoQuarto()
            + ", Check-in: "
            + sdf.format(checkIn)
            + ", check-out: "
            + sdf.format(checkOut)
            +", "
            + duracao()
            +" noites.";
    }
}
