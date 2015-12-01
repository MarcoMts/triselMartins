package com.persistance;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.metier.Usager;
import java.sql.ResultSet;

public class UsagerDAO extends DAO<Usager> {

	@Override
	public boolean create(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usager find(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Usager find(String id) {
		// TODO Auto-generated method stub
		Usager user = null;
		ResultSet rsUser = null; 
		String sql = "SELECT * FROM usager WHERE idUsager='"+id+"';";
		try {			
			rsUser = con.createStatement().executeQuery(sql);
			if(rsUser.next())
			{
				user = new Usager(rsUser.getString("idUsager"), rsUser.getString("nom"), rsUser.getString("prenom"), rsUser.getString("nomUser"),rsUser.getString("motDePasse"),rsUser.getString("AdrRue"),rsUser.getString("Ville") ,rsUser.getString("CP"));
			}				
		} catch (SQLException e1) {
			e1.printStackTrace();		
		}		
		return user;		
	}

	@Override
	public ArrayList<Usager> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
