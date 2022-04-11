package Aplication;

import Model.Entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data do Check-in (dd/MM/yyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data do Check-out (dd/MM/yyy): ");
        Date checkOut = sdf.parse(sc.next());


        if(!checkOut.after(checkIn)){
            System.out.println("#### Erro na reserva: A data de Check-out não pode ser menor que a data de Check-in ! ####");
        }else{
            Reserva reserva = new Reserva(numero,checkIn,checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Entre com a data para atualização da reserva");
            System.out.print("Data do Check-in (dd/MM/yyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-out (dd/MM/yyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("#### Erro na reserva: As datas de reserva para atualização devem ser datas furutas ! ####");
            }else if (!checkOut.after(checkIn)) {
                    System.out.println("#### Erro na reserva: A data de Check-out não pode ser menor que a data de Check-in ! ####");
            }else {
                    reserva.atualizacaoData(checkIn,checkOut);
                    System.out.println("Reserva: " + reserva);
            }
        }
    }
}

