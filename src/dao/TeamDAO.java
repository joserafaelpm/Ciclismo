package dao;

import modelo.Team;
import util.Conexion;
import util.GenericDAO;

public class TeamDAO extends Conexion<Team> implements GenericDAO<Team> {

	public TeamDAO(){
		super(Team.class);
	}
	
}
