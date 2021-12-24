package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alumnos {
        ArrayList<Alumno> alumnos = new ArrayList();

    public Alumnos() {}

    public void listarAlumnos() {
        for(Alumno alumno: alumnos)
            System.out.println(alumno);
    }

    public void anadirAlumno(Alumno alumno) {
        if(correoElectronicoExiste(alumno.getCorreoElectronico()) || telefonoExiste(alumno.getTelefono()))
            System.out.println("Correo electrónico o teléfono móvil ya existe, no se ha podido registrar al alumno.");
        else {
            alumnos.add(alumno);
            System.out.println("Alumno registrado correctamente");
        }
    }

    public boolean correoElectronicoExiste(String correoElectronico) {
        for(int i=0; i<alumnos.size(); i++) {
            if(alumnos.get(i).getCorreoElectronico().equalsIgnoreCase(correoElectronico))
                return true;
        }

        return false;
    }

    public boolean telefonoExiste(String telefono) {
        for(int i=0; i<alumnos.size(); i++) {
            if(alumnos.get(i).getTelefono().equalsIgnoreCase(telefono))
                return true;
        }

        return false;
    }

    public void imprimeCiudadesTop () {
        //PRIMER FOR TE METE LAS CIUDADES SIN REPETIR EN UN ARRAY DE STRING
        ArrayList<String> ciudades = new ArrayList();
        int contador;
        ciudades.add(alumnos.get(0).getCiudad());
        for(int i=1; i<alumnos.size(); i++) {
            for(int j=0;j<ciudades.size(); j++) {
                if (!ciudades.contains(alumnos.get(i).getCiudad()))
                    ciudades.add(alumnos.get(i).getCiudad());
            }
        }

        //SEGUNDO FOR TE METE EL NÚMERO DE VECES QUE SALE CADA CIUDAD EN OTRA LISTA
        ArrayList<String> ciudades2 = new ArrayList();
        for(int i=0; i<ciudades.size(); i++) {
            contador = 0;
            for(int j=0; j<alumnos.size(); j++) {
                if(ciudades.get(i).equalsIgnoreCase(alumnos.get(j).getCiudad())) {
                    contador ++;
                }
            }
            ciudades2.add(ciudades.get(i) + " => " + contador);
        }

        //TERCER FOR TE ORDENA LAS CIUDADES POR NÚMERO DE VECES QUE SALE CADA UNA
        ciudades.clear();
        for(int i=alumnos.size(); i>=0; i--) {
            for(int j=0; j<ciudades2.size(); j++) {
                if(Character.getNumericValue(ciudades2.get(j).charAt(ciudades2.get(j).length()-1)) == i) {
                    ciudades.add(ciudades2.get(j));
                }
            }
        }

        for(String ciudad: ciudades) {
            System.out.println(ciudad);
        }
    }

    public void imprimePaisesTop() {
        //PRIMER FOR TE METE LOS PAÍSES SIN REPETIR EN UN ARRAY DE STRING
        ArrayList<String> paises = new ArrayList();
        int contador;
        paises.add(alumnos.get(0).getPais());
        for(int i=1; i<alumnos.size(); i++) {
            for(int j=0;j<paises.size(); j++) {
                if (!paises.contains(alumnos.get(i).getPais()))
                    paises.add(alumnos.get(i).getPais());
            }
        }

        //SEGUNDO FOR TE METE EL NÚMERO DE VECES QUE SALE CADA PAÍS EN OTRA LISTA
        ArrayList<String> paises2 = new ArrayList();
        for(int i=0; i<paises.size(); i++) {
            contador = 0;
            for(int j=0; j<alumnos.size(); j++) {
                if(paises.get(i).equalsIgnoreCase(alumnos.get(j).getPais())) {
                    contador ++;
                }
            }
            paises2.add(paises.get(i) + " => " + contador);
        }

        //TERCER FOR TE ORDENA LAS CIUDADES POR NÚMERO DE VECES QUE SALE CADA UNA
        paises.clear();
        for(int i=alumnos.size(); i>=0; i--) {
            for(int j=0; j<paises2.size(); j++) {
                if(Character.getNumericValue(paises2.get(j).charAt(paises2.get(j).length()-1)) == i) {
                    paises.add(paises2.get(j));
                }
            }
        }

        for(String pais: paises) {
            System.out.println(pais);
        }
    }

    public int totalRemotos() {
        int contador = 0;
        for(int i=0; i<alumnos.size(); i++) {
            if(alumnos.get(i).getPresencialidad().equalsIgnoreCase("Remoto"))
                contador++;
        }

        return contador;
    }

    public int totalPosibilidadTraslado() {
        int contador = 0;
        for(int i=0; i<alumnos.size(); i++) {
            if(alumnos.get(i).isTraslado())
                contador++;
        }

        return contador;
    }

    public int totalPresencialSinTraslado() {
        int contador = 0;
        for(int i=0; i<alumnos.size(); i++) {
            if(alumnos.get(i).getPresencialidad().equalsIgnoreCase("Presencial") &&
            !alumnos.get(i).isTraslado())
                contador++;
        }

        return contador;
    }
}
