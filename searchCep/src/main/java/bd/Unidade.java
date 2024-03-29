/*CLASSE CLIENTE*/
package bd;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Unidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cnes;
    private String estabelecimento;
    @Column(unique = true)
    private int cepInicio;
    @Column(unique = true)
    private int cepFim;	
	
	//Get e Set dos Valores	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getCnes() {
		return cnes;
	}
	public void setCnes(String cnes) {
		this.cnes = cnes;
	}
	public String getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public int getCepInicio() {
		return cepInicio;
	}
	public void setCepInicio(int cepInicio) {
		this.cepInicio = cepInicio;
	}
	public int getCepFim() {
		return cepFim;
	}
	public void setCepFim(int cepFim) {
		this.cepFim = cepFim;
	}
	
	
	//Metodos especiais	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		return id == other.id;
	}
}
