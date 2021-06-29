package dao;

import modelo.Country;
import util.Conexion;
import util.GenericDAO;

public class CountryDAO extends Conexion<Country> implements GenericDAO<Country> {

	public CountryDAO(){
		super(Country.class);
	}
}
