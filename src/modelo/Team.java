package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	//bi-directional many-to-one association to Cyclist
	@OneToMany(mappedBy="teamBean")
	private List<Cyclist> cyclists;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country")
	private Country countryBean;

	public Team() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cyclist> getCyclists() {
		return this.cyclists;
	}

	public void setCyclists(List<Cyclist> cyclists) {
		this.cyclists = cyclists;
	}

	public Cyclist addCyclist(Cyclist cyclist) {
		getCyclists().add(cyclist);
		cyclist.setTeamBean(this);

		return cyclist;
	}

	public Cyclist removeCyclist(Cyclist cyclist) {
		getCyclists().remove(cyclist);
		cyclist.setTeamBean(null);

		return cyclist;
	}

	public Country getCountryBean() {
		return this.countryBean;
	}

	public void setCountryBean(Country countryBean) {
		this.countryBean = countryBean;
	}

}