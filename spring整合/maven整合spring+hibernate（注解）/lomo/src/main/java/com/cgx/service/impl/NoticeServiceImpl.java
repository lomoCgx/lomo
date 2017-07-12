package com.cgx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cgx.dao.BaseDao;
import com.cgx.dto.Notice;
import com.cgx.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private BaseDao<Notice> baseDao;
	@Override
	public void saveNotice(Notice notice) {
		// TODO Auto-generated method stub
		baseDao.save(notice);
	}

	@Override
	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		baseDao.update(notice);
	}

	@Override
	public Notice findNoticeById(int id) {
		// TODO Auto-generated method stub
		return baseDao.get(Notice.class, id);
	}

	@Override
	public void deleteNotice(Notice notice) {
		// TODO Auto-generated method stub
		baseDao.delete(notice);
	}

	@Override
	public List<Notice> findAllList() {
		// TODO Auto-generated method stub
		return baseDao.find("from Notice");
	}

	@Override
	public Notice findNoticeBySender(Notice user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findNoticeIsExites(String sender) {
		// TODO Auto-generated method stub
		return false;
	}

}
