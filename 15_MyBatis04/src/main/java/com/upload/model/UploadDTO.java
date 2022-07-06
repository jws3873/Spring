package com.upload.model;

import lombok.Data;

@Data
public class UploadDTO {
	private int upload_no;
	private String upload_writer;
	private String upload_title;
	private String upload_cont;
	private String upload_pwd;
	private String upload_file;
	private int upload_hit;
	private String upload_date;
	private String upload_update;
}
