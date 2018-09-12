package com.study.jsp;

import java.sql.Timestamp;

public class BDto {

	int bId;
	String bName;
	String bTitle;
	String bContent;
	Timestamp bDate;
	int bHit;
	int bGroup;
	int bStep;
	int bIndent;
	String food;
	String sido;
	String gigungu;
	String manscore;
	String sumscore;
	String avgscore;
	String upload;
	String star;
	String gongji;
	
	public BDto(int bId, String bName, 	String bTitle, String bContent,	Timestamp bDate,
			int bHit,int bGroup,int bStep,	int bIndent, String food, String sido, String gigungu,
			String manscore,String sumscore,String avgscore,String upload, String star,String gongji) {
		this.bId=bId;
		this.bName=bName;
		this.bTitle=bTitle;
		this.bContent=bContent;
		this.bDate=bDate;
		this.bHit=bHit;
		this.bGroup=bGroup;
		this.bStep=bStep;
		this.bIndent=bIndent;
		this.food=food;
		this.sido=sido;
		this.gigungu=gigungu;
		this.manscore=manscore;
		this.sumscore=sumscore;
		this.avgscore=avgscore;
		this.upload=upload;		
		this.star=star;		
		this.gongji=gongji;		
	}
	
	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getManscore() {
		return manscore;
	}

	public void setManscore(String manscore) {
		this.manscore = manscore;
	}

	public String getSumscore() {
		return sumscore;
	}

	public void setSumscore(String sumscore) {
		this.sumscore = sumscore;
	}

	public String getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(String avgscore) {
		this.avgscore = avgscore;
	}

	public int getbId() {
		return bId;
	}
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGigungu() {
		return gigungu;
	}

	public void setGigungu(String gigungu) {
		this.gigungu = gigungu;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

	
}
