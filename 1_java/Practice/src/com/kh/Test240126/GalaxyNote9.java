package com.kh.Test240126;

public class GalaxyNote9 extends SmartPhone implements NotePen {
	
	public GalaxyNote9() {
		super.setMaker("삼성");
	}
	
	@Override
	public String charge() {
		return "고속충전, 고속 무선 충전\n";
	}

	@Override
	public String touch() {
		return "정전식, 와콤펜 지원\n";
	}

	@Override
	public String makeCall() {
		return "번호를 누르고 통화버튼을 누름\n";
	}

	@Override
	public String takeCall() {
		return "전화받기 버튼을 누름\n";
	}

	@Override
	public String picture() {
		return "1300만 듀얼카메라\n";
	}

	@Override
	public boolean bluetoothPen() {
		return NotePen.PEN_BUTTON;
	}

	@Override
	public String printInformation() {
		return "갤럭시 노트9은 " + super.getMaker() + "에서 만들어졌고 제원은 다음과 같다.\n"
				+ this.makeCall()
				+ this.takeCall()
				+ this.picture()
				+ this.charge()
				+ this.touch()
				+"블루투스 펜 탑재 여부 : " + this.bluetoothPen() + "\n";
	}
	
}
