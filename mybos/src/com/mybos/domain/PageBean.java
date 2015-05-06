package com.mybos.domain;

import java.util.List;

public class PageBean<T> {
	private List<T> entitys;
	private Long recordsCount;
	
	private Integer page;
	private Integer pageSize;
	
	private Integer pageCount;
	private Integer startPageIndex;
	private Integer endPageIndex;

	public PageBean(Integer page, Integer pageSize, List<T> entitys,
			Long recordsCount) {
		this.page = page;
		this.pageSize = pageSize;
		this.entitys = entitys;
		this.recordsCount = recordsCount;
		this.pageCount=new Long((this.recordsCount-1)/this.pageSize+1).intValue();
		
		if(pageCount<=pageSize){
			this.startPageIndex=1;
			this.endPageIndex=pageCount;
		}else{
			this.startPageIndex=this.page-4;
			this.endPageIndex=this.page+5;
			if(this.startPageIndex<1){
				this.startPageIndex=1;
				this.endPageIndex=10;
			}else if(this.endPageIndex>pageCount){
				this.endPageIndex=pageCount;
				this.startPageIndex=pageCount-10+1;
			}			
		}
	}
	public List<T> getEntitys() {
		return entitys;
	}
	public void setEntitys(List<T> entitys) {
		this.entitys = entitys;
	}
	public Long getRecordsCount() {
		return recordsCount;
	}
	public void setRecordsCount(Long recordsCount) {
		this.recordsCount = recordsCount;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getStartPageIndex() {
		return startPageIndex;
	}
	public void setStartPageIndex(Integer startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	public Integer getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(Integer endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}
