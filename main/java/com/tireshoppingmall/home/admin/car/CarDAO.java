package com.tireshoppingmall.home.admin.car;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.tireshoppingmall.home.admin.car.CarDTO;
import com.tireshoppingmall.home.admin.car.CarOption;
import com.tireshoppingmall.home.admin.car.SearchCarDTO;
@Service
public class CarDAO {
	

	@Autowired
	private ServletContext servletContext;


	@Autowired
	private SqlSession ss;
	

	private AdminCarMapper mapper;
	
	
	@Autowired
	private CarOption co;
	
	
	
	private int allCarCount;
	
	public int getAllCarCount() {
		return allCarCount;
	}

	public void setAllCarCount(int allCarCount) {
		this.allCarCount = allCarCount;
	}

	
	

	
//	public void getAllCar(Model m) {
//	mapper = ss.getMapper(AdminCarMapper.class);
//	m.addAttribute("cars", ss.getMapper(AdminCarMapper.class).getAllCar());
//}

	public void regCar(MultipartFile file, CarDTO c, HttpServletRequest req) {
		
		
		
		String fileRealName = c.getFile().getOriginalFilename(); 
		long size = file.getSize(); 
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = servletContext.getRealPath("resources/web");
		
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		
		

		File saveFile = new File(uploadFolder+"\\"+uniqueName + fileExtension);  // 적용 후
		
	
		try {
			c.getFile().transferTo(saveFile);
			c.setC_file(uniqueName+fileExtension);
			AdminCarMapper mm = ss.getMapper(AdminCarMapper.class);
			System.out.println("upload successed!");
			req.setAttribute("fileName", uniqueName+fileExtension);
			
			System.out.println(c);
		
			if (mm.regCar(c) == 1) {
	            System.out.println("등록성공");
	            allCarCount++;
	            req.setAttribute("r", "등록성공");
	        } else {
	            req.setAttribute("r", "등록 실패");
	        }

	    } catch (IllegalStateException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void updateCar(MultipartFile file, CarDTO c, HttpServletRequest req) {
		
		
		if (ss.getMapper(AdminCarMapper.class).updatecar(c) == 1) {
			System.out.println("수정완료");
		
		
	}else {
		System.out.println("수정실패");
		
		
	}
	
	}

	public void deletecar(CarDTO c, HttpServletRequest req) {
		if (ss.getMapper(AdminCarMapper.class).deletecar(c) == 1) {
			System.out.println("삭제완료");
			allCarCount--;
		}
		
	}

  
	

	public void calcAllCarCount() {
		SearchCarDTO sSel = new SearchCarDTO("","", null, null);
		allCarCount = ss.getMapper(AdminCarMapper.class).getCarCount(sSel);
		System.out.println(allCarCount);
		
	}
	

 	public void getCarlist(int pageNo, HttpServletRequest req) {
		mapper = ss.getMapper(AdminCarMapper.class);
		int count = co.getCarCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		SearchCarDTO search = (SearchCarDTO) req.getSession().getAttribute("cars");
		int CarCount = 0;
		
		System.out.println("WWWWWWWWWWWWWWWW");
		System.out.println(search);
		System.out.println("WWWWWWWWWWWWWWWW");
		
		if (search == null) {
			System.out.println("null입니다");
			search = new SearchCarDTO();
			search.setCarnameInput("");
			search.setCarbrandInput("");
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			CarCount = allCarCount;
			System.out.println("1-------" + allCarCount);
		}else {
			System.out.println("null아님");
			System.out.println(search.toString());
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			CarCount = ss.getMapper(AdminCarMapper.class).getCarCount(search);
			
		}
		List<CarDTO> Car = ss.getMapper(AdminCarMapper.class).getCarlists(search);
		System.out.println("@@@@@@@@@@@@@");
		System.out.println(Car);
		System.out.println("@@@@@@@@@@@@@");
		System.out.println(count);
		System.out.println(allCarCount);
		int pageCount = (int) Math.ceil(CarCount / (double) count);
		System.out.println(CarCount);
		System.out.println(pageCount);
	
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cars", Car);
		req.setAttribute("curPage", pageNo);
		
		System.out.println(Car);
		
		
	}
	
 	public void searchcar(SearchCarDTO c, HttpServletRequest req) {
 		

		req.getSession().setAttribute("cars", c);
		
		System.out.println(req);
	}


	public void getCar(CarDTO c, HttpServletRequest req) {
		CarDTO Car = mapper.getCar(c);
		req.setAttribute("car1", Car);
		

	}

	public void deletebrand(CarBrandDTO c, HttpServletRequest req) {
		if (ss.getMapper(AdminCarMapper.class).deletebrand(c) == 1) {
			System.out.println("삭제완료");
			allCarCount--;
		}
		
	}

	public void regbrand(CarBrandDTO c, HttpServletRequest req) {
		
		AdminCarMapper mm = ss.getMapper(AdminCarMapper.class);
		
		if (mm.regbrand(c) == 1) {
			System.out.println("등록완료");
			
		}
		
		
	}

	public void getAllCar(Model m) {
		// TODO Auto-generated method stub
		
	}
	
	


}
