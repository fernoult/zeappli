package fre.tests;

import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.utils.LogsUtils;

public class TestLogsAccess {

	public static void main(String[] args){
		
		for (int i = 0; i < 50; i++) {
			LogsUtils.getInstance().writeOnLog("je teste les logs a la suite les uns des autres.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
			}
		}
		System.out.println("fin");
	}
}
