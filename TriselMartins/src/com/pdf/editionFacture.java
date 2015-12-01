package com.pdf;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.persistance.FactureDAO;
public class editionFacture {

	private static double arrondiNDecimales(double x, int n)
	{
		double pow = Math.pow(10, n);
		return (Math.floor(x * pow)) / pow;
	}
	
	public static void genereFacture(Habitation hab, int mois, int an)
	{
		Double TVA = 0.2;
		Date dates = null;
		SimpleDateFormat dateFormat = null;
		SimpleDateFormat dateFormatEdite = null;
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		dateFormatEdite = new SimpleDateFormat("EEEEEEEE d MMMMMMMM yyyy");
		Date aujourdhui = new Date();
		try
		{
			dates = dateFormat.parse("01/"+mois+"/"+an);
			
		} catch (ParseException e){
			e.printStackTrace();
		} 
		String nomFichier=getNomFichier(hab, mois, an);
		Document document = new Document();
		try {

		PdfWriter.getInstance(document,new FileOutputStream ("FichiersFacture\\"+getMois(mois)+"\\"+nomFichier));
		
		document.open();
		Image image1 = Image.getInstance ("Logo.PNG");

		 document.add (image1);
		 
		 Paragraph entete = new Paragraph();
		 entete.setSpacingBefore(-180);
		
		// ajout d'un paragraphe au document
		 
		 Font font2 = new Font (Font.FontFamily.COURIER);
		 
		 Paragraph enteteT = new Paragraph("Facture du mois de "+getMois(mois)+"\n"+"Edité le "+dateFormatEdite.format(aujourdhui),font2);
		 //cell1.addElement(textTabPoubelle);
		 enteteT.setAlignment(Paragraph.ALIGN_RIGHT);
		 entete.add(enteteT);
	 
		 
		 document.add(entete);
		 
		 Paragraph adresse = new Paragraph();
		 adresse.setAlignment(Element.ALIGN_LEFT);
		 adresse.setSpacingBefore(130);
		 adresse.setIndentationLeft (350);
		 
		 adresse.add(hab.getUsager().getNom() + " "+hab.getUsager().getPrenom()+"\n");
		 adresse.add(hab.getAdresseRue()+"\n");
		 adresse.add(hab.getCodePostal() +" "+ hab.getAdresseVile());
		 
		 document.add(adresse);
		 
		 
		 Paragraph code = new Paragraph();
		 code.setAlignment(Element.ALIGN_LEFT);
		 code.setSpacingBefore(50);
		 
		 code.add("Code usager : "+hab.getUsager().getIdUser()+"\n");
		 code.add("Récapitulatif des pesées des poubelles au mois de : "+getMois(mois));
		 
		 document.add(code);
		 
		 
		
		 Paragraph textTabPoubelle = new Paragraph();
		 
		 DecimalFormat df = new DecimalFormat("0.00");
		 Double totalGeneral = 0.0;
		 
		 Font font1 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
		 
		 for(Poubelle p : hab.getLesPoubelles())
		 {
			 textTabPoubelle.setAlignment(Element.ALIGN_CENTER);
			 
			 Double totalPoubelle = 0.0;
			 Double totalHt = 0.0;
			 PdfPTable table = new PdfPTable(4);
			 table.setSpacingBefore(50);
			 
			 
			 textTabPoubelle.clear();
			// textTabPoubelle.add("Poubelle: "+p.getIdPoubelle()+" Nature des déchets: "+p.getNature().getLibelle(), FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 255,17)));
			 PdfPCell cell1 = new PdfPCell(new Paragraph("Poubelle: "+p.getIdPoubelle()+" Nature des déchets: "+p.getNature().getLibelle(),font1));
			 //cell1.addElement(textTabPoubelle);
			 cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			 cell1.setColspan(4);
			 
			 textTabPoubelle.clear();
			 textTabPoubelle.add("Date de pesée");
			 PdfPCell cell2 = new PdfPCell();
			 cell2.addElement(textTabPoubelle);
			 cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			
			 textTabPoubelle.clear();
			 textTabPoubelle.add("nombre de kg");
			 PdfPCell cell3 = new PdfPCell();
			 cell3.addElement(textTabPoubelle);
			 cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			 
			 textTabPoubelle.clear();
			 textTabPoubelle.add("prix HT au kg");
			 PdfPCell cell4= new PdfPCell();
			 cell4.addElement(textTabPoubelle);
			 cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
			 
			 textTabPoubelle.clear();
			 textTabPoubelle.add("total HT");
			 PdfPCell cell5= new PdfPCell();
			 cell5.addElement(textTabPoubelle);
			 cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			 
			 
			 table.addCell(cell1);
         	 table.addCell(cell2);
         	 table.addCell(cell3);
         	 table.addCell(cell4);
         	 table.addCell(cell5);
         	 
         	 if(p.getLesLevees(an, mois).size()>0)
         	 {
         	 for(Levee l : p.getLesLevees(an, mois))
         	 {
         		 totalHt = p.getNature().getTarif()*l.getPoids();
         		 
         		 textTabPoubelle.clear();
         		 textTabPoubelle.add(l.getLaDate().toString());
         		 PdfPCell cell6= new PdfPCell();
         		 cell6.addElement(textTabPoubelle);
         		 
         		 
         		 textTabPoubelle.clear();
         		 textTabPoubelle.add(l.getPoids().toString());
         		 PdfPCell cell7= new PdfPCell();
         	     cell7.addElement(textTabPoubelle);
         		 
         	     textTabPoubelle.clear();
        		 textTabPoubelle.add(p.getNature().getTarif().toString());
        		 PdfPCell cell8= new PdfPCell();
        		 cell8.addElement(textTabPoubelle);
        	     
        		 textTabPoubelle.clear();
        		 textTabPoubelle.add(totalHt.toString());
        		 PdfPCell cell9= new PdfPCell();
        		 cell9.addElement(textTabPoubelle);
        		 
    			 
    			 table.addCell(cell6);
             	 table.addCell(cell7);
             	 table.addCell(cell8);
             	 table.addCell(cell9);
    			 totalPoubelle = totalPoubelle + totalHt;
         	 }
         	 }
         	 
         	 textTabPoubelle.clear();
         	 textTabPoubelle.setAlignment(Element.ALIGN_RIGHT);
    		 textTabPoubelle.add("Total HT");
    		 PdfPCell cell10= new PdfPCell();
    		 cell10.addElement(textTabPoubelle);    	
         	 cell10.setColspan(3);
         	 
         	 
         	 textTabPoubelle.clear();
         	 textTabPoubelle.setAlignment(Element.ALIGN_CENTER);
         	 Double totalPoubelleT = arrondiNDecimales(totalPoubelle,2);
    		 textTabPoubelle.add(totalPoubelleT.toString());
    		 PdfPCell cell11= new PdfPCell();
    		 cell11.setBackgroundColor(BaseColor.LIGHT_GRAY);
    		 cell11.addElement(textTabPoubelle);  
    		     		 
         	 table.addCell(cell10);
         	 table.addCell(cell11);

         	 document.add(table);
         	totalGeneral = totalGeneral+totalPoubelle;
		 }
		 PdfPTable table = new PdfPTable(4);
		 table.setSpacingBefore(50);
		 Double montantTVA = totalGeneral*TVA;
		 Double totalTTC = totalGeneral+montantTVA;
		 
		 textTabPoubelle.clear();
		 textTabPoubelle.setAlignment(Element.ALIGN_RIGHT);
		 textTabPoubelle.add("Total général HT");
		 PdfPCell cell12= new PdfPCell();
		 cell12.addElement(textTabPoubelle);
		 
		 cell12.setColspan(3); 
		 
		 Double totalGeneralT = arrondiNDecimales(totalGeneral,2);
		 textTabPoubelle.clear();
		 textTabPoubelle.setAlignment(Element.ALIGN_CENTER);
		 textTabPoubelle.add(totalGeneralT.toString());
		 PdfPCell cell13= new PdfPCell();
		 cell13.addElement(textTabPoubelle);
		 
		 
		 textTabPoubelle.clear();
		 textTabPoubelle.setAlignment(Element.ALIGN_RIGHT);
		 textTabPoubelle.add("Montant TVA");
		 PdfPCell cell14= new PdfPCell();
		 cell14.addElement(textTabPoubelle);
		 
		 
		 cell14.setColspan(3);
		 
		 Double montantTVAT = arrondiNDecimales(montantTVA,2);
		 
		 textTabPoubelle.clear();
		 textTabPoubelle.setAlignment(Element.ALIGN_CENTER);
		 textTabPoubelle.add(montantTVAT.toString());
		 PdfPCell cell15= new PdfPCell();
		 cell15.addElement(textTabPoubelle);
		 
		 textTabPoubelle.clear();
		 textTabPoubelle.setAlignment(Element.ALIGN_RIGHT);
		 textTabPoubelle.add("Total TTC");
		 PdfPCell cell16= new PdfPCell();
		 cell16.addElement(textTabPoubelle);
		 	 
		 cell16.setColspan(3);
		 
		 Double totalTTCT = arrondiNDecimales(totalTTC,2);
		 
		 textTabPoubelle.clear();
		 textTabPoubelle.setAlignment(Element.ALIGN_CENTER);
		 textTabPoubelle.add(totalTTCT.toString());
		 PdfPCell cell17= new PdfPCell();
		 cell17.setBackgroundColor(BaseColor.LIGHT_GRAY);

		 cell17.addElement(textTabPoubelle);
         
		 table.addCell(cell12);
     	 table.addCell(cell13);
     	 table.addCell(cell14);
     	 table.addCell(cell15);
         table.addCell(cell16);
    	 table.addCell(cell17);
    	 
    	 document.add(table);
		// fermeture du document, important pour transférer les données // au 

		document.close ();

		// affichage sous adobe 

		Runtime.getRuntime().exec("explorer.exe " + nomFichier);

		} catch (DocumentException e) {

		e.printStackTrace ();

		} catch (FileNotFoundException e) {

		e.printStackTrace ();

		}

		catch (IOException ex) { 

		ex.printStackTrace();

		}
		Facture f = new Facture(an, nomFichier,hab.getIdHabitation(),mois);
		FactureDAO fDAO = new FactureDAO();
		if(fDAO.create(f))
		{
			System.out.println("Facture enregistrée");
			
		}
		else
		{
			System.out.println("Facture non enregistrée");
			
		}
		
	}
	public static String getMois(int mois)
	{
		String tabMois[] = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
		return tabMois[mois-1];
	}
	public static String getNomFichier(Habitation hab, int mois, int an)
	{
		
		return hab.getIdHabitation()+"-"+hab.getUsager().getIdUser()+"-Facture-"+getMois(mois)+"-"+an+".pdf";
	}
}
