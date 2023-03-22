package com.tireshoppingmall.home.admin.tire;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tireshoppingmall.home.admin.auth.AuthDTO;


@Controller
public class AdminTireController {
	
	@Autowired
	TireDAO tDAO;
	
	private boolean tireFirstReq;
	private boolean tireDiscountRateFirstReq;
	private boolean tireCharacteristicsFirstReq;

	public AdminTireController() {
		tireFirstReq=true;
		tireDiscountRateFirstReq=true;
		tireCharacteristicsFirstReq=true;
	}
	
	
	//admin.tire.go
	@RequestMapping(value = "/admin.tire.go", method = RequestMethod.GET)
	public String tireGo(HttpServletRequest req) {

		if (tireFirstReq) {
			tDAO.calcAllTireCount();
			tireFirstReq = false;
		}	
		
		TireDTO.TirePagsing(req);
		tDAO.getAllTireGroup(1,req);

	
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire.jsp");
		return "admin/master";
	}
	//admin.tire.search.do
	@RequestMapping(value = "/admin.tire.search.do", method = RequestMethod.GET)
	public String searchTireDo(HttpServletRequest req,TireDTO tDTO) {
		
		tDAO.tirePasing(tDTO, req);
		tDAO.getAllTireGroup(1,req);
		
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire.jsp");
		return "admin/master";
	}
	
	//페이징 췌인징
	@RequestMapping(value = "/tire.page.change", method = RequestMethod.GET)
	public String Paging(HttpServletRequest req, @RequestParam int p) {
		
		tDAO.getAllTireGroup(p, req);
		
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire.jsp");
		return "admin/master";
	}

	//admin.tire.reg.go
	@RequestMapping(value = "/admin.tire.reg.go", method = RequestMethod.GET)
	public String tireRegGo(HttpServletRequest req) {
		
		
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire_reg.jsp");
		return "admin/master";
	}
	//admin.tire.reg.do
	@RequestMapping(value = "/admin.tire.reg.do", method = RequestMethod.GET)
	public String tireRegDo(HttpServletRequest req,TireDTO tDTO) {
		
		tDAO.tireRegDo(tDTO,req);
		
		
		TireDTO.TirePagsing(req);
		tDAO.getAllTireGroup(1,req);
			
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire.jsp");
		return "admin/master";
	}
	
	
	
	
	//admin.tire.delete.go
	@RequestMapping(value = "/admin.tireGroup.delete.go", method = RequestMethod.GET)
	public String tireGroupDeleteGo(HttpServletRequest req,TireDTO tg) {	
		
		tDAO.deleteTireGroup(req,tg);
		TireDTO.TirePagsing(req);
		tDAO.getAllTireGroup(1,req);
			
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire.jsp");
		return "admin/master";
	}
	
	
	
	
	
	
	//admin.tire.brand.go
	@RequestMapping(value = "/admin.tire.brand.go", method = RequestMethod.GET)
	public String tireBrandGo(HttpServletRequest req) {
		

		tDAO.getTireBrand(req);

		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire_brand.jsp");
		return "admin/master";
	}
	//admin.tire.brand.delete.go
	@RequestMapping(value = "/admin.tire.brand.delete.go", method = RequestMethod.GET)
	public String tireBrandDeleteGo(HttpServletRequest req,TireDTO tb) {
		

		tDAO.deleteTireBrand(req,tb);
		tDAO.getTireBrand(req);
		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire_brand.jsp");
		return "admin/master";
	}
	
	
	
	
	
	
	
	//admin.tire.discount.go
	@RequestMapping(value = "/admin.tire.discount.go", method = RequestMethod.GET)
	public String tireDiscountGo(HttpServletRequest req) {
		
		

		if (tireDiscountRateFirstReq) {
			tDAO.calcAllTireCount();
			tireDiscountRateFirstReq = false;
		}	
		

		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire_discount.jsp");
		return "admin/master";
	}
	
	//admin.tire.charicteristic.go
	@RequestMapping(value = "/admin.tire.charicteristic.go", method = RequestMethod.GET)
	public String tireCharicteristicGo(HttpServletRequest req) {
		
		

		if (tireCharacteristicsFirstReq) {
			tDAO.calcAllTireCount();
			tireCharacteristicsFirstReq = false;
		}	
		

		req.setAttribute("subMenuPage", "tire/tire_subMenu.jsp");
		req.setAttribute("contentPage", "tire/tire_charicteristic.jsp");
		return "admin/master";
	}
	
	
}
