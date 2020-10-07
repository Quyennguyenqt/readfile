package com.nqt;

public class Test {
	public static void main(String[] args) {
		String str = "TK 0080xxxx7006|GD: +672,000VND 03/07/20 15:24|SD:1,543,038VND|ND: LFI3301";
		//str = str.replaceAll(",", "");
		System.out.println(str.substring(str.indexOf("VND") + 3, str.indexOf("SD")-1).trim());
		//System.out.println(str.substring(str.indexOf('D'+ 1), str.indexOf('S'-1)));
	}
}
