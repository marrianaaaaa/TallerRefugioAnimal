package modelo.servicios;

import excepcion.MascotaNoEncontradaException;
import modelo.Mascota;

/**
 * Servicio para registrar la vacunación de mascotas.
 *
 * Mantiene el registro de qué mascotas han sido vacunadas. Es importante
 * vacunar antes de adoptar, por razones de salud.
 *
 * Concepto: Manejo de estado (boolean vacunada)
 * Cada mascota tiene un atributo booleano que indica si fue vacunada.
 *
 * @author franc
 */
public class VacunacionServicio {

    /**
     * Registra la vacunación de una mascota.
     *
     * Validaciones:
     * - La mascota debe existir en el refugio
     * - Si ya estaba vacunada, retorna false
     * - Si no estaba vacunada, la marca como vacunada y retorna true
     *
     * Excepciones lanzadas:
     * - MascotaNoEncontradaException: si el ID no existe
     *
     * Ejemplo de uso:
     *   VacunacionServicio vacunacion = new VacunacionServicio();
     *
     *   try {
     *       boolean vacunado = vacunacion.vacunar(mascotas, 108);
     *
     *       if (vacunado) {
     *           System.out.println("Mascota vacunada correctamente");
     *       } else {
     *           System.out.println("Mascota ya estaba vacunada");
     *       }
     *   } catch (MascotaNoEncontradaException e) {
     *       System.out.println("Error: " + e.getMessage());
     *   }
     *
     * @param mascotas array de mascotas del refugio
     * @param id identificación de la mascota a vacunar
     * @return true si se vacunó, false si ya estaba vacunada
     * @throws MascotaNoEncontradaException si no existe mascota con ese ID
     */
    public boolean vacunar(Mascota[] mascotas, int id) throws MascotaNoEncontradaException {
        // TODO ESTUDIANTE 11: implementar el registro de vacunación.
        // Pasos:
        // 1. Buscar la mascota con buscar(mascotas, id)
        // 2. SI mascota == null:
        //    - LANZAR new MascotaNoEncontradaException("Mascota no encontrada")
        // 3. SI mascota.isVacunada() == true:
        //    - RETORNAR false (ya estaba vacunada)
        // 4. SINO:
        //    - mascota.setVacunada(true)
        //    - RETORNAR true (se vacunó correctamente)
        
        if (mascotas == null){
            MascotaNoEncontradaException e
            System.out.println("Mascota no encontrada");
           return false;
        } if (mascotas.isVacunada() == true){
              System.out.println("La mascota ya se encuentra vacunada");
              return false;
        } else {
           }if (mascotas.isVacunada() == false){
              mascotas.isVacunada(true);
              System.out.println("Se vacunó correctamente");
              return true;
           }  
        }
    }

    /**
     * Cuenta cuántas mascotas NO han sido vacunadas aún.
     *
     * Importante: Cuenta mascotas SIN VACUNAR (!vacunada).
     * Para contar vacunadas, usar lógica inversa.
     *
     * @param mascotas array de mascotas
     * @return cantidad de mascotas que no han sido vacunadas
     */
    public int contarVacunadas(Mascota[] mascotas) {
        if (mascotas == null) {
            return 0;
        }
        
        int cantidad = 0;
        for (Mascota mascota : mascotas) {
            // Contar si existe Y NO está vacunada
            if (mascota != null && !mascota.isVacunada()) {
                cantidad++;
            }
        }
        return cantidad;
    }
    
    /**
     * Busca una mascota por ID (método privado para uso interno).
     *
     * @param mascotas array donde buscar
     * @param id identificación
     * @return la mascota encontrada, o null si no existe
     */
    private Mascota buscar(Mascota[] mascotas, int id) {
        if (mascotas == null) {
            return null;
        }
        for (Mascota mascota : mascotas) {
            if (mascota != null && mascota.getIdentificacion() == id) {
                return mascota;
            }
        }
        return null;
    }
}