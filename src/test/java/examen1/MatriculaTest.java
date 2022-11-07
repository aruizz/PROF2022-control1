package examen1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Vector;

public class MatriculaTest {

    @Mock
    private Asignatura asignatura;

    @Test
    public void testMatriculaVectorVacio() throws Exception{
        Matricula matricula = new Matricula(null);
        Assertions.assertThrows(Exception.class, ()->  matricula.getImporte());
    }

    @Test
    public void testMatriculaCorrectoMock() throws Exception{
        Asignatura asignatura = Mockito.mock(Asignatura.class);
        Vector<Asignatura> asignaturas = new Vector<>(3);
        asignaturas.add(asignatura);
        Matricula matricula = new Matricula(asignaturas);
        Mockito.when(asignatura.getImporte()).thenReturn(10.0);
        Double res = matricula.getImporte();
        Assertions.assertEquals(res, 10.0);
    }

    @Test
    public void testMatricula3() throws Exception{
        Asignatura asignatura = Mockito.mock(Asignatura.class);
        Vector<Asignatura> asignaturas = new Vector<>(3);
        asignaturas.add(asignatura);
        asignaturas.add(asignatura);
        asignaturas.add(asignatura);
        Matricula matricula = new Matricula(asignaturas);
        Mockito.when(asignatura.getImporte()).thenReturn(10.0).thenReturn(20.0).thenReturn(30.0);
        Double res = matricula.getImporte();
        Assertions.assertEquals(res, 60.0);
    }



}
