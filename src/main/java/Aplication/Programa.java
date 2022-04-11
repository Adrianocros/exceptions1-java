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
        System.out.print("Data do Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data do Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());


        if(!checkOut.after(checkIn)){
            System.out.println("#### Erro na reserva: A data de Check-out não pode ser menor que a data de Check-in ! ####");
        }else{
            Reserva reserva = new Reserva(numero,checkIn,checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Entre com a data para atualização da reserva");
            System.out.print("Data do Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());


            String error =  reserva.atualizacaoData(checkIn,checkOut);
            if(error != null){
                System.out.println("Erro na reserva: " + error);
            }else {
                System.out.println("Reserva: " + reserva);
            }

        }
    }
}

