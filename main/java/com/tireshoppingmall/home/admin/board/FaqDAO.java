package com.tireshoppingmall.home.admin.board;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqDAO {

	@Autowired
	private SqlSession ss;
	
	@Autowired
	private FaqOption fo;
	
	private int allFaqCount;

	public int getAllFaqCount() {
		return allFaqCount;
	}

	public void setAllFaqCount(int allFaqCount) {
		this.allFaqCount = allFaqCount;
	}
	public void calcAllFaqCount() {
		SearchDTO sSel = new SearchDTO("","", null, null,"","");
		allFaqCount = ss.getMapper(AdminBoardMapper.class).getFaqCount(sSel);
		System.out.println(allFaqCount);
	}

	public void getFaq(int pageNo, HttpServletRequest req) {
		int count = fo.getFaqCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		SearchDTO search = (SearchDTO) req.getSession().getAttribute("searchDTO");
		int faqCount = 0;
		
		if (search == null) {
			search = new SearchDTO();
			search.setTitleInput("");
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			faqCount = allFaqCount;
			System.out.println("1-------" + allFaqCount);
		}else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			faqCount = ss.getMapper(AdminBoardMapper.class).getFaqCount(search);
		}
		List<FaqDTO> faq = ss.getMapper(AdminBoardMapper.class).getFaq(search);
		System.out.println(count);
		System.out.println(allFaqCount);
		int pageCount = (int) Math.ceil(faqCount / (double) count);
		System.out.println(faqCount);
		System.out.println(pageCount);
	
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("faqs", faq);
		req.setAttribute("curPage", pageNo);
		
		System.out.println(req);
	}
	
/*	public void getAllFaq(HttpServletRequest req) {

		List<FaqDTO> faq = ss.getMapper(AdminBoardMapper.class).getAllFaq();
		req.setAttribute("faq", faq);

	}*/

	public void searchFaq(HttpServletRequest req, SearchDTO sDTO) {
		String[] option = { "", "주문/배송", "상품관련", "장착관련", "반품/교환/취소","회원" };
		sDTO.setSelectOption(option[Integer.parseInt(req.getParameter("selectOption"))]);
		List<FaqDTO> faq = ss.getMapper(AdminBoardMapper.class).searchAllFaq(sDTO);
		req.setAttribute("faqs", faq);
		
	}

	public void regFaq(HttpServletRequest req, FaqDTO faqDTO) {
		if(ss.getMapper(AdminBoardMapper.class).regFaq(faqDTO) == 1) {
			allFaqCount++;
			req.setAttribute("regR", "등록 성공");
		}else {
			req.setAttribute("regR", "등록 실패");
		}
		
	}

	public void updateFaq(HttpServletRequest req, FaqDTO faqDTO) {
		if(ss.getMapper(AdminBoardMapper.class).updateFaq(faqDTO) >= 1) {
			req.setAttribute("updateR", "업데이트 성공");
		}else {
			req.setAttribute("updateR", "업데이트 실패");
		}
	}

	public void deleteFaq(HttpServletRequest req, FaqDTO faqDTO) {
		if(ss.getMapper(AdminBoardMapper.class).deleteFaq(faqDTO)) {
			System.out.println("삭제 성공");
			allFaqCount--;
		} else {
			System.err.println("삭제 실패");
		}
	}

	
}
