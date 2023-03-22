package com.tireshoppingmall.home.admin.store;

import org.springframework.web.multipart.MultipartFile;

public class BranchDTO {

	private String b_id;
	private String b_sortation;
	private String b_area;
	private String b_addr;
	private String b_name;
	private String b_time;
	private String b_service;
	private String b_mapdata;
	private String b_manager;
	private String b_managernumber;
	private String b_branchname;
	private String b_branchnumber;
	private String b_cr;
	private String b_email;
	private MultipartFile file;
	private String b_file;
	public BranchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchDTO( String b_id, String b_sortation, String b_area, String b_addr, String b_name,
			String b_time, String b_service, String b_mapdata, String b_manager, String b_managernumber,
			String b_branchname, String b_branchnumber, String b_cr, String b_email, MultipartFile file,
			String b_file) {




		super();
		this.b_id = b_id;
		this.b_sortation = b_sortation;
		this.b_area = b_area;
		this.b_addr = b_addr;
		this.b_name = b_name;
		this.b_time = b_time;
		this.b_service = b_service;
		this.b_mapdata = b_mapdata;
		this.b_manager = b_manager;
		this.b_managernumber = b_managernumber;
		this.b_branchname = b_branchname;
		this.b_branchnumber = b_branchnumber;
		this.b_cr = b_cr;
		this.b_email = b_email;
		this.file = file;
		this.b_file = b_file;
	}


	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_sortation() {
		return b_sortation;
	}
	public void setB_sortation(String b_sortation) {
		this.b_sortation = b_sortation;
	}
	public String getB_area() {
		return b_area;
	}
	public void setB_area(String b_area) {
		this.b_area = b_area;
	}
	public String getB_addr() {
		return b_addr;
	}
	public void setB_addr(String b_addr) {
		this.b_addr = b_addr;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_time() {
		return b_time;
	}
	public void setB_time(String b_time) {
		this.b_time = b_time;
	}
	public String getB_service() {
		return b_service;
	}
	public void setB_service(String b_service) {
		this.b_service = b_service;
	}
	public String getB_mapdata() {
		return b_mapdata;
	}
	public void setB_mapdata(String b_mapdata) {
		this.b_mapdata = b_mapdata;
	}
	public String getB_manager() {
		return b_manager;
	}
	public void setB_manager(String b_manager) {
		this.b_manager = b_manager;
	}
	public String getB_managernumber() {
		return b_managernumber;
	}
	public void setB_managernumber(String b_managernumber) {
		this.b_managernumber = b_managernumber;
	}

	public String getB_branchname() {
		return b_branchname;
	}
	public void setB_branchname(String b_branchname) {
		this.b_branchname = b_branchname;
	}
	public String getB_branchnumber() {
		return b_branchnumber;
	}
	public void setB_branchnumber(String b_branchnumber) {
		this.b_branchnumber = b_branchnumber;
	}
	public String getB_cr() {
		return b_cr;
	}
	public void setB_cr(String b_cr) {
		this.b_cr = b_cr;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getB_file() {
		return b_file;
	}
	public void setB_file(String b_file) {
		this.b_file = b_file;
	}

	@Override
	public String toString() {
		return "BranchDTO [b_id=" + b_id + ", b_sortation=" + b_sortation + ", b_area=" + b_area + ", b_addr=" + b_addr
				+ ", b_name=" + b_name + ", b_time=" + b_time + ", b_service=" + b_service + ", b_mapdata=" + b_mapdata
				+ ", b_manager=" + b_manager + ", b_managernumber=" + b_managernumber + ", b_branchname=" + b_branchname
				+ ", b_branchnumber=" + b_branchnumber + ", b_cr=" + b_cr + ", b_email=" + b_email + ", file=" + file
				+ ", b_file=" + b_file + "]";
	}



	
	
}