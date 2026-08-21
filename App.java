import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceCuenta service = new ServiceCuenta();
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar cuentas Ahorro");
            System.out.println("2. Listar cuentas Corriente");
            System.out.println("3. Crear cuenta Ahorro");
            System.out.println("4. Crear cuenta Corriente");
            System.out.println("5. Obtener información de una cuenta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    for (Cuenta c : service.listarCuentas()) {
                        if (c instanceof Ahorro) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 2:
                    for (Cuenta c : service.listarCuentas()) {
                        if (c instanceof Corriente) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Número de cuenta: ");
                    String numA = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniA = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoA = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha creación: ");
                    String fecha = sc.nextLine();
                    service.crearCuenta(new Ahorro(numA, dniA, saldoA, fecha));
                    break;
                case 4:
                    System.out.print("Número de cuenta: ");
                    String numC = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniC = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoC = sc.nextDouble();
                    System.out.print("Impuesto: ");
                    double imp = sc.nextDouble();
                    service.crearCuenta(new Corriente(numC, dniC, saldoC, imp));
                    break;
                case 5:
                    System.out.print("Ingrese número de cuenta: ");
                    String buscar = sc.nextLine();
                    Cuenta cuenta = service.obtenerCuenta(buscar);
                    if (cuenta != null) {
                        System.out.println(cuenta);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
