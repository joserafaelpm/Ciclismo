package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	//bi-directional many-to-one association to Cyclist
	@OneToMany(mappedBy="countryBean")
	private List<Cyclist> cyclists;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="countryBean")
	private List<Team> teams;

	public Country() {
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
		cyclist.setCountryBean(this);

		return cyclist;
	}

	public Cyclist removeCyclist(Cyclist cyclist) {
		getCyclists().remove(cyclist);
		cyclist.setCountryBean(null);

		return cyclist;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setCountryBean(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setCountryBean(null);

		return team;
	}

}