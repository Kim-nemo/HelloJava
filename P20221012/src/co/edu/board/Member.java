package co.edu.board;

import java.io.Serializable;

public class Member implements Serializable{
	private String mId;
	private String mName;
	private int mPoint;
	
	public Member(String mId, String mName, int mPoint) {
		this.mId = mId;
		this.mName = mName;
		this.mPoint = mPoint;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmPoint() {
		return mPoint;
	}

	public void setmPoint(int mPoint) {
		this.mPoint = mPoint;
	}
	
	@Override
	public String toString() {
		return "회원아이디: " + mId + ", 회원이름: " 
				+ mName + ", 회원포인트: "+ mPoint + "\n";
	}
	
}
