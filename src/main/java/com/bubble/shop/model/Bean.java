package com.bubble.shop.model;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("bean")
public class Bean {

	//Additionals 
	Date bq_reg_date_start, bq_reg_date_end;
	String bq_reg_date_start_string, bq_reg_date_end_string;
	public Date getBq_reg_date_start() {
		return bq_reg_date_start;
	}

	public void setBq_reg_date_start(Date bq_reg_date_start) {
		this.bq_reg_date_start = bq_reg_date_start;
	}

	public Date getBq_reg_date_end() {
		return bq_reg_date_end;
	}

	public void setBq_reg_date_end(Date bq_reg_date_end) {
		this.bq_reg_date_end = bq_reg_date_end;
	}

	public String getBq_reg_date_start_string() {
		return bq_reg_date_start_string;
	}

	public void setBq_reg_date_start_string(String bq_reg_date_start_string) {
		this.bq_reg_date_start_string = bq_reg_date_start_string;
	}

	public String getBq_reg_date_end_string() {
		return bq_reg_date_end_string;
	}

	public void setBq_reg_date_end_string(String bq_reg_date_end_string) {
		this.bq_reg_date_end_string = bq_reg_date_end_string;
	}

	
	
	//Additionals 

	
	//----------------------------------------------------- [공통영역]




	// 페이징 관련
	Integer page = 1, min_cnt = 0, sum_cnt = 0, limit = 15, pageLimit = 3, totalPage, startPage, endPage, total = 0, start, end;
	public Integer getSum_cnt() {
		return sum_cnt;
	}




	public void setSum_cnt(Integer sum_cnt) {
		this.sum_cnt = sum_cnt;
	}



	String last="";
	Integer limitItem=30;
	
	
	// 파일 관련 (첨부파일) //list[0].g_imghotitem
	MultipartFile upfile, upfile2;
	String rename_upfile, ori_upfile, rename_g_testimg, ori_g_testimg;
	
	String ori_g_imghotitem;

	
	//관리자 페이지 파일 업로드 변수
	String g_imghotitem, g_imgshotitem, g_imgdetail;
	
	MultipartFile g_imghotitems, g_imgshotitems, g_imgdetails, g_imglists;
	String rename_g_imghotitem, rename_g_imgshotitem, rename_g_imgdetail, rename_g_imglist;
	
	
	// 파라메터 변수
	String url, msg, search = "";
	
	// 날짜 관련
	Integer sysYear, sysMonth, sysDay;  

	//----------------------------------------------------- [공통영역]
	
	Date bg_reg_date;

	//-----------------------------------------------------[shop_notice]병기리
	
	Integer notice_id, bbl_id, notice_gid, notice_seq, notice_rev, notice_cnt;
	
	String notice_yn = "N", notice_title, notice_content, notice_pw, notice_md, notice_upfile="", notice_user_upfile="",notice_banner_upfile="";
	String notice_event_yn="N";
	String searchType="notice_title";
	
	Date notice_reg_date, notice_mod_date;
	
	boolean notice_pw_chk=false;
	
	
	//zipsearch
	//집주소 검색 단어.
	
	ArrayList zipAddress, zipPost;
	
	String zipWord="";
	

	String find_email_chk="";
	
	
	//----------------------------------------------------[BS_EVENT]
	

	//----------------------------------------------------[BS_EVENT]
	

	//-----------------------------------------------------[shop_notice]병기리
	Integer id, gid, seq, ref, cnt;
	
	Date reg_date;
	
	String pname, pw, title, content, keyword;
	
	boolean redirect = false;
	

	//-----------------------------------------------------[GOODS] 홍성호
	
	Integer g_code=0, g_num, bp_cnt;
	String g_name, g_describe;
	Date g_reg_day;
	Integer bm_id, g_price, g_pricedis, g_show_hot_total;
	Date g_start_day, g_end_day;
	String g_imglist;
	String g_sell, g_show_list, g_show_hot;
	Object beanArray;
	
	String g_start_days, g_end_days;
	
		
	//-----------------------------------------------------[GOODS] 
	
	
	//-----------------------------------------------------[BS_MENU]
		Integer bm_index, bm_par_id , bm_depth;
		Date bm_reg_date;
		String bm_name, bm_show_yn;
	//-----------------------------------------------------[BS_MENU]

	// DB 데이터
	Object data, data2, bestitem, menuitem, bank, userinfo;


	
	
	//-----------------------------------------------------[BS_MEMBERS]
	
	public Object getData2() {
		return data2;
	}




	public void setData2(Object data2) {
		this.data2 = data2;
	}



	Integer bs_id = 0, bs_rate;

	String bs_userid = "", bs_pwd = "", bs_name, bs_hp, bs_sms_yn, bs_email, bs_email_yn;
	String bs_zip, bs_address, bs_address2, bs_sex, bs_birth, bs_photo, bs_bank, bs_account, bs_hoider;

	String h_hp1, h_hp2, h_hp3, h_email1, h_email2, h_zip1, h_zip2;
	
	Date bs_reg_date;
	
	//-----------------------------------------------------[BS_MEMBERS]

	
	//start---------------------------------------------------[BS_GOODS_DETAIL]
	Integer bgd_id,bgd_cnt, min_bgd_cnt = 0, sum_bgd_cnt = 0;
	String bgd_size,bgd_color;
	
	//end-----------------------------------------------------[BS_GOODS_DETAIL]
	
	
	
	
	//-----------------------------------------------------[BS_PARTICIPANT]

	Integer bp_id=0, be_id=0;
	String be_win_yn;
	Date bp_reg_date;
	
	//-----------------------------------------------------[BS_PARTICIPANT]
	
	
	//-----------------------------------------------------[BS_BASKET]
	
	Integer bb_id=0;
	Date bb_reg_date;
	Integer bb_cnt=0, bb_price=0;

	//-----------------------------------------------------[BS_BASKET]
	
	//-----------------------------------------------------[BS_BASKET_OPTION]
	
		Integer bbo_id;
		String bbo_price, bbo_cnt;
		

	//-----------------------------------------------------[BS_BASKET_OPTION]
	
	//-----------------------------------------------------[BS_PURCHASE]	
	Integer bp_price_type=0;
	String bp_status, bq_type, bq_memo = "";
	Integer bq_id=0;
	Integer bp_price=0;
	Integer bp_coupon_price=0;
	Integer bq_total=0;
	
	String bp_reg_dates;
	//-----------------------------------------------------[BS_PURCHASE 홍성호 끝]	

	
	//-----------------------------------------------------[BS_PURCHASE_DETAIL]
	Integer bpd_id, table_id, bpd_cnt, bpd_price;
	
	
	//-----------------------------------------------------[BS_PURCHASE_DETAIL]
	

	
	
	//-----------------------------------------------------[BS_COUPON]	
	Integer bc_id;
	Date bc_reg_date;
	Integer bc_price;
	Date bc_start_date;
	Date bc_end_date;
	String bc_start_date2 = "", bc_end_date2 = ""; 
	Object coupon;
	String bc_start_date_before,bc_end_date_before;
	//-----------------------------------------------------[BS_BANK_LIST]
	String bbl_code,   bbl_name;
	
	Integer randompointer;
	

	
	//-----------------------------------------------------[BS_COUPON]	
	Date bq_reg_date;
	String bq_status;
	String bq_code;
	Integer bq_price = 0;
	//-----------------------------------------------------[BS_QUICK]	
	
	String bc_reg_dates;
	String bc_reg_dates2;
	
	
	//-----------------------------------------------------[BS_BANK_LIST]
	
	//----------------------------------------------------- [BS_MY_COUPON]
	Integer bmc_id;
	String bmc_status;
	Date bmc_use_date, bmc_reg_date;
	//----------------------------------------------------- [BS_MY_COUPON]
	
	
	//----------------------------------------------------- [BS_GUEST]
	Integer bg_id;
	String bg_code, bg_name = "", bg_hp = "", bg_zip = "", bg_address = "", bg_address2 = "";
	
	
	//----------------------------------------------------- [BS_GUEST]
			
			
			
			

	
	//----------------------------------------------------- [전문현 변수]
	String a_arr, a_arr2, a_arr3, sqler;
	
	
	// 결제 관련 변수
	String a_g_code, a_bgd_id, a_bgd_cnt, a_bgd_price, prev_page, html_view, a_g_code_price, pay_flag, stemp;
	String srch_value, mem_address, s_start_date, e_end_date;
	Integer pay_total_price = 0, pay_pay2 = 0, pay_pay3 = 0;
	Object goods_data, add_post;
	
	
	//----------------------------------------------------- [전문현 변수]

	//EVENT 게시판
	String be_title,be_content,be_list_img, be_detail_img,be_close_yn;
	Date be_reg_date, be_start_date, be_end_date;
	Object eventList;
	

	
	






	public Date getBg_reg_date() {
		return bg_reg_date;
	}




	public void setBg_reg_date(Date bg_reg_date) {
		this.bg_reg_date = bg_reg_date;
	}




	public Date getNewDate(){
		return new Date();
	}
	
	


	public String getRename_g_imglist() {
		return rename_g_imglist;
	}



	public void setRename_g_imglist(String rename_g_imglist) {
		this.rename_g_imglist = rename_g_imglist;
	}



	public MultipartFile getG_imglists() {
		return g_imglists;
	}



	public void setG_imglists(MultipartFile g_imglists) {
		this.g_imglists = g_imglists;
	}



	public String getG_start_days() {
		return g_start_days;
	}



	public void setG_start_days(String g_start_days) {
		this.g_start_days = g_start_days;
	}



	public String getG_end_days() {
		return g_end_days;
	}



	public void setG_end_days(String g_end_days) {
		this.g_end_days = g_end_days;
	}



	public Object getEventList() {
		return eventList;
	}




	public void setEventList(Object eventList) {
		this.eventList = eventList;
	}




	public String getBe_title() {
		return be_title;
	}




	public void setBe_title(String be_title) {
		this.be_title = be_title;
	}




	public String getBe_content() {
		return be_content;
	}




	public void setBe_content(String be_content) {
		this.be_content = be_content;
	}




	public String getBe_list_img() {
		return be_list_img;
	}




	public void setBe_list_img(String be_list_img) {
		this.be_list_img = be_list_img;
	}




	public String getBe_detail_img() {
		return be_detail_img;
	}




	public void setBe_detail_img(String be_detail_img) {
		this.be_detail_img = be_detail_img;
	}




	public String getBe_close_yn() {
		return be_close_yn;
	}




	public void setBe_close_yn(String be_close_yn) {
		this.be_close_yn = be_close_yn;
	}




	public Date getBe_reg_date() {
		return be_reg_date;
	}




	public void setBe_reg_date(Date be_reg_date) {
		this.be_reg_date = be_reg_date;
	}




	public Date getBe_start_date() {
		return be_start_date;
	}




	public void setBe_start_date(Date be_start_date) {
		this.be_start_date = be_start_date;
	}




	public Date getBe_end_date() {
		return be_end_date;
	}




	public void setBe_end_date(Date be_end_date) {
		this.be_end_date = be_end_date;
	}




	public String getSrch_value() {
		return srch_value;
	}




	public void setSrch_value(String srch_value) {
		this.srch_value = srch_value;
	}
	public String getNotice_event_yn() {
		return notice_event_yn;
	}



	public void setNotice_event_yn(String notice_event_yn) {
		this.notice_event_yn = notice_event_yn;
	}


	public String getBc_reg_dates() {
		return bc_reg_dates;
	}
	


	public Integer getLimitItem() {
		return this.limitItem;
	}



	public void setBc_reg_dates(String bc_reg_dates) {
		this.bc_reg_dates = bc_reg_dates;
	}



	public String getBc_reg_dates2() {
		return bc_reg_dates2;
	}



	public void setBc_reg_dates2(String bc_reg_dates2) {
		this.bc_reg_dates2 = bc_reg_dates2;
	}




	public Object getCoupon() {
		return coupon;
	}

	

	public Integer getBmc_id() {
		return bmc_id;
	}



	public void setBmc_id(Integer bmc_id) {
		this.bmc_id = bmc_id;
	}



	public String getBmc_status() {
		return bmc_status;
	}



	public void setBmc_status(String bmc_status) {
		this.bmc_status = bmc_status;
	}



	public Date getBmc_use_date() {
		return bmc_use_date;
	}



	public void setBmc_use_date(Date bmc_use_date) {
		this.bmc_use_date = bmc_use_date;
	}



	public Date getBmc_reg_date() {
		return bmc_reg_date;
	}



	public void setBmc_reg_date(Date bmc_reg_date) {
		this.bmc_reg_date = bmc_reg_date;
	}



	public void setCoupon(Object coupon) {
		this.coupon = coupon;
	}




	public String getA_arr2() {
		return a_arr2;
	}



	public void setA_arr2(String a_arr2) {
		this.a_arr2 = a_arr2;
	}



	public String getA_arr3() {
		return a_arr3;
	}



	public void setA_arr3(String a_arr3) {
		this.a_arr3 = a_arr3;
	}



	public String getG_imghotitem() {
		return g_imghotitem;
	}



	public void setG_imghotitem(String g_imghotitem) {
		this.g_imghotitem = g_imghotitem;
	}



	public String getG_imgshotitem() {
		return g_imgshotitem;
	}



	public void setG_imgshotitem(String g_imgshotitem) {
		this.g_imgshotitem = g_imgshotitem;
	}



	public String getG_imgdetail() {
		return g_imgdetail;
	}



	public void setG_imgdetail(String g_imgdetail) {
		this.g_imgdetail = g_imgdetail;
	}



	public String getBp_reg_dates() {
		return bp_reg_dates;
	}


	public void setBp_reg_dates(String bp_reg_dates) {
		this.bp_reg_dates = bp_reg_dates;
	}




	public MultipartFile getG_imghotitems() {
		return g_imghotitems;
	}


	public void setG_imghotitems(MultipartFile g_imghotitems) {
		this.g_imghotitems = g_imghotitems;
	}


	public MultipartFile getG_imgshotitems() {
		return g_imgshotitems;
	}


	public void setG_imgshotitems(MultipartFile g_imgshotitems) {
		this.g_imgshotitems = g_imgshotitems;
	}


	public MultipartFile getG_imgdetails() {
		return g_imgdetails;
	}


	public void setG_imgdetails(MultipartFile g_imgdetails) {
		this.g_imgdetails = g_imgdetails;
	}


	public Date getBq_reg_date() {
		return bq_reg_date;
	}


	public void setBq_reg_date(Date bq_reg_date) {
		this.bq_reg_date = bq_reg_date;
	}


	public String getBq_status() {
		return bq_status;
	}


	public void setBq_status(String bq_status) {
		this.bq_status = bq_status;
	}

	


	public String getBq_code() {
		return bq_code;
	}




	public void setBq_code(String bq_code) {
		this.bq_code = bq_code;
	}




	public Integer getBq_total() {
		return bq_total;
	}


	public void setBq_total(Integer bq_total) {
		this.bq_total = bq_total;
	}


	public Integer getRandompointer() {
		return randompointer;
	}


	public void setRandompointer(Integer randompointer) {
		this.randompointer = randompointer;
	}


	public String getBc_end_date_before() {
		return bc_end_date_before;
	}


	public void setBc_end_date_before(String bc_end_date_before) {
		this.bc_end_date_before = bc_end_date_before;
	}


	public String getBc_start_date_before() {
		return bc_start_date_before;
	}


	public void setBc_start_date_before(String bc_start_date_before) {
		this.bc_start_date_before = bc_start_date_before;
	}


	public Integer getBc_id() {
		return bc_id;
	}


	public void setBc_id(Integer bc_id) {
		this.bc_id = bc_id;
	}


	public Date getBc_reg_date() {
		return bc_reg_date;
	}


	public void setBc_reg_date(Date bc_reg_date) {
		this.bc_reg_date = bc_reg_date;
	}


	public Integer getBc_price() {
		return bc_price;
	}


	public void setBc_price(Integer bc_price) {
		this.bc_price = bc_price;
	}


	public Date getBc_start_date() {
		return bc_start_date;
	}


	public void setBc_start_date(Date bc_start_date) {
		this.bc_start_date = bc_start_date;
	}


	public Date getBc_end_date() {
		return bc_end_date;
	}


	public void setBc_end_date(Date bc_end_date) {
		this.bc_end_date = bc_end_date;
	}




	public String getRename_g_imghotitem() {
		return rename_g_imghotitem;
	}


	public void setRename_g_imghotitem(String rename_g_imghotitem) {
		this.rename_g_imghotitem = rename_g_imghotitem;
	}


	public String getRename_g_imgshotitem() {
		return rename_g_imgshotitem;
	}


	public void setRename_g_imgshotitem(String rename_g_imgshotitem) {
		this.rename_g_imgshotitem = rename_g_imgshotitem;
	}


	public String getRename_g_imgdetail() {
		return rename_g_imgdetail;
	}


	public void setRename_g_imgdetail(String rename_g_imgdetail) {
		this.rename_g_imgdetail = rename_g_imgdetail;
	}


	public String getOri_g_imghotitem() {
		return ori_g_imghotitem;
	}

	public void setOri_g_imghotitem(String ori_g_imghotitem) {
		this.ori_g_imghotitem = ori_g_imghotitem;
	}


	public String getRename_g_testimg() {
		return rename_g_testimg;
	}

	public void setRename_g_testimg(String rename_g_testimg) {
		this.rename_g_testimg = rename_g_testimg;
	}

	public String getOri_g_testimg() {
		return ori_g_testimg;
	}

	public void setOri_g_testimg(String ori_g_testimg) {
		this.ori_g_testimg = ori_g_testimg;
	}




	public Integer getBgd_id() {
		return bgd_id;
	}

	public void setBgd_id(Integer bgd_id) {
		this.bgd_id = bgd_id;
	}

	public Integer getBgd_cnt() {
		return bgd_cnt;
	}

	public void setBgd_cnt(Integer bgd_cnt) {
		this.bgd_cnt = bgd_cnt;
	}

	public String getBgd_size() {
		return bgd_size;
	}

	public void setBgd_size(String bgd_size) {
		this.bgd_size = bgd_size;
	}

	public String getBgd_color() {
		return bgd_color;
	}

	public void setBgd_color(String bgd_color) {
		this.bgd_color = bgd_color;
	}


	public Integer getBp_price_type() {
		return bp_price_type;
	}

	public void setBp_price_type(Integer bp_price_type) {
		this.bp_price_type = bp_price_type;
	}

	public String getBp_status() {
		return bp_status;
	}

	public void setBp_status(String bp_status) {
		this.bp_status = bp_status;
	}

	public Integer getBq_id() {
		return bq_id;
	}

	public void setBq_id(Integer bq_id) {
		this.bq_id = bq_id;
	}

	public Integer getBp_price() {
		return bp_price;
	}

	public void setBp_price(Integer bp_price) {
		this.bp_price = bp_price;
	}

	public Integer getBb_id() {
		return bb_id;
	}

	public void setBb_id(Integer bb_id) {
		this.bb_id = bb_id;
	}

	public Date getBb_reg_date() {
		return bb_reg_date;
	}

	public void setBb_reg_date(Date bb_reg_date) {
		this.bb_reg_date = bb_reg_date;
	}

	public Integer getBb_cnt() {
		return bb_cnt;
	}

	public void setBb_cnt(Integer bb_cnt) {
		this.bb_cnt = bb_cnt;
	}

	public Integer getBb_price() {
		return bb_price;
	}

	public void setBb_price(Integer bb_price) {
		this.bb_price = bb_price;
	}

	public Integer getBp_id() {
		return bp_id;
	}

	public void setBp_id(Integer bp_id) {
		this.bp_id = bp_id;
	}

	public Integer getBe_id() {
		return be_id;
	}

	public void setBe_id(Integer be_id) {
		this.be_id = be_id;
	}

	public String getBe_win_yn() {
		return be_win_yn;
	}

	public void setBe_win_yn(String be_win_yn) {
		this.be_win_yn = be_win_yn;
	}

	public Date getBp_reg_date() {
		return bp_reg_date;
	}

	public void setBp_reg_date(Date bp_reg_date) {
		this.bp_reg_date = bp_reg_date;
	}


	public Integer getBm_depth() {
		return bm_depth;
	}

	public Object getBeanArray() {
		return beanArray;
	}

	public void setBeanArray(Object beanArray) {
		this.beanArray = beanArray;
	}

	public void setBm_depth(Integer bm_depth) {
		this.bm_depth = bm_depth;
	}
	
	public Object getMenuitem() {
		return menuitem;
	}
	
	public void setMenuitem(Object menuitem) {
		this.menuitem = menuitem;
	}
	
	public Integer getG_show_hot_total() {
		return g_show_hot_total;
	}


	public Integer getBm_index() {
		return bm_index;
	}

	public void setBm_index(Integer bm_index) {
		this.bm_index = bm_index;
	}

	public Integer getBm_par_id() {
		return bm_par_id;
	}

	public void setBm_par_id(Integer bm_par_id) {
		this.bm_par_id = bm_par_id;
	}

	public Date getBm_reg_date() {
		return bm_reg_date;
	}

	public void setBm_reg_date(Date bm_reg_date) {
		this.bm_reg_date = bm_reg_date;
	}

	public String getBm_name() {
		return bm_name;
	}

	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	}

	public String getBm_show_yn() {
		return bm_show_yn;
	}

	public void setBm_show_yn(String bm_show_yn) {
		this.bm_show_yn = bm_show_yn;
	}

	public void setG_show_hot_total(Integer g_show_hot_total) {
		this.g_show_hot_total = g_show_hot_total;
	}

	public Integer getBp_cnt() {
		return bp_cnt;
	}

	public void setBp_cnt(Integer bp_cnt) {
		this.bp_cnt = bp_cnt;
	}

	public Object getBestitem() {
		return bestitem;
	}

	public void setBestitem(Object bestitem) {
		this.bestitem = bestitem;
	}

	public String getG_show_hot() {
		return g_show_hot;
	}

	

	public String getNotice_upfile() {
		return notice_upfile;
	}



	public void setNotice_upfile(String notice_upfile) {
		this.notice_upfile = notice_upfile;
	}



	public void setG_show_hot(String g_show_hot) {
		this.g_show_hot = g_show_hot;
	}

	public String getG_sell() {
		return g_sell;
	}

	public void setG_sell(String g_sell) {
		this.g_sell = g_sell;
	}

	public String getG_show_list() {
		return g_show_list;
	}

	public void setG_show_list(String g_show_list) {
		this.g_show_list = g_show_list;
	}

	public Date getG_start_day() {
		return g_start_day;
	}

	public void setG_start_day(Date g_start_day) {
		this.g_start_day = g_start_day;
	}

	public Date getG_end_day() {
		return g_end_day;
	}

	public void setG_end_day(Date g_end_day) {
		this.g_end_day = g_end_day;
	}

	public String getG_imglist() {
		return g_imglist;
	}

	public void setG_imglist(String g_imglist) {
		this.g_imglist = g_imglist;
	}

	public Date getG_reg_day() {
		return g_reg_day;
	}

	public void setG_reg_day(Date g_reg_day) {
		this.g_reg_day = g_reg_day;
	}

	public Integer getG_num() {
		return g_num;
	}

	public void setG_num(Integer g_num) {
		this.g_num = g_num;
	}

	public Integer getG_code() {
		return g_code;
	}

	public void setG_code(Integer g_code) {
		this.g_code = g_code;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_describe() {
		return g_describe;
	}

	public void setG_describe(String g_describe) {
		this.g_describe = g_describe;
	}

	public Integer getBm_id() {
		return bm_id;
	}

	public void setBm_id(Integer bm_id) {
		this.bm_id = bm_id;
	}

	public Integer getG_price() {
		return g_price;
	}

	public void setG_price(Integer g_price) {
		this.g_price = g_price;
	}

	public Integer getG_pricedis() {
		return g_pricedis;
	}

	public void setG_pricedis(Integer g_pricedis) {
		this.g_pricedis = g_pricedis;
	}


	public Integer getBbl_id() {
		return bbl_id;
	}

	public void setBbl_id(Integer bbl_id) {
		this.bbl_id = bbl_id;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public boolean isNotice_pw_chk() {
		return notice_pw_chk;
	}

	public void setNotice_pw_chk(boolean notice_pw_chk) {
		this.notice_pw_chk = notice_pw_chk;
	}

	public String getNotice_md() {
		return notice_md;
	}

	public void setNotice_md(String notice_md) {
		this.notice_md = notice_md;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getRef() {
		return ref;
	}

	public void setRef(Integer ref) {
		this.ref = ref;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

	public String getRename_upfile() {
		return rename_upfile;
	}

	public void setRename_upfile(String rename_upfile) {
		this.rename_upfile = rename_upfile;
	}

	public String getOri_upfile() {
		return ori_upfile;
	}

	public void setOri_upfile(String ori_upfile) {
		this.ori_upfile = ori_upfile;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getNotice_pw() {
		return notice_pw;
	}

	public void setNotice_pw(String notice_pw) {
		this.notice_pw = notice_pw;
	}

	public Integer getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}

	

	public Integer getNotice_gid() {
		return notice_gid;
	}

	public void setNotice_gid(Integer notice_gid) {
		this.notice_gid = notice_gid;
	}

	public Integer getNotice_seq() {
		return notice_seq;
	}

	public void setNotice_seq(Integer notice_seq) {
		this.notice_seq = notice_seq;
	}

	public Integer getNotice_rev() {
		return notice_rev;
	}

	public void setNotice_rev(Integer notice_rev) {
		this.notice_rev = notice_rev;
	}

	public Integer getNotice_cnt() {
		return notice_cnt;
	}

	public void setNotice_cnt(Integer notice_cnt) {
		this.notice_cnt = notice_cnt;
	}

	public Integer getBs_id() {
		return bs_id;
	}

	public void setBs_id(Integer bs_id) {
		this.bs_id = bs_id;
	}

	public String getNotice_yn() {
		return notice_yn;
	}

	public void setNotice_yn(String notice_yn) {
		this.notice_yn = notice_yn;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_reg_date() {
		return notice_reg_date;
	}

	public void setNotice_reg_date(Date notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}

	public Date getNotice_mod_date() {
		return notice_mod_date;
	}

	public void setNotice_mod_date(Date notice_mod_date) {
		this.notice_mod_date = notice_mod_date;
	}


	public Integer getBs_rate() {
		return bs_rate;
	}

	public void setBs_rate(Integer bs_rate) {
		this.bs_rate = bs_rate;
	}

	public String getBs_userid() {
		return bs_userid;
	}

	public void setBs_userid(String bs_userid) {
		this.bs_userid = bs_userid;
	}

	public String getBs_pwd() {
		return bs_pwd;
	}

	public void setBs_pwd(String bs_pwd) {
		this.bs_pwd = bs_pwd;
	}

	public String getBs_name() {
		return bs_name;
	}

	public void setBs_name(String bs_name) {
		this.bs_name = bs_name;
	}

	public String getBs_hp() {
		return bs_hp;
	}

	public void setBs_hp(String bs_hp) {
		this.bs_hp = bs_hp;
	}

	public String getBs_sms_yn() {
		return bs_sms_yn;
	}

	public void setBs_sms_yn(String bs_sms_yn) {
		this.bs_sms_yn = bs_sms_yn;
	}

	public String getBs_email() {
		return bs_email;
	}

	public void setBs_email(String bs_email) {
		this.bs_email = bs_email;
	}

	public String getBs_email_yn() {
		return bs_email_yn;
	}

	public void setBs_email_yn(String bs_email_yn) {
		this.bs_email_yn = bs_email_yn;
	}

	public String getBs_zip() {
		return bs_zip;
	}

	public void setBs_zip(String bs_zip) {
		this.bs_zip = bs_zip;
	}

	public String getBs_address() {
		return bs_address;
	}

	public void setBs_address(String bs_address) {
		this.bs_address = bs_address;
	}

	public String getBs_address2() {
		return bs_address2;
	}

	public void setBs_address2(String bs_address2) {
		this.bs_address2 = bs_address2;
	}

	public String getNotice_user_upfile() {
		return notice_user_upfile;
	}

	public void setNotice_user_upfile(String notice_user_upfile) {
		this.notice_user_upfile = notice_user_upfile;
	}

	public Date getBs_reg_date() {
		return bs_reg_date;
	}

	public void setBs_reg_date(Date bs_reg_date) {
		this.bs_reg_date = bs_reg_date;
	}

	public Integer getSysYear() {
		return sysYear;
	}

	public void setSysYear(Integer sysYear) {
		this.sysYear = sysYear;
	}

	public Integer getSysMonth() {
		return sysMonth;
	}

	public void setSysMonth(Integer sysMonth) {
		this.sysMonth = sysMonth;
	}

	public Integer getSysDay() {
		return sysDay;
	}

	public void setSysDay(Integer sysDay) {
		this.sysDay = sysDay;
	}

	public String getBs_sex() {
		return bs_sex;
	}

	public void setBs_sex(String bs_sex) {
		this.bs_sex = bs_sex;
	}

	public String getBs_birth() {
		return bs_birth;
	}

	public void setBs_birth(String bs_birth) {
		this.bs_birth = bs_birth;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getH_hp1() {
		return h_hp1;
	}

	public void setH_hp1(String h_hp1) {
		this.h_hp1 = h_hp1;
	}

	public String getH_hp2() {
		return h_hp2;
	}

	public void setH_hp2(String h_hp2) {
		this.h_hp2 = h_hp2;
	}

	public String getH_hp3() {
		return h_hp3;
	}

	public void setH_hp3(String h_hp3) {
		this.h_hp3 = h_hp3;
	}
	
	public String getH_email1() {
		return h_email1;
	}

	public void setH_email1(String h_email1) {
		this.h_email1 = h_email1;
	}

	public String getH_email2() {
		return h_email2;
	}

	public void setH_email2(String h_email2) {
		this.h_email2 = h_email2;
	}

	public String getA_arr() {
		return a_arr;
	}

	public void setA_arr(String a_arr) {
		this.a_arr = a_arr;
	}

	public String getH_zip1() {
		return h_zip1;
	}

	public void setH_zip1(String h_zip1) {
		this.h_zip1 = h_zip1;
	}

	public String getH_zip2() {
		return h_zip2;
	}

	public void setH_zip2(String h_zip2) {
		this.h_zip2 = h_zip2;
	}

	public String getBs_photo() {
		return bs_photo;
	}

	public void setBs_photo(String bs_photo) {
		this.bs_photo = bs_photo;
	}

	public String getBs_bank() {
		return bs_bank;
	}

	public void setBs_bank(String bs_bank) {
		this.bs_bank = bs_bank;
	}

	public String getBs_account() {
		return bs_account;
	}

	public void setBs_account(String bs_account) {
		this.bs_account = bs_account;
	}

	public String getBs_hoider() {
		return bs_hoider;
	}

	public void setBs_hoider(String bs_hoider) {
		this.bs_hoider = bs_hoider;
	}

	public Object getBank() {
		return bank;
	}

	public void setBank(Object bank) {
		this.bank = bank;
	}

	public String getBbl_code() {
		return bbl_code;
	}

	public void setBbl_code(String bbl_code) {
		this.bbl_code = bbl_code;
	}

	public String getBbl_name() {
		return bbl_name;
	}

	public void setBbl_name(String bbl_name) {
		this.bbl_name = bbl_name;
	}



	public Integer getBbo_id() {
		return bbo_id;
	}



	public void setBbo_id(Integer bbo_id) {
		this.bbo_id = bbo_id;
	}



	public String getBbo_price() {
		return bbo_price;
	}



	public void setBbo_price(String bbo_price) {
		this.bbo_price = bbo_price;
	}



	public String getBbo_cnt() {
		return bbo_cnt;
	}



	public void setBbo_cnt(String bbo_cnt) {
		this.bbo_cnt = bbo_cnt;
	}



	public String getA_bgd_id() {
		return a_bgd_id;
	}



	public void setA_bgd_id(String a_bgd_id) {
		this.a_bgd_id = a_bgd_id;
	}



	public String getA_bgd_cnt() {
		return a_bgd_cnt;
	}



	public void setA_bgd_cnt(String a_bgd_cnt) {
		this.a_bgd_cnt = a_bgd_cnt;
	}



	public String getA_bgd_price() {
		return a_bgd_price;
	}



	public void setA_bgd_price(String a_bgd_price) {
		this.a_bgd_price = a_bgd_price;
	}



	public String getPrev_page() {
		return prev_page;
	}



	public MultipartFile getUpfile2() {
		return upfile2;
	}




	public void setUpfile2(MultipartFile upfile2) {
		this.upfile2 = upfile2;
	}




	public void setPrev_page(String prev_page) {
		this.prev_page = prev_page;
	}

	public String getFind_email_chk() {
		return find_email_chk;
	}



	public void setFind_email_chk(String find_email_chk) {
		this.find_email_chk = find_email_chk;
	}




	public String getNotice_banner_upfile() {
		return notice_banner_upfile;
	}




	public void setNotice_banner_upfile(String notice_banner_upfile) {
		this.notice_banner_upfile = notice_banner_upfile;
	}




	public String getSqler() {
		return sqler;
	}



	public void setSqler(String sqler) {
		this.sqler = sqler;
	}



	public String getA_g_code() {
		return a_g_code;
	}



	public void setA_g_code(String a_g_code) {
		this.a_g_code = a_g_code;
	}




	public Object getGoods_data() {
		return goods_data;
	}



	public void setGoods_data(Object goods_data) {
		this.goods_data = goods_data;
	}



	public String getHtml_view() {
		return html_view;
	}



	public void setHtml_view(String html_view) {
		this.html_view = html_view;
	}

	public String getA_g_code_price() {
		return a_g_code_price;
	}




	public void setA_g_code_price(String a_g_code_price) {
		this.a_g_code_price = a_g_code_price;
	}




	public Object getUserinfo() {
		return userinfo;
	}




	public void setUserinfo(Object userinfo) {
		this.userinfo = userinfo;
	}



	public String getPay_flag() {
		return pay_flag;
	}



	public void setPay_flag(String pay_flag) {
		this.pay_flag = pay_flag;
	}




	public String getBq_type() {
		return bq_type;
	}




	public void setBq_type(String bq_type) {
		this.bq_type = bq_type;
	}




	public String getBq_memo() {
		return bq_memo;
	}




	public void setBq_memo(String bq_memo) {
		this.bq_memo = bq_memo;
	}




	public Integer getBg_id() {
		return bg_id;
	}




	public void setBg_id(Integer bg_id) {
		this.bg_id = bg_id;
	}




	public String getBg_code() {
		return bg_code;
	}




	public void setBg_code(String bg_code) {
		this.bg_code = bg_code;
	}




	public String getBg_name() {
		return bg_name;
	}




	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}




	public String getBg_hp() {
		return bg_hp;
	}




	public void setBg_hp(String bg_hp) {
		this.bg_hp = bg_hp;
	}




	public String getBg_zip() {
		return bg_zip;
	}




	public void setBg_zip(String bg_zip) {
		this.bg_zip = bg_zip;
	}




	public String getBg_address() {
		return bg_address;
	}




	public void setBg_address(String bg_address) {
		this.bg_address = bg_address;
	}




	public String getBg_address2() {
		return bg_address2;
	}




	public void setBg_address2(String bg_address2) {
		this.bg_address2 = bg_address2;
	}




	public void setLimitItem(Integer limitItem) {
		this.limitItem = limitItem;
	}




	public Integer getPay_total_price() {
		return pay_total_price;
	}




	public void setPay_total_price(Integer pay_total_price) {
		this.pay_total_price = pay_total_price;
	}




	public Integer getPay_pay2() {
		return pay_pay2;
	}




	public void setPay_pay2(Integer pay_pay2) {
		this.pay_pay2 = pay_pay2;
	}




	public Integer getPay_pay3() {
		return pay_pay3;
	}




	public void setPay_pay3(Integer pay_pay3) {
		this.pay_pay3 = pay_pay3;
	}




	public Integer getBpd_id() {
		return bpd_id;
	}




	public void setBpd_id(Integer bpd_id) {
		this.bpd_id = bpd_id;
	}




	public Integer getTable_id() {
		return table_id;
	}




	public void setTable_id(Integer table_id) {
		this.table_id = table_id;
	}




	public Integer getBpd_cnt() {
		return bpd_cnt;
	}




	public void setBpd_cnt(Integer bpd_cnt) {
		this.bpd_cnt = bpd_cnt;
	}




	public Integer getBpd_price() {
		return bpd_price;
	}




	public void setBpd_price(Integer bpd_price) {
		this.bpd_price = bpd_price;
	}




	public Integer getMin_bgd_cnt() {
		return min_bgd_cnt;
	}




	public void setMin_bgd_cnt(Integer min_bgd_cnt) {
		this.min_bgd_cnt = min_bgd_cnt;
	}




	public Integer getMin_cnt() {
		return min_cnt;
	}




	public void setMin_cnt(Integer min_cnt) {
		this.min_cnt = min_cnt;
	}




	public Integer getSum_bgd_cnt() {
		return sum_bgd_cnt;
	}




	public void setSum_bgd_cnt(Integer sum_bgd_cnt) {
		this.sum_bgd_cnt = sum_bgd_cnt;
	}




	public Integer getBq_price() {
		return bq_price;
	}




	public void setBq_price(Integer bq_price) {
		this.bq_price = bq_price;
	}




	public Integer getBp_coupon_price() {
		return bp_coupon_price;
	}




	public void setBp_coupon_price(Integer bp_coupon_price) {
		this.bp_coupon_price = bp_coupon_price;
	}




	public String getStemp() {
		return stemp;
	}




	public void setStemp(String stemp) {
		this.stemp = stemp;
	}
	

	



	public String getZipWord() {
		return zipWord;
	}




	public void setZipWord(String zipWord) {
		this.zipWord = zipWord;
	}




	public ArrayList getZipAddress() {
		return zipAddress;
	}




	public void setZipAddress(ArrayList zipAddress) {
		this.zipAddress = zipAddress;
	}




	public void setZipPost(ArrayList zipPost) {
		this.zipPost = zipPost;
	}
	


	public ArrayList getZipPost() {
		return zipPost;
	}




	public String getBc_start_date2() {
		return bc_start_date2;
	}




	public void setBc_start_date2(String bc_start_date2) {
		this.bc_start_date2 = bc_start_date2;
	}




	public String getBc_end_date2() {
		return bc_end_date2;
	}




	public void setBc_end_date2(String bc_end_date2) {
		this.bc_end_date2 = bc_end_date2;
	}




	public String getS_start_date() {
		return s_start_date;
	}




	public void setS_start_date(String s_start_date) {
		this.s_start_date = s_start_date;
	}




	public String getE_end_date() {
		return e_end_date;
	}




	public void setE_end_date(String e_end_date) {
		this.e_end_date = e_end_date;
	}




	public String getMem_address() {
		return mem_address;
	}




	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}




	public Object getAdd_post() {
		return add_post;
	}




	public void setAdd_post(Object add_post) {
		this.add_post = add_post;
	}
	
}
