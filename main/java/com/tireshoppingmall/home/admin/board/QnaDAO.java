package com.tireshoppingmall.home.admin.board;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaDAO {

	@Autowired
	private SqlSession ss;
	
	@Autowired
	private QnaOption qo;
	
	private int allQnaCount;

	public int getAllQnaCount() {
		return allQnaCount;
	}

	public void setAllQnaCount(int allQnaCount) {
		this.allQnaCount = allQnaCount;
	}

	/*public void getAllQna(HttpServletRequest req) {
		List<QnaDTO> qna = ss.getMapper(AdminBoardMapper.class).getAllQna();
		req.setAttribute("qna", qna);
	}*/

	public void calcAllQnaCount() {
		SearchDTO sSel = new SearchDTO("","", null, null,"","");
		allQnaCount = ss.getMapper(AdminBoardMapper.class).getQnaCount(sSel);
		System.out.println(allQnaCount);
	}
	
	public void getQna(int pageNo, HttpServletRequest req) {
		int count = qo.getQnaCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		SearchDTO search = (SearchDTO) req.getSession().getAttribute("searchDTO");
		int qnaCount = 0;
		
		if (search == null) {
			search = new SearchDTO();
			search.setTitleInput("");
			search.setNameInput("");
			search.setIdInput("");
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			qnaCount = allQnaCount;
			System.out.println("1-------" + allQnaCount);
		}else {
			System.out.println("&&&&&&&&&&&&&&&&");
			System.out.println(search.toString());
			System.out.println("&&&&&&&&&&&&&&&&");
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			qnaCount = ss.getMapper(AdminBoardMapper.class).getQnaCount(search);
		}
		List<QnaDTO> qna = ss.getMapper(AdminBoardMapper.class).getQna(search);
		System.out.println(count);
		System.out.println(allQnaCount);
		int pageCount = (int) Math.ceil(qnaCount / (double) count);
		System.out.println(qnaCount);
		System.out.println(pageCount);
	
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("qnas", qna);
		req.setAttribute("curPage", pageNo);
	}
	
	public void searchQnA(SearchDTO SearchDTO, HttpServletRequest req) {
		req.getSession().setAttribute("searchDTO", SearchDTO);
	}

	public void insertQnAReply(QnaReplyDTO qnaReplyDTO, HttpServletRequest req) {
		qnaReplyDTO.setQ_reply_board_no(req.getParameter("q_no"));
		if(ss.getMapper(AdminBoardMapper.class).insertQnAReply(qnaReplyDTO)==1) {
			ss.getMapper(AdminBoardMapper.class).updateQna(qnaReplyDTO);
		};
		
		
	}

	public QnaReplyDTO getReply(QnaReplyDTO qnaReplyDTO) {
		return ss.getMapper(AdminBoardMapper.class).getReply(qnaReplyDTO);
	}

	
}
