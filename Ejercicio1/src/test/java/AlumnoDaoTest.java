import com.um.tomas_grau.Alumno;
import com.um.tomas_grau.AlumnoDao;
import com.um.tomas_grau.excepciones.LegajoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

public class AlumnoDaoTest {
    private AlumnoDao alumnoDao;
    private Alumno alumno;

    @BeforeEach
    public void setUp() throws LegajoException {
        alumnoDao = new AlumnoDao();
        alumno = new Alumno("Juan","Perez");
        alumnoDao.create(1,alumno);
    }

    @Test
    public void testCreate() throws LegajoException {
        alumnoDao.create(2, alumno);
        Assertions.assertEquals(alumno, alumnoDao.get(1));
    }

    @Test
    public void testGet() {
        Alumno get = alumnoDao.get(1);
        Assertions.assertEquals(alumno, get);
    }

    @Test
    public void testUpdate() {
        alumnoDao.update(1, "Pedro", "Gomez");
        Alumno updated = alumnoDao.get(1);
        Assertions.assertEquals("Pedro", updated.getNombre());
        Assertions.assertEquals("Gomez", updated.getApellido());
    }

    @Test
    public void testDelete() {
        alumnoDao.delete(1);
        Assertions.assertNull(alumnoDao.get(1));
    }

    @Test
    public void testDeleteUserNonExist() {
        String deleted;
        deleted = alumnoDao.delete(2);
        Assertions.assertEquals("No existe ningun alumno con este numero de legajo",deleted);
    }
}
