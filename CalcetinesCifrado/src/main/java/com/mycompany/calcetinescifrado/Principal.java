package com.mycompany.calcetinescifrado;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {      
    
    Gestor a = new Gestor();
    String opcion = "0";
    Scanner scan = new Scanner(System.in);
    int Nivel; //1=(Administrador) 2(Asistente) 3(Vendedor)
    
    
    
    //String letras = "A0BCD1EFG2HIJ3KLM4NÑO5PQR6STU7VWX8YZ9";
    
    // Si el archivo no esta cifrado descomentar la siguiente linea
    a.cifrar("Clientes.txt");

    // Decodificar
    //a.descifrar("Clientes.txt");
    
    
    
    System.out.print("Hola! Introduce tu nombre\n" );
    System.out.println(a.leerNombres("Usuarios.txt"));
    String nombre = scan.nextLine();
    System.out.print("Hola " + nombre +"\n");
    Nivel =(a.Nivel("Usuarios.txt",nombre));
    
    System.out.print("\nTienes nivel: " + Nivel +"\n");
    
    while (Nivel == 3) { // El gestor es un vendedor
        System.out.print("\nSeleccione una:\n");
        System.out.print("1.Listar productos: \n");
        opcion = scan.nextLine();

        if (opcion.equals("1")){
            System.out.print("Lista de productos\n");
            break;
        }else{
            System.out.print("Esa no es una opcion\n");
        }
    }
    
    while (Nivel == 2){ // El gestor es un asistente
        System.out.print("\nSeleccione una:\n");
        System.out.print("1.Listar productos: \n");
        System.out.print("2.Agregar producto: \n");
        System.out.print("3.Modificar venta: \n");
        System.out.print("4.Desactivar producto: \n");
        System.out.print("5.Crear venta: \n");
        System.out.print("6.Añadir un cliente: \n");
        System.out.print("7.Modificar informacion de un cliente: \n");
        opcion = scan.nextLine();
        if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")||opcion.equals("4")||opcion.equals("5")||opcion.equals("6")||opcion.equals("7")){
            break;
        }else {
            System.out.print("Esa no es una opcion\n");
        }
    }
    
    while (Nivel == 1){ // El gestor es un administrador
        System.out.print("\nSeleccione una:\n");
        System.out.print("1.Listar productos: \n"); 
        System.out.print("2.Agregar producto: \n"); 
        System.out.print("3.Modificar venta: \n"); 
        System.out.print("4.Desactivar producto: \n"); 
        System.out.print("5.Crear venta: \n"); 
        System.out.print("6.Eliminar venta: \n"); 
        System.out.print("7.Agregar usuario: \n");
        System.out.print("8.Añadir un cliente: \n");
        System.out.print("9.Modificar informacion de un cliente: \n");
        System.out.print("10.Eliminar un cliente: \n");
        opcion = scan.nextLine();
        if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")||opcion.equals("4")||opcion.equals("5")||opcion.equals("6")||opcion.equals("7")||opcion.equals("8")||opcion.equals("9")||opcion.equals("10")){
            break;
        }else {
            System.out.print("Esa no es una opcion\n");
        }
    }
    
    if (Nivel < 4){
        if ("1".equals(opcion)) { // Listar productos
            System.out.println(a.leer("Productos.txt"));
        }
    }
    
    if (Nivel < 3) {
        if ("2".equals(opcion)) { // Agregar productos
            String estampado = "";
            String color = "";
            int precio;
            String activo = "";
            System.out.print("Introduce el estampado del calcetin: ");
            estampado = scan.nextLine();
            System.out.print("Introduce el color del calcetin: ");
            color = scan.nextLine();
            System.out.print("Introduce el precio del calcetin: ");
            precio = Integer.parseInt(scan.nextLine());
            System.out.print("¿Se encuentra activo? Si / No");
            activo = scan.nextLine();
            
            Random r = new Random();
            int idProducto = r.nextInt(9000) + 1000;
            
            String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
            System.out.print("El producto: ");
            System.out.println(a.Agregar("Productos.txt",nuevo));
            System.out.print(" ha sido creado.\n");
        }
        
        if ("3".equals(opcion)) { // Modificar venta
            System.out.print("\nIntroduce el identificador de la venta que deseas modificar: \n");
            System.out.println(a.leer("Ventas.txt"));
            int idVenta;
            idVenta = Integer.parseInt(scan.nextLine());
            
            System.out.print("¿Como deseas modificarla?\n");
            
            System.out.print("¿Quieres cambiar el nombre? Si / No\n");
            String cambiarNombre = scan.nextLine();
            String nombreAntiguo = "";
            String nombreNuevo = "";
            String productoAntiguo = "";
            String productoNuevo = "";
            
            if( cambiarNombre.equals("si") || cambiarNombre.equals("Si") ) {
                nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                System.out.print("Introduce el nuevo nombre: ");
                nombreNuevo = scan.nextLine();
            } else if ( cambiarNombre.equals("no") || cambiarNombre.equals("No") ) {
                nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                nombreNuevo = nombreAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el producto? Si / No\n");
            String cambiarCalcetin = scan.nextLine();
            String calcetinNuevo = "";
            if( cambiarCalcetin.equals("si") || cambiarCalcetin.equals("Si") ) {
                productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                System.out.print("Introduce el nuevo producto: ");
                productoNuevo = scan.nextLine();
            } else if ( cambiarCalcetin.equals("no") || cambiarCalcetin.equals("No") ) {
                productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                productoNuevo = productoAntiguo;
            }
            
            String antiguo = "";
            String nuevo = "";
            
            antiguo = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
            nuevo = idVenta + ";" + nombreNuevo + ";" + productoNuevo;
  
            System.out.print("La venta: ' " + antiguo + " ' ha sido modificada a:");
            System.out.println(a.Modificar("Ventas.txt",antiguo,nuevo));
        }
    
        if ("5".equals(opcion)) { // Crear venta
            System.out.print("\nIntroduce el nombre del comprador: \n");
            String nombreComprador = scan.nextLine();
            
            System.out.print("\nIntroduce el estampado del producto: \n");
            String estampadoProducto = scan.nextLine();
            
            Random r = new Random();
            int idVenta = r.nextInt(9000) + 1000;

            String nuevo = idVenta + ";" + nombreComprador + ";" + estampadoProducto;
            System.out.print("La venta: ");
            System.out.println(a.Agregar("Ventas.txt",nuevo));
            System.out.print(" ha sido creada.");
        }
        
        if ("4".equals(opcion)) { // Desactivar productos
            System.out.print("\nIntroduce el identificador del producto: \n");
            int idProducto = Integer.parseInt(scan.nextLine());
            
            String estampado = "";
            String color = "";
            String precio = "";
            String activo = "";
            
            estampado =  a.leerVentas("Productos.txt",idProducto,1);
            color =  a.leerVentas("Productos.txt",idProducto,2);
            precio =  a.leerVentas("Productos.txt",idProducto,3);
            activo =  a.leerVentas("Productos.txt",idProducto,4);
            
            String antiguo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
            
            if( activo.equals("si") || activo.equals("Si") ) {
                System.out.print("El producto se encuentra: " + activo + "\n"); // activado
                System.out.print("¿Quieres desactivarlo? Si / No ");
                String ActivoNuevo = scan.nextLine();
                if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                    activo = "No";
                } else {
                    activo = "Si";
                }
                
            } else {
                System.out.print("El producto se encuentra: " + activo + "\n"); // desactivado
                System.out.print("¿Quieres activarlo? Si / No ");
                String ActivoNuevo = scan.nextLine();
                if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                    activo = "Si";
                } else {
                    activo = "No";
                }
            }
                String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
                
                System.out.print("El estado del producto: ");
                System.out.println(a.Modificar("Productos.txt",antiguo,nuevo));
                System.out.print(" ha sido modoficado.");
        }
        
        if ("6".equals(opcion)) { // Crear Cliente
            a.descifrar("Clientes.txt");
            System.out.print("\nIntroduce el nombre del cliente: ");
            String nombreCliente = scan.nextLine();
            System.out.print("\nIntroduce el primer apellido: ");
            String primerApellido = scan.nextLine();
            System.out.print("\nIntroduce el segundo apellido: ");
            String segundoApellido = scan.nextLine();
            System.out.print("\nIntroduce la direccion completa: ");
            String direccion = scan.nextLine();
            System.out.print("\nIntroduce el numero de telefono: ");
            String numeroTelefono = scan.nextLine();
            
            Random r = new Random();
            int idCliente = r.nextInt(9000) + 1000;
            String nuevo = idCliente + ";" + nombreCliente + ";" + primerApellido + ";" + segundoApellido + ";" + direccion + ";" + numeroTelefono;
            
            System.out.println("El cliente: ");
            System.out.println(a.Agregar("Clientes.txt",nuevo));
            System.out.print("El cliente ha sido creado.");
            
            a.cifrar("Clientes.txt");

        }
        
        if ("7".equals(opcion)) { // Modificar Cliente
            a.descifrar("Clientes.txt");
            System.out.print("\nIntroduce el identificador del cliente que deseas modificar: \n");
            System.out.println(a.leer("Clientes.txt"));
            int idCliente;
            idCliente = Integer.parseInt(scan.nextLine());
            
            System.out.print("¿Como deseas modificarlo?\n");
            
            System.out.print("¿Quieres cambiar el nombre? Si / No\n");
            String cambiarNombre = scan.nextLine();
            String nombreAntiguo = "";
            String nombreNuevo = "";
            String primerAntiguo = "";
            String primerNuevo = "";
            String segundoAntiguo = "";
            String segundoNuevo = "";
            String direccionAntiguo = "";
            String direccionNuevo = "";
            String telefonoAntiguo = "";
            String telefonoNuevo = "";
            
            if( cambiarNombre.equals("si") || cambiarNombre.equals("Si") ) {
                nombreAntiguo =  a.leerVentas("Clientes.txt",idCliente,1);
                System.out.print("Introduce el nuevo nombre: ");
                nombreNuevo = scan.nextLine();
            } else if ( cambiarNombre.equals("no") || cambiarNombre.equals("No") ) {
                nombreAntiguo =  a.leerVentas("Clientes.txt",idCliente,1);
                nombreNuevo = nombreAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el primer apellido? Si / No\n");
            String cambiarApe1 = scan.nextLine();
            if( cambiarApe1.equals("si") || cambiarApe1.equals("Si") ) {
                primerAntiguo =  a.leerVentas("Clientes.txt",idCliente,2);
                System.out.print("Introduce el nuevo primer apellido: ");
                primerNuevo = scan.nextLine();
            } else if ( cambiarApe1.equals("no") || cambiarApe1.equals("No") ) {
                primerAntiguo =  a.leerVentas("Clientes.txt",idCliente,2);
                primerNuevo = primerAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el segundo apellido? Si / No\n");
            String cambiarApe2 = scan.nextLine();
            if( cambiarApe2.equals("si") || cambiarApe2.equals("Si") ) {
                segundoAntiguo =  a.leerVentas("Clientes.txt",idCliente,3);
                System.out.print("Introduce el nuevo segundo apellido: ");
                segundoNuevo = scan.nextLine();
            } else if ( cambiarApe2.equals("no") || cambiarApe2.equals("No") ) {
                segundoAntiguo =  a.leerVentas("Clientes.txt",idCliente,3);
                segundoNuevo = segundoAntiguo;
            }
            
            System.out.print("¿Quieres cambiar la direccion? Si / No\n");
            String cambiarDireccion = scan.nextLine();
            if( cambiarDireccion.equals("si") || cambiarDireccion.equals("Si") ) {
                direccionAntiguo =  a.leerVentas("Clientes.txt",idCliente,4);
                System.out.print("Introduce la nueva direccion: ");
                direccionNuevo = scan.nextLine();
            } else if ( cambiarDireccion.equals("no") || cambiarDireccion.equals("No") ) {
                direccionAntiguo =  a.leerVentas("Clientes.txt",idCliente,4);
                direccionNuevo = direccionAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el numero de telefono? Si / No\n");
            String cambiarTelefono = scan.nextLine();
            if( cambiarTelefono.equals("si") || cambiarTelefono.equals("Si") ) {
                telefonoAntiguo =  a.leerVentas("Clientes.txt",idCliente,5);
                System.out.print("Introduce el nuevo numero de telefono: ");
                telefonoNuevo = scan.nextLine();
            } else if ( cambiarTelefono.equals("no") || cambiarTelefono.equals("No") ) {
                telefonoAntiguo =  a.leerVentas("Clientes.txt",idCliente,5);
                telefonoNuevo = telefonoAntiguo;
            }
            
            
            String antiguo = "";
            String nuevo = "";
            
            antiguo = idCliente + ";" + nombreAntiguo + ";" + primerAntiguo + ";" + segundoAntiguo + ";" + direccionAntiguo + ";" + telefonoAntiguo;
            nuevo = idCliente + ";" + nombreNuevo + ";" + primerNuevo + ";" + segundoNuevo + ";" + direccionNuevo + ";" + direccionNuevo + ";" + telefonoNuevo;
  
            System.out.print("El cliente: ' " + antiguo + " ' ha sido modificado a:");
            System.out.println(a.Modificar("Clientes.txt",antiguo,nuevo));
            
            a.cifrar("Clientes.txt");
            
        }
        
        
        
    }

    if (Nivel < 2){
        if ("6".equals(opcion)) { // Eliminar venta
            System.out.print("\nIntroduce el identificador de la venta que deseas eliminar: \n");
            System.out.println(a.leer("Ventas.txt"));
            int idVenta;
            idVenta = Integer.parseInt(scan.nextLine());

            String borrar = "";
            String nombreAntiguo = "";;
            String productoAntiguo = "";
            nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
            productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);

            borrar = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
            System.out.print("La venta:  ");
            System.out.println(a.Eliminar("Ventas.txt",borrar));
            System.out.print(" ha sido eliminada.");
        }   
        
        if ("7".equals(opcion)) { // Crear usuario
            System.out.print("\nIntroduce el nombre del usuario: ");
            String nombreUsuario = scan.nextLine();
            System.out.print("\nIntroduce el cargo a asignar:\n");
            System.out.println("1- Administrador");
            System.out.println("2- Asistente");
            System.out.println("3- Vendedor");
            int nivelUser = Integer.parseInt(scan.nextLine());
            String nuevo = nombreUsuario + "-" + nivelUser;
            System.out.println("El usuario ");
            System.out.println(a.Agregar("Usuarios.txt",nuevo));
            System.out.print("El usuario ha sido creado.");
        }
        
        if ("8".equals(opcion)) { // Crear Cliente
            a.descifrar("Clientes.txt");
            System.out.print("\nIntroduce el nombre del cliente: ");
            String nombreCliente = scan.nextLine();
            System.out.print("\nIntroduce el primer apellido: ");
            String primerApellido = scan.nextLine();
            System.out.print("\nIntroduce el segundo apellido: ");
            String segundoApellido = scan.nextLine();
            System.out.print("\nIntroduce la direccion completa: ");
            String direccion = scan.nextLine();
            System.out.print("\nIntroduce el numero de telefono: ");
            String numeroTelefono = scan.nextLine();
            
            Random r = new Random();
            int idCliente = r.nextInt(9000) + 1000;
            String nuevo = idCliente + ";" + nombreCliente + ";" + primerApellido + ";" + segundoApellido + ";" + direccion + ";" + numeroTelefono;
            
            System.out.println("El cliente: ");
            System.out.println(a.Agregar("Clientes.txt",nuevo));
            System.out.print("El cliente ha sido creado.");
            
            a.cifrar("Clientes.txt");
            
        }
        
        if ("9".equals(opcion)) { // Modificar Cliente
            a.descifrar("Clientes.txt");
            System.out.print("\nIntroduce el identificador del cliente que deseas modificar: \n");
            System.out.println(a.leer("Clientes.txt"));
            int idCliente;
            idCliente = Integer.parseInt(scan.nextLine());
            
            System.out.print("¿Como deseas modificarlo?\n");
            
            System.out.print("¿Quieres cambiar el nombre? Si / No\n");
            String cambiarNombre = scan.nextLine();
            String nombreAntiguo = "";
            String nombreNuevo = "";
            String primerAntiguo = "";
            String primerNuevo = "";
            String segundoAntiguo = "";
            String segundoNuevo = "";
            String direccionAntiguo = "";
            String direccionNuevo = "";
            String telefonoAntiguo = "";
            String telefonoNuevo = "";
            
            if( cambiarNombre.equals("si") || cambiarNombre.equals("Si") ) {
                nombreAntiguo =  a.leerVentas("Clientes.txt",idCliente,1);
                System.out.print("Introduce el nuevo nombre: ");
                nombreNuevo = scan.nextLine();
            } else if ( cambiarNombre.equals("no") || cambiarNombre.equals("No") ) {
                nombreAntiguo =  a.leerVentas("Clientes.txt",idCliente,1);
                nombreNuevo = nombreAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el primer apellido? Si / No\n");
            String cambiarApe1 = scan.nextLine();
            if( cambiarApe1.equals("si") || cambiarApe1.equals("Si") ) {
                primerAntiguo =  a.leerVentas("Clientes.txt",idCliente,2);
                System.out.print("Introduce el nuevo primer apellido: ");
                primerNuevo = scan.nextLine();
            } else if ( cambiarApe1.equals("no") || cambiarApe1.equals("No") ) {
                primerAntiguo =  a.leerVentas("Clientes.txt",idCliente,2);
                primerNuevo = primerAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el segundo apellido? Si / No\n");
            String cambiarApe2 = scan.nextLine();
            if( cambiarApe2.equals("si") || cambiarApe2.equals("Si") ) {
                segundoAntiguo =  a.leerVentas("Clientes.txt",idCliente,3);
                System.out.print("Introduce el nuevo segundo apellido: ");
                segundoNuevo = scan.nextLine();
            } else if ( cambiarApe2.equals("no") || cambiarApe2.equals("No") ) {
                segundoAntiguo =  a.leerVentas("Clientes.txt",idCliente,3);
                segundoNuevo = segundoAntiguo;
            }
            
            System.out.print("¿Quieres cambiar la direccion? Si / No\n");
            String cambiarDireccion = scan.nextLine();
            if( cambiarDireccion.equals("si") || cambiarDireccion.equals("Si") ) {
                direccionAntiguo =  a.leerVentas("Clientes.txt",idCliente,4);
                System.out.print("Introduce la nueva direccion: ");
                direccionNuevo = scan.nextLine();
            } else if ( cambiarDireccion.equals("no") || cambiarDireccion.equals("No") ) {
                direccionAntiguo =  a.leerVentas("Clientes.txt",idCliente,4);
                direccionNuevo = direccionAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el numero de telefono? Si / No\n");
            String cambiarTelefono = scan.nextLine();
            if( cambiarTelefono.equals("si") || cambiarTelefono.equals("Si") ) {
                telefonoAntiguo =  a.leerVentas("Clientes.txt",idCliente,5);
                System.out.print("Introduce el nuevo numero de telefono: ");
                telefonoNuevo = scan.nextLine();
            } else if ( cambiarTelefono.equals("no") || cambiarTelefono.equals("No") ) {
                telefonoAntiguo =  a.leerVentas("Clientes.txt",idCliente,5);
                telefonoNuevo = telefonoAntiguo;
            }
            
            
            String antiguo = "";
            String nuevo = "";
            
            antiguo = idCliente + ";" + nombreAntiguo + ";" + primerAntiguo + ";" + segundoAntiguo + ";" + direccionAntiguo + ";" + telefonoAntiguo;
            nuevo = idCliente + ";" + nombreNuevo + ";" + primerNuevo + ";" + segundoNuevo + ";" + direccionNuevo + ";" + direccionNuevo + ";" + telefonoNuevo;
            nuevo = nuevo.toUpperCase();
            System.out.print("El cliente: ' " + antiguo + " ' ha sido modificado a:");
            System.out.println(a.Modificar("Clientes.txt",antiguo,nuevo));
            
            a.cifrar("Clientes.txt");
            
        }
        
        if ("10".equals(opcion)) { // Eliminar Cliente
            System.out.print("\nIntroduce el identificador del cliente que deseas eliminar: \n");
            System.out.println(a.leer("Clientes.txt"));
            int idCliente;
            idCliente = Integer.parseInt(scan.nextLine());

            String borrar = "";
            String nombreAntiguo = "";
            String primerAntiguo = "";
            String segundoAntiguo = "";
            String direccionAntiguo = "";
            String telefonoAntiguo = "";
            
            nombreAntiguo =  a.leerVentas("Ventas.txt",idCliente,1);
            primerAntiguo =  a.leerVentas("Ventas.txt",idCliente,2);
            segundoAntiguo = a.leerVentas("Ventas.txt",idCliente,3);
            direccionAntiguo = a.leerVentas("Ventas.txt",idCliente,4);
            telefonoAntiguo = a.leerVentas("Ventas.txt",idCliente,5);

            borrar = idCliente + ";" + nombreAntiguo + ";" + primerAntiguo + ";" + segundoAntiguo + ";" + direccionAntiguo + ";" + telefonoAntiguo;
            System.out.print("El cliente:  ");
            System.out.println(a.Eliminar("Clientes.txt",borrar));
            System.out.print(" ha sido eliminado."); 
       
        }

    }

    } //MAIN
    
} //CALCETINES

