package Aplication;

import Model.Entities.Reserva;
import Model.Exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data do Check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Entre com a data para atualização da reserva");
            System.out.print("Data do Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizacaoData(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }catch (ParseException e){
            System.out.println("Data digita da incorretamente !");
        }catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Você digitou LETRAS no numero do quarto!");
        }
    }
}

