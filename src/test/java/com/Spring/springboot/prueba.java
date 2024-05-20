package com.Spring.springboot;

import com.Spring.springboot.domain.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prueba {

    public static void main(String[] args) {

         List<Usuario> lista = new ArrayList<>(Arrays.asList(
                new Usuario(1,"william","william@gmail.com"),
                new Usuario(2,"orlando","orlando@gmail.com"),
                new Usuario(3,"daniel","daniel@gmail.com"),
                new Usuario(4,"brayan","brayan@gmail.com"),
                new Usuario(5,"juan","juan@gmail.com"),
                new Usuario(6,"ruslan","ruslan@gmail.com"),
                new Usuario(7,"marina","marina@gmail.com"),
                new Usuario(8,"angela","angela@gmail.com"),
                new Usuario(9,"karen","karen@gmail.com"),
                new Usuario(10,"veratriz","veratriz@gmail.com")
        ));

         Usuario user = lista.stream().map(usuario -> {
             usuario.setUsername(usuario.getUsername().toUpperCase());
             usuario.setEmail(usuario.getEmail().toUpperCase());
             return usuario;
         }).filter(usuario -> usuario.getId() == 1).findFirst().orElseThrow();
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
