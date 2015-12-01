package com.persistance;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;



public class PoubelleDAO extends DAO<Poubelle> {

	@Override
	public boolean create(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Poubelle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Poubelle find(String id) {
		// TODO Auto-generated method stub
		Poubelle p = null;
		TypeDechet typeD = null;
		Levee lv = null;
		ResultSet rsPoubelle = null;
		ResultSet rsLevee = null;
		LeveeDAO lvDAO = new LeveeDAO();
		TypeDechetDAO tdDAO = new TypeDechetDAO();
		String sqlPoubelle = "SELECT * FROM poubelle WHERE idPoubelle='"+id+"';";		
		try {	
			
			rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
			if (rsPoubelle.next())	
			{
					String sqlLevee = "SELECT * FROM levee WHERE idPoubelle='"+id+"';";
									
					rsLevee = con.createStatement().executeQuery(sqlLevee);
					
					typeD = tdDAO.find(rsPoubelle.getString("idTypeDechet"));
					p = new Poubelle(rsPoubelle.getString("idPoubelle"),typeD,rsPoubelle.getString("idHabitation"));
				while (rsLevee.next()) 
				{
					
					lv = new Levee(rsLevee.getInt("idLevee"), rsLevee.getDate("laDate"), rsLevee.getDouble("poids"), rsLevee.getString("idPoubelle"));
					p.ajoutLevee(lv);
				}
			}
			}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public ArrayList<Poubelle> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
