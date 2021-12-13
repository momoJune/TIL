package kr.green.game;

import lombok.Data;

@Data
public class Card {
	private int num;
	private boolean isShow;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	
	
}
