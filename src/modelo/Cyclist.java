package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cyclist database table.
 * 
 */
@Entity
@NamedQuery(name="Cyclist.findAll", query="SELECT c FROM Cyclist c")
public class Cyclist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String email;

	private String name;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country")
	private Country countryBean;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team")
	private Team teamBean;

	public Cyclist() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountryBean() {
		return this.countryBean;
	}

	public void setCountryBean(Country countryBean) {
		this.countryBean = countryBean;
	}

	public Team getTeamBean() {
		return this.teamBean;
	}

	public void setTeamBean(Team teamBean) {
		this.teamBean = teamBean;
	}

}