package dao;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import bd.Unidade;

public class UnidadeDAOTest {

    @Test
    public void testConsultarTodosUnidades() {
        UnidadeDAO dao = new UnidadeDAO();
        List<Unidade> unidades = dao.consultarTodosUnidades();
        assertNotNull(unidades);
        assertFalse(unidades.isEmpty());
    }

    @Test
    public void testConsultarUnidadesId() {
        UnidadeDAO dao = new UnidadeDAO();
        // Defina um ID válido para teste
        int id = 13;
        dao.getUnidade().setId(id);
        dao.consultarUnidadesId();
        assertNotNull(dao.getUnidadeId());
    }

    @Test
    public void testCadastrarUnidades() {
        UnidadeDAO dao = new UnidadeDAO();
        Unidade unidade = new Unidade();
        // Defina os valores da unidade para teste
        unidade.setCnes("1234567");
        unidade.setEstabelecimento("Hospital");
        unidade.setCepInicio(10000);
        unidade.setCepFim(20000);
        dao.setUnidade(unidade);
        dao.cadastrarUnidades();
        assertNotNull(dao.getUnidade().getId());
    }
    
    @Test
    public void testBuscarUnidadePorCep() {
        UnidadeDAO dao = new UnidadeDAO();
        // Defina um valor de CEP válido para teste
        int cep = 15000;
        dao.setCep(cep);
        dao.buscarUnidadePorCep();
        assertNotNull(dao.getUnidadeEncontrada());
    }

    @Test
    public void testAlterarUnidade() {
        UnidadeDAO dao = new UnidadeDAO();
        Unidade unidade = new Unidade();
        // Defina os valores da unidade para teste
        unidade.setId(1); // Suponha que esta é uma ID existente no banco de dados
        unidade.setCnes("1234567");
        unidade.setEstabelecimento("Hospital Atualizado");
        unidade.setCepInicio(10000);
        unidade.setCepFim(20000);
        dao.setUnidade(unidade);
        dao.alteraUnidade();
        // Verifique se a unidade foi alterada com sucesso, talvez consultando-a novamente do banco de dados
    }

    @Test
    public void testExcluirUnidadeUnico() {
        UnidadeDAO dao = new UnidadeDAO();
        Unidade unidade = new Unidade();
        // Defina um ID válido para teste
        int id = 1;
        unidade.setId(id);
        dao.setUnidade(unidade);
        dao.excluiUnidadeUnico();
        // Verifique se a unidade foi excluída com sucesso, talvez consultando-a novamente do banco de dados
    }

    @Test
    public void testExcluirTodosUnidades() {
        UnidadeDAO dao = new UnidadeDAO();
        dao.excluiTodosUnidades();
        // Verifique se todas as unidades foram excluídas com sucesso, talvez contando quantas unidades existem no banco de dados
    }
}
