package com.ninh.meovat;

public class MeoVat {
	String MeovatID;
	String Loai;
	String DanhMucCon;
	String TenMeoVat;
	String TenThamChieu;
	String NoiDungMeoVat;
	
	public MeoVat(String MeovatID,String Loai,String DanhMucCon,String TenMeoVat,String TenThamChieu,String NoiDungMeoVat)
	{
		this.MeovatID = MeovatID;
		this.Loai= Loai;
		this.DanhMucCon = DanhMucCon;
		this.TenMeoVat = TenMeoVat;
		this.TenThamChieu = TenThamChieu;
		this.NoiDungMeoVat = NoiDungMeoVat;
		
	}
	public String getMeovatID() {
		return MeovatID;
	}
	public String getLoai() {
		return Loai;
	}
	public String getDanhMucCon() {
		return DanhMucCon;
	}
	public String getTenMeoVat() {
		return TenMeoVat;
	}
	public String getTenThamChieu() {
		return TenThamChieu;
	}
	public String getNoiDungMeoVat() {
		return NoiDungMeoVat;
	}
}
