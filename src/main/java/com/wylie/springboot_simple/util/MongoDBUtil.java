package com.wylie.springboot_simple.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class MongoDBUtil {
	protected static Logger logger = LoggerFactory.getLogger(MongoDBUtil.class);
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 保存文件到mongoDB
	 * 
	 * @param file
	 *            文件流
	 * @param imageURL
	 *            保存后的文件名
	 * @param gridName
	 *            保存文件所在的文件夹
	 * @Author Edison
	 */
	public void savePic(File file, String imageURL, String gridName) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			DB db = mongoTemplate.getDb();
			GridFS fs = new GridFS(db, gridName);
			GridFSInputFile inputFile = fs.createFile(is, true);
			inputFile.setFilename(imageURL);
			inputFile.setContentType(imageURL.substring(imageURL
					.lastIndexOf(".") + 1));
			inputFile.save();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	public void savePic(InputStream is, String imageURL, String gridName) {
		try {
			DB db = mongoTemplate.getDb();
			GridFS fs = new GridFS(db, gridName);
			GridFSInputFile inputFile = fs.createFile(is, true);
			inputFile.setFilename(imageURL);
			inputFile.setContentType(imageURL.substring(imageURL
					.lastIndexOf(".") + 1));
			inputFile.save();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * 删除mongoDB中的文件
	 * 
	 * @param imageUrl
	 *            文件名
	 * @param gridName
	 *            文件所在的文件夹
	 * @Author Edison
	 */
	public void deletePic(String imageUrl, String gridName) {
		DB db = mongoTemplate.getDb();
		GridFS fs = new GridFS(db, gridName);
		GridFSDBFile file = fs.findOne(imageUrl);
		if (file != null) {
			fs.remove(file);
		}
	}
}
