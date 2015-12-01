package com.persistance;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import com.metier.TypeDechet;
import com.metier.Usager;
import java.sql.ResultSet;

public class TypeDechetDAO extends DAO<TypeDechet> {

	@Override
	public boolean create(TypeDechet obj) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean delete(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeDechet find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDechet find(String id) {
		// TODO Auto-generated method stub
		TypeDechet typeD = null;
		ResultSet rsTypeD = null; 
		String sql = "SELECT * FROM typedechet WHERE idTypeDechet='"+id+"';";
		try {			
			rsTypeD = con.createStatement().executeQuery(sql);
			if(rsTypeD.next())
			{
				typeD = new TypeDechet(rsTypeD.getString("idTypeDechet"), rsTypeD.getString("libelle"), rsTypeD.getDouble("tarif"));
			}				
		} catch (SQLException e1) {
			e1.printStackTrace();		
		}		
		return typeD;		
	}

	@Override
	public ArrayList<TypeDechet> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
