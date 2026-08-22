import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta implements IServiceCuenta {
    private List<Cuenta> cuentas = new ArrayList<>();

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta obtenerCuenta(String numeroCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(numeroCuenta)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}
