package bd;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnidadeTest {
    
    @Test
    public void testUnidade() {
        Unidade unidade = new Unidade();
        // Defina os valores necessários para a unidade
        unidade.setId(1);
        unidade.setCnes("1234567");
        unidade.setEstabelecimento("Hospital");
        unidade.setCepInicio(10000);
        unidade.setCepFim(20000);
        
        // Verifique se os valores foram atribuídos corretamente
        assertEquals(1, unidade.getId());
        assertEquals("1234567", unidade.getCnes());
        assertEquals("Hospital", unidade.getEstabelecimento());
        assertEquals(10000, unidade.getCepInicio());
        assertEquals(20000, unidade.getCepFim());
    }
}
