package com.Spring.springboot;

import com.Spring.springboot.domain.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prueba {

    public static void main(String[] args) {

         List<Cliente> lista = new ArrayList<>(Arrays.asList(
                new Cliente(1,"william","william@gmail.com"),
                new Cliente(2,"orlando","orlando@gmail.com"),
                new Cliente(3,"daniel","daniel@gmail.com"),
                new Cliente(4,"brayan","brayan@gmail.com"),
                new Cliente(5,"juan","juan@gmail.com"),
                new Cliente(6,"ruslan","ruslan@gmail.com"),
                new Cliente(7,"marina","marina@gmail.com"),
                new Cliente(8,"angela","angela@gmail.com"),
                new Cliente(9,"karen","karen@gmail.com"),
                new Cliente(10,"veratriz","veratriz@gmail.com")
        ));

         Cliente user = lista.stream().map(cliente -> {
             cliente.setUsername(cliente.getUsername().toUpperCase());
             cliente.setEmail(cliente.getEmail().toUpperCase());
             return cliente;
         }).filter(cliente -> cliente.getId() == 1).findFirst().orElseThrow();
        System.out.println(user.getUsername() + " " + user.getEmail());




        Cat myCat = new Cat();
        printThing(myCat);

    }


    interface Printable{
        void print();
    }

    static class Cat implements Printable{
        public void print(){
            System.out.println("Meow");
        }
    }

    static void printThing(Printable thing){
        thing.print();
    }

}
