package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.metier.Facture;
import com.metier.Levee;

public class FactureDAO extends DAO<Facture> {

	@Override
	public boolean create(Facture obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sqlT= "SELECT * FROM facture "
				+ "WHERE idHabitation="+obj.getIdHabitation()+
				"AND moisF="+obj.getMoisF()+
				"AND anF="+obj.getAnF()+";";
		ResultSet rsLevee = null; 
		String sql = "INSERT INTO facture(idHabitation, moisF ,anF ,nomF) "
				+ "VALUES('"+obj.getIdHabitation()+"', "+obj.getMoisF()+", "+obj.getAnF()+", '"+obj.getNomF()+"')";
		/*try {
			if(rsLevee.next())
			{				
				Statement requete = con.createStatement();
				requete.executeUpdate(sql);
				result = true;
			}
			else
			{
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		return result;
	}

	@Override
	public boolean delete(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Facture find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Facture> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
