package com.persistance;
import java.util.ArrayList;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

import java.sql.ResultSet;
import java.sql.SQLException;
public class HabitationDAO extends DAO<Habitation> {

	@Override
	public boolean create(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Habitation find(int id) {
		// TODO Auto-generated method stub
		return null;	
	}

	@Override
	public Habitation find(String id) {
		// TODO Auto-generated method stub
		Habitation hab = null;
		Poubelle pb = null;
		Usager us = null;
		Levee lev = null;
		TypeDechet typeD = null;
		ResultSet rsPoubelle = null;
		ResultSet rshabitation = null;
		ResultSet rsLevee = null;
		LeveeDAO lvDAO = new LeveeDAO();
		UsagerDAO usDAO = new UsagerDAO();
		TypeDechetDAO tdDAO = new TypeDechetDAO();
		String sqlHabitation = "SELECT * FROM habitation WHERE idHabitation='"+id+"';";		
		try {	
			
			rshabitation = con.createStatement().executeQuery(sqlHabitation);
			if (rshabitation.next())	
			{
					String sqlPoubelle = "SELECT * FROM poubelle WHERE idHabitation='"+id+"';";
									
					rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
					
					us = usDAO.find(rshabitation.getString("idUsager"));
					
					hab = new Habitation(rshabitation.getString("idHabitation"), rshabitation.getString("adresseRue"), rshabitation.getString("codePostal"), rshabitation.getString("adresseVille"), us );
							
				while (rsPoubelle.next()) 
				{
					String idPoubelle = rsPoubelle.getString("idPoubelle");
					
					
					typeD = tdDAO.find(rsPoubelle.getString("idTypeDechet"));
					pb = new Poubelle(idPoubelle, typeD,rsPoubelle.getString("idHabitation"));
					hab.ajoutPoubelle(pb);
					
					String sqlLevee = "SELECT * FROM levee WHERE idPoubelle='"+idPoubelle+"';";
					rsLevee = con.createStatement().executeQuery(sqlLevee);
					while(rsLevee.next())
					{
						lev = new Levee(rsLevee.getInt("idlevee"),rsLevee.getDate("laDate"), rsLevee.getDouble("poids"), rsLevee.getString("idPoubelle"));
						pb.ajoutLevee(lev);
						
					}
					
					
				}
			}
			}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return hab;
	}

	@Override
	public ArrayList<Habitation> retrieve() {
		// TODO Auto-generated method stub
		ArrayList<Habitation> LesHabitations = new ArrayList<Habitation>();
		ResultSet rsHab = null;
		Habitation hab;
		HabitationDAO habDAO = new HabitationDAO();
		String sql = "SELECT * FROM habitation";
	try{
		rsHab = con.createStatement().executeQuery(sql);
		while (rsHab.next())
		{
			hab = habDAO.find(rsHab.getString("idHabitation"));
			LesHabitations.add(hab);
		}

	}
	catch (SQLException e) { 
	}
	return LesHabitations;
	}

}
