import java.util.List;

public interface IServiceCuenta {
    List<Cuenta> listarCuentas();
    Cuenta obtenerCuenta(String numeroCuenta);
    void crearCuenta(Cuenta cuenta);
}
