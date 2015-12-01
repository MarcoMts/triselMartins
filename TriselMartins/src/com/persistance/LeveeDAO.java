package com.persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.metier.Levee;
import com.metier.Usager;
import com.util.FichierTexte;
/**
 * Gestion de la DAO pour les levees
 * @author martins-m
 * @see leveeDAO
 */
public class LeveeDAO extends DAO<Levee> {


	@Override
	/**
	 * creation un objet levee
	 * @param objboolea
	 * 			objet levee
	 * @throws Exception
	 * @return
	 * 		return un boolean true si levee correct
	 */
	public boolean create(Levee obj) {
		// TODO Auto-generated method stub
		boolean test = false;
		java.sql.Date laDateSql = new java.sql.Date(obj.getLaDate().getTime());
		String sql = "INSERT INTO Levee(laDate,poids,idPoubelle) VALUES('" + laDateSql + "', " + obj.getPoids() +", '" + obj.getIdPoubelle() + "');";
		try {		
			Statement requete = con.createStatement();
			requete.executeUpdate(sql);
			test = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return test;
	}
	@Override
/**
 * suppression d'un objet levee
 * @param obj
 *   			objet levee
 * @throws Exception
 * @return
 * 		return un boolean true si levee supprimer
 */
	public boolean delete(Levee obj) {
		// TODO Auto-generated method stub
		boolean test = false;
		
		String sql = "DELETE FROM levee WHERE idLevee="+obj.getIdLevee()+";";
		try {
			con.createStatement().executeQuery(sql);
			test = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return test;
	}

	@Override
	public boolean update(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Levee find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Levee find(String id) {
		// TODO Auto-generated method stub
		Levee lev = null;
		ResultSet rsLevee = null; 
		String sql = "SELECT * FROM levee WHERE idLevee='"+id+"';";
		try {			
			
			rsLevee = con.createStatement().executeQuery(sql);
			if(rsLevee.next())
			{
				lev = new Levee(rsLevee.getInt("idLevee"), rsLevee.getDate("laDate"), rsLevee.getDouble("poids"), rsLevee.getString("idPoubelle"));
			}				
		} catch (SQLException e1) {
			e1.printStackTrace();		
		}		
		return lev;			
	}

	@Override
	public ArrayList<Levee> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
