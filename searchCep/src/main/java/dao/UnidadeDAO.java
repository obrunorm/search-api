package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bd.Unidade;

public class UnidadeDAO {

	EntityManagerFactory sf = Persistence.createEntityManagerFactory("EmpresaGames");

	EntityManager em2 = sf.createEntityManager();
	
	private int cep; // Adicionando o campo cep
    private Unidade unidadeEncontrada; // Adicionando o campo unidadeEncontrada

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    public Unidade getUnidadeEncontrada() {
        return unidadeEncontrada;
    }

    public void setUnidadeEncontrada(Unidade unidadeEncontrada) {
        this.unidadeEncontrada = unidadeEncontrada;
    }

    

	private List<Unidade> todosUnidades= new ArrayList<Unidade>();

	@SuppressWarnings("unchecked")
	public List<Unidade> getTodosUnidades() {
		return em2.createQuery("From Unidade").getResultList();
	}

	public void setTodosUnidades(List<Unidade> todosUnidades) {
		this.todosUnidades = todosUnidades;
	}

	private Unidade unidade = new Unidade();
	private static Unidade unidadeId = new Unidade();

	public Unidade getUnidadeId() {
		System.out.println("ID DO UNIDADE NO GET:" + unidadeId.getId());		
		return em2.find(Unidade.class, unidadeId.getId());
	}

	@SuppressWarnings("static-access")
	public void setUnidadeId(Unidade unidadeId) {
		this.unidadeId = unidadeId;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String operacao;
	public List<Unidade> listaUnidades() {
		return todosUnidades;
	}


	//CONSULTAR
	public void consultarUnidadesId() {
		System.out.println("[ENTROU NO CONSULTA UNIDADE]");
		em2.getTransaction().begin();
		Query p = em2.createQuery("From Unidade");
		@SuppressWarnings("unchecked") 
		List<Unidade> unidades = p.getResultList();

		for (Unidade c : unidades) {
			if(unidade.getId() == c.getId()) {
				unidadeId = em2.find(Unidade.class, unidade.getId());
				System.out.println("ID DA UNIDADE:" + unidadeId.getId());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Unidade> consultarTodosUnidades() {
		System.out.println("[Entrou]");
		return em2.createQuery("From Unidade").getResultList();
	}

	//CADASTRAR
	public void cadastrarUnidades() {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();
		// Cadastrar Unidades

		unidade.setCnes(unidade.getCnes());

		unidade.setEstabelecimento(unidade.getEstabelecimento());
		
		unidade.setCepInicio(unidade.getCepInicio());
		
		unidade.setCepFim(unidade.getCepFim());


		em2.persist(unidade);
		em2.getTransaction().commit();
		em2.close();

		System.out.println("Unidade Cadastrada\n");
	}
	
	//ALTERAR
	public void alteraUnidade () {
	    System.out.println("[Entrou]\n");
	    em2.getTransaction().begin();

	    // Encontrar a unidade no banco de dados pelo ID
	    Unidade unidadePersistida = em2.find(Unidade.class, unidade.getId());

	    if (unidadePersistida != null) {
	        // Atualizar os atributos da unidade persistida com os novos valores
	        unidadePersistida.setCnes(unidade.getCnes());
	        unidadePersistida.setEstabelecimento(unidade.getEstabelecimento());
	        unidadePersistida.setCepInicio(unidade.getCepInicio());
	        unidadePersistida.setCepFim(unidade.getCepFim());

	        // Mesclar (atualizar) a unidade persistida no banco de dados
	        em2.merge(unidadePersistida);
	        em2.getTransaction().commit();
	        em2.close();

	        System.out.println("Unidade Alterada\n");
	    } else {
	        System.out.println("Unidade não encontrada para alteração");
	    }
	}


	//EXCLUIR
	public void excluiUnidadeUnico () {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();
		Query p = em2.createQuery("From Unidade");
		@SuppressWarnings("unchecked") 
		List<Unidade> unidades = p.getResultList();

		for (Unidade c : unidades) {
		    if(c.getId() == unidade.getId()) {
		        // Excluir Unidade
		        System.out.println("Unidade Removida\n");
		        em2.remove(c); // Remover a unidade atual 'c'
		        em2.getTransaction().commit();
		        em2.close();                
		        break;
		    }
		}
	}
	
	public void excluiTodosUnidades () {
		System.out.println("[Entrou]\n");
		em2.getTransaction().begin();
		int quant = em2.createQuery("Delete From Unidade").executeUpdate();		
		em2.getTransaction().commit();
		System.out.println("Quantidade de Unidades Removidas: " + quant);
		System.out.println("Unidades Removidas com Sucesso!\n");
	}

	//CONSULTAR CEP
	 public void buscarUnidadePorCep() {
	        this.unidadeEncontrada = null; // Reinicializa a unidade encontrada

	        // Consulta todas as unidades
	        List<Unidade> unidades = em2.createQuery("SELECT u FROM Unidade u", Unidade.class).getResultList();

	        // Itera sobre cada unidade para verificar se o CEP está dentro da faixa
	        for (Unidade unidade : unidades) {
	            if (cep >= unidade.getCepInicio() && cep <= unidade.getCepFim()) {
	                this.unidadeEncontrada = unidade; // Define a unidade encontrada
	                break; // Sai do loop assim que encontrar uma unidade
	            }
	        }
	    }	
}
