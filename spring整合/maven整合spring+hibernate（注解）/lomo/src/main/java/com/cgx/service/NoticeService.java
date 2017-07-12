package com.cgx.service;

import java.util.List;

import com.cgx.dto.Notice;

public interface NoticeService {

    public void saveNotice(Notice notice);
	
	public void updateNotice(Notice notice);
	
	public Notice findNoticeById(int id);
	
	public void deleteNotice(Notice notice);
	
	public List<Notice> findAllList();
	
	public Notice findNoticeBySender(Notice user);
	
	public boolean findNoticeIsExites(String sender);
}
