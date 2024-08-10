
package electrodomesticos_shop;

import java.util.Scanner;

public class Electrodomesticos_Shop {

    public static void main(String[] args) {
        electrodomestico info[] = new electrodomestico[15];
        
        int op = 0;
        Scanner entrada = new Scanner(System.in);
        Scanner entrada2= new Scanner(System.in);
        
        while (op != 5){
            System.out.println("*******MENU*******");
            System.out.println("1. Guardar");
            System.out.println("2. Buscar individual");
            System.out.println("3. Ver todos");
            System.out.println("4. Modificar datos");
            System.out.println("5. Salir");
            op = entrada.nextInt();
            System.out.println("******************");           
            if (op == 1){
                System.out.println("Ingrese el codigo");
                int codigo = entrada.nextInt();
                System.out.println("Ingrese el nombre del producto");
                String nombre = entrada2.nextLine();
                System.out.println("Ingrese la marca");
                String marca = entrada2.nextLine();
                System.out.println(nuevoProducto(codigo, nombre, marca, info));
            }else if(op == 2){
                System.out.println("Ingrese el codigo");
                int codigo = entrada.nextInt();
                System.out.println(buscarIndividual(codigo, info));
            }else if(op == 3){
                System.out.println(mostrarTodo(info));
            }else if(op ==4){
                System.out.println("Ingrese el codigo");
                int codigo = entrada.nextInt();
                if (buscarPbooleano(codigo, info)) {
                System.out.println("Ingrese el nuevo nombre");
                String nombre = entrada2.nextLine();
                System.out.println("Ingrese la marca");
                String marca = entrada2.nextLine();
                    System.out.println(modificarDatos(codigo, nombre, marca, info));
                }else{
                    System.out.println("El codigo no existe");
                }
               
            }
        }
    }
    public static String nuevoProducto(int codigo, String nombre, String marca, electrodomestico array[]){
       boolean lleno = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new electrodomestico(codigo, nombre, marca);
                lleno = false;
                break;
            }else if(array[i].getCodigo()== codigo){
                return "El codigo ya existe";
            }
        }
        if (!lleno) {
            return "Se guardo con exito";
        }else{
            return "Ya no hay espacio";
        }
    }
    public static String buscarIndividual(int codigo, electrodomestico array[]){
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getCodigo()==codigo) {
                return "Los datos son: \n nombre: " + array[i].getNombre() + " " + "marca: " + array[i].getMarca();
            }
        }
        return "El codigo no existe";
    }
    public static String mostrarTodo(electrodomestico array[]){
        String cadena = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                cadena = cadena + array[i].getCodigo() + "|" + array[i].getNombre() + "|" + array[i].getMarca() + "\n";
            }
        }
        return cadena;
    }
    public static boolean buscarPbooleano(int codigo, electrodomestico array[]){
        for (int i = 0; i < array.length; i++) {
            if (array[i]!= null && array[i].getCodigo()==codigo) {
                return true;
            }
        }
        return false;
    }
    public static String modificarDatos(int codigo, String nombre, String marca, electrodomestico array[]){
        for (int i = 0; i < array.length; i++) {
            if (array[i]!= null && array[i].getCodigo()==codigo) {
                array[i].setNombre(nombre);
                array[i].setMarca(marca);
                return "Se actualizaron los datos";
            }
        }
        return "";
    }
}
