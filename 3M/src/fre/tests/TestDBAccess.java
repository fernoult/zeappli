package fre.tests;

import java.sql.SQLException;

import fre.mmm.databases.manager.DBEmbededManager;
import fre.mmm.resources.enums.EnumMessageDisplayer;

public class TestDBAccess {

	public static void main(String[] args) {

		try {
			DBEmbededManager.getInstance().createShema();
			Thread.sleep(2000);
			DBEmbededManager.getInstance().initDatasDB();
			Thread.sleep(2000);
//			DBEmbededManager.getInstance().dropShema();
//			Thread.sleep(2000);
			DBEmbededManager.getInstance().closeEmbededDatabase();
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (InterruptedException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}

}
