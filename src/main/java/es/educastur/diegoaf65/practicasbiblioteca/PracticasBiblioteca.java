/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.diegoaf65.practicasbiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 1dawd21
 */

/*
Este es un comentario de Documentación JavaDoc
*/

public class PracticasBiblioteca {

    private static ArrayList <Libro> libros = new ArrayList();
    private static ArrayList <Usuario> usuarios = new ArrayList();
    private static ArrayList <Prestamo> prestamos = new ArrayList();
    private static LocalDate hoy = LocalDate.now();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        cargaDatos();
        menuOpciones();
        //cargaLibros();
        //cargaUsuarios();
        //cargaPrestamos();
        //menuLibros();
        //menuUsuarios();
        //menuPrestamos();
        //menuListados();
        //listaDatos();
    }
    
    public static void menuOpciones(){
        int opcion;
        do{
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - GESTION LIBROS");
            System.out.println("\t --> 2 - GESTION USUARIOS");
            System.out.println("\t --> 3 - GESTION PRESTAMOS");
            System.out.println("\t --> 4 - GESTION LISTADOS");
            System.out.println("\t --> 5 - SALIR");
            
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:{
                    menuLibros();
                    break;
                }
                case 2:{
                    menuUsuarios();
                    break;
                }
                case 3:{
                    menuPrestamos();
                    break;
                }
                case 4:{
                    menuListados();
                    break;
                }
            }
        }
        while(opcion != 5);
    }
    
    public static void menuLibros(){
        int opcion;
        do{
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - NUEVO LIBRO");
            System.out.println("\t --> 2 - LISTADO LIBROS");
            System.out.println("\t --> 3 - MODIFICAR LIBRO");
            System.out.println("\t --> 4 - ELIMINAR LIBRO");
            System.out.println("\t --> 5 - SALIR");
            
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:{
                    añadirLibros();
                    break;
                }
                case 2:{
                    listadoLibros();
                    break;
                }
                case 3:{
                    modificarLibro();
                    break;
                }
                case 4:{
                    eliminarLibro();
                    break;
                }
            }
        }
        while(opcion != 5);
    }
    
    public static int buscaLibros(String isbn){
        int pos = -1;
        int i = 0;
        for (Libro l: libros){
            if (l.getIsbn().equalsIgnoreCase(isbn)){
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }
    
    public static void añadirLibros(){
        System.out.println("Vamos a agregar un nuevo libro a esta biblioteca");
        System.out.print("Dime el ISBN del libro: ");
        String isbn = sc.next();
        System.out.print("Dime el titulo del libro: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        System.out.print("Dime el autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Dime el genero del libro: ");
        String genero = sc.nextLine();
        System.out.print("Dime el numero de ejemplares del libro: ");
        int ejemplares = sc.nextInt();
        libros.add(new Libro(isbn, titulo, autor, genero, ejemplares));
        System.out.println("El libro ha sido agregado");
    }
    
    public static void listadoLibros(){
        System.out.println("Este es el listado actual de libros en la biblioteca:");
        for (Libro l: libros){
             System.out.println(l.getIsbn() + "-" + l.getTitulo() + "-" + l.getAutor() + "-" + l.getGenero() + "-" + l.getEjemplares());
        }
    }
    
    public static void modificarLibro(){
        System.out.println("Vamos a modificar un libro de esta biblioteca");
        System.out.print("Dime el ISBN del libro que quieres modificar: ");
        String isbn = sc.next();
        int p = buscaLibros(isbn);
        if (p == -1){
            System.out.println("Ese libro no esta en la biblioteca");
        }
        else{
            System.out.print("Nuevos ejemplares del libro: ");
            sc.nextLine();
            int ejemplares = sc.nextInt();
            libros.get(p).setEjemplares(ejemplares);
            System.out.println("El libro ha sido modificado");
        }
    }
    
    public static void eliminarLibro(){
        System.out.println("Vamos a eliminar un libro de esta biblioteca");
        System.out.print("Dime el ISBN del libro que quieres eliminar: ");
        String isbn = sc.next();
        int p = buscaLibros(isbn);
        if (p == -1){
            System.out.println("Ese libro no esta en la biblioteca");
        }
        else{
            libros.remove(p);
            System.out.println("El libro ha sido eliminado");
        }
    }
    
    public static void menuUsuarios(){
        int opcion;
        do{
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - NUEVO USUARIO");
            System.out.println("\t --> 2 - LISTADO USUARIOS");
            System.out.println("\t --> 3 - MODIFICAR USUARIO");
            System.out.println("\t --> 4 - ELIMINAR USUARIO");
            System.out.println("\t --> 5 - SALIR");
            
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:{
                    nuevoUsuario();
                    break;
                }
                case 2:{
                    listadoUsuarios();
                    break;
                }
                case 3:{
                    modificarUsuario();
                    break;
                }
                case 4:{
                    eliminarUsuario();
                    break;
                }
            }
        }
        while(opcion != 5);
    }
    
    public static int buscaUsuarios(String usuario){
        int pos = -1;
        int i = 0;
        for (Usuario u: usuarios){
            if (u.getDni().equalsIgnoreCase(usuario)){
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }
    
    public static void nuevoUsuario(){
        System.out.println("Vamos a agregar un nuevo usuario a esta biblioteca");
        System.out.print("Dime el DNI del usuario: ");
        String dni = sc.next();
        System.out.print("Dime el nombre del usuario: ");
        String nombre = sc.next();
        System.out.print("Dime el email del usuario: ");
        String email = sc.next();
        System.out.print("Dime el telefono del usuario: ");
        String telefono = sc.next();
        usuarios.add(new Usuario(dni, nombre, email, telefono));
        System.out.println("El usuario ha sido agregado");
    }
    
    public static void listadoUsuarios(){
        System.out.println("Este es el listado actual de los usuarios de la biblioteca");
        for (Usuario l: usuarios){
             System.out.println(l.getDni()+ "-" + l.getNombre()+ "-" + l.getEmail()+ "-" + l.getTelefono());
        }
    }
    
    public static void modificarUsuario(){
        System.out.println("Vamos a modificar un usuario de esta biblioteca");
        System.out.print("Dime el DNI del usuario que quieres modificar: ");
        String dni = sc.next();
        int p = buscaUsuarios(dni);
        if (p == -1){
            System.out.println("Ese usuario no esta en la biblioteca");
        }
        else{
            System.out.print("Nuevo telefono del usuario: ");
            sc.nextLine();
            String telefono = sc.next();
            usuarios.get(p).setTelefono(telefono);
            System.out.println("El usuario ha sido modificado");
        }
    }
    
    public static void eliminarUsuario(){
        System.out.println("Vamos a eliminar un usuario de esta biblioteca");
        System.out.print("Dime el dni del usuario que quieres eliminar: ");
        String dni = sc.next();
        int p = buscaUsuarios(dni);
        if (p == -1){
            System.out.println("Ese usuario no esta en la biblioteca");
        }
        else{
            usuarios.remove(p);
            System.out.println("El usuario ha sido eliminado");
        }
    }

    public static void menuPrestamos(){
        int opcion;
        do{
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - COGER PRESTAMO");
            System.out.println("\t --> 2 - HACER DEVOLUCION");
            System.out.println("\t --> 3 - SALIR");
            
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:{
                    cogerPrestamo();
                    break;
                }
                case 2:{
                    hacerDevolucion();
                    break;
                }
            }
        }
        while(opcion != 5);
    }
    
    public static int buscaPrestamos(String dni, String isbn){
        int pos = -1;
        for (int i = 0; i < prestamos.size(); i++){
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni) && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }
    
    public static void cogerPrestamo(){
        System.out.println("Vamos a coger un prestamo de un libro de esta biblioteca");
        System.out.print("Dime el ISBN del libro del que quieres coger un prestamo: ");
        String libroPrest = sc.next();
        int libroPos = buscaLibros(libroPrest);
        if (libroPos == -1){
            System.out.println("Ese libro no esta en la biblioteca");
        }
        else{
            Libro libro = libros.get(libroPos);
            if (libro.getEjemplares() <= 0){
                System.out.println("No quedan ejemplares disponibles de este libro");
                return;
            }
            System.out.print("Dime el DNI del usuario: ");
            String usuarioPrest = sc.next();
            int usuarioPos = buscaUsuarios(usuarioPrest);
            if (usuarioPos == -1){
                System.out.println("Ese usuario no esta en la biblioteca");
            }
            else{
                LocalDate fechaPrest = hoy;
                LocalDate fechaDev = hoy.plusDays(10);
                prestamos.add(new Prestamo(libro, usuarios.get(usuarioPos), fechaPrest, fechaDev));
                libro.setEjemplares(libro.getEjemplares()-1);
                System.out.println("El prestamo ha sido realizado");
            }
        }
    }
    
    public static void hacerDevolucion(){
        System.out.println("Vamos a hacer una devolucion de un libro de esta biblioteca");
        System.out.print("Dime el DNI del usuario: ");
        String dni = sc.next();
        System.out.print("Dime el ISBN del libro del que quieres hacer una devolucion: ");
        String isbn = sc.next();
        int posPrestamo = buscaPrestamos(dni, isbn);
        if (posPrestamo == -1){
            System.out.println("No hay ningun prestamo con esos datos");
        }
        else{
            prestamos.get(posPrestamo).setFechaDev(prestamos.get(posPrestamo).getFechaDev().plusDays(15));
            System.out.println("La devolucion ha sido realizada");
        }
    }

    public static void menuListados(){
        int opcion;
        do{
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - LISTAR LIBROS");
            System.out.println("\t --> 2 - LISTAR USUARIOS");
            System.out.println("\t --> 3 - LISTAR PRESTAMOS");
            System.out.println("\t --> 4 - SALIR");
            
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:{
                    listarLibros();
                    break;
                }
                case 2:{
                    listarUsuarios();
                    break;
                }
                case 3:{
                    listarPrestamos();
                    break;
                }
            }
        }
        while(opcion != 4);
    }
    
    public static void listarLibros() {
        for (Libro l : libros) {
            System.out.println("ISBN:\t\t" + l.getIsbn());
            System.out.println("Titulo:\t\t" + l.getTitulo());
            System.out.println("Autor:\t\t" + l.getAutor());
            System.out.println("Genero:\t\t" + l.getGenero());
            System.out.println("Ejemplares:\t" + l.getEjemplares());
            System.out.println();
        }
    }

    public static void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("DNI:\t\t" + u.getDni());
            System.out.println("Nombre:\t\t" + u.getNombre());
            System.out.println("Email:\t\t" + u.getEmail());
            System.out.println("Telefono:\t" + u.getTelefono());
            System.out.println();
        }
    }

    public static void listarPrestamos() {
        for (Prestamo p : prestamos) {
            System.out.println("Usuario:\t\t" + p.getUsuarioPrest().getDni() + " - " + p.getUsuarioPrest().getNombre() + " - " + p.getUsuarioPrest().getEmail() + " - " + p.getUsuarioPrest().getTelefono());
            System.out.println("Libro:\t\t\t" + p.getLibroPrest().getIsbn() + " - " + p.getLibroPrest().getTitulo() + " - " + p.getLibroPrest().getAutor() + " - " + p.getLibroPrest().getGenero() + " - " + p.getLibroPrest().getEjemplares());
            System.out.println("Fecha de prestamo:\t" + p.getFechaPrest());
            System.out.println("Fecha de devolución:\t" + p.getFechaDev());
            System.out.println();
        }
    }
    
    public static int stockLibro(String isbn) throws LibroNoExiste, LibroNoDisponible {
        int libroPos = buscaLibros(isbn);
        if (libroPos == -1) {
            throw new LibroNoExiste("No existe en esta biblioteca la referencia: " + libros.get(libroPos).getIsbn());
        } else if (libros.get(libroPos).getEjemplares() == 0) {
            String cadena = "No hay unidades del libro " + libros.get(libroPos).getTitulo()
                    + "\nDisponibles actualmente: "
                    + "\nFechas de devolucion previstas: ";
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(isbn)) {
                    cadena = cadena + "\n * " + p.getFechaDev();
                }
            }
            throw new LibroNoDisponible(cadena);
        }
        return libroPos;
    }
    
    public static void cargaDatos(){
        cargaLibros();
        cargaUsuarios();
        cargaPrestamos();
    }
    
    public static void cargaLibros(){
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Medico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chaman","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraiso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudu","A.M.Matute","Aventuras",0)); 
        libros.add(new Libro("1-88","El ultimo barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",0));
    }
    
    public static void cargaUsuarios(){
        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
    }
    
    public static void cargaPrestamos(){
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(1),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(4), hoy,hoy.plusDays(2)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(1), hoy,hoy.plusDays(5)));
    }
    
    public static void listaDatos(){
        System.out.println(libros);
        System.out.println(usuarios);
        System.out.println(prestamos);
    }

} //Llave final