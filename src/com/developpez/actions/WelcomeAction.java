package com.developpez.actions;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceAncien;
import ili.jai.PersistanceAncienImp;
import ili.jai.PersistanceEntreprise;
import ili.jai.PersistancePromotion;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;
import ili.jai.model.Entreprise;

public class WelcomeAction extends ActionSupport{
	private ServicePersistance sp;
	ServletContext context = ServletActionContext.getServletContext();

	private PersistancePromotion sppromo =(PersistancePromotion) context.getAttribute("sppromo");
	private PersistanceEntreprise spentreprise =(PersistanceEntreprise) context.getAttribute("spentreprise");	
	private PersistanceAncien spancien = new PersistanceAncienImp();
	public String execute() throws Exception {

		//Promotion p =sppromo.persiste(annee, libelle);
		System.out.println("promo list1");
		ServletContext context = ServletActionContext.getServletContext();

		sp=new ServicePersistanceImp();
		sppromo =sp.servicePersistancePromotion();	
		context.setAttribute("listPromos", sppromo.tous());
		spentreprise =sp.servicePersistanceEntreprise();	
		context.setAttribute("listEntreprises", spentreprise.tous());
				System.out.println("promo list2");

			
			return "success";
			
		}
	
	
	
	public String execute2() throws Exception {

		System.out.println("=======>" + spancien.tous().get(0).getPromotion().getNom());
		Entreprise e =spancien.tous().get(0).getEntrepriseStageM2();
		System.out.println("==>"+e.getNom());
		context.setAttribute("listAnciens", spancien.tous());
		
		return "success";
			
		
			
		}
}
