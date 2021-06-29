package dao;

import modelo.Cyclist;
import util.Conexion;
import util.GenericDAO;

public class CyclistDAO extends Conexion<Cyclist> implements GenericDAO<Cyclist> {
	
	public CyclistDAO(){
		super(Cyclist.class);
	}

}
