package hhm.zjicm.acgnavitionnets.database.tool;

import hhm.zjicm.acgnavigationnets.database.pojo.IndexFrame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultSetTool {
	public IndexFrame[][] getIndexFrameArray(ResultSet rs, int column, int rows) {
		List list = new ArrayList<IndexFrame>();
		try {
			while (rs.next()) {
				IndexFrame indexFrame = new IndexFrame();
				indexFrame.setIndexFrameID(rs.getString("IndexFrameID"));
				indexFrame.setIndexFrameName(rs
						.getString("IndexFrameSecondName"));
				list.add(indexFrame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		IndexFrame arr[][] = new IndexFrame[column][rows];
		Iterator<IndexFrame> it = list.iterator();
		while (it.hasNext()) {
			for (int i = 0; i < column; i++) {
				for (int j = 0; j < rows; j++) {
					

					arr[i][j] = it.next();
					
					it.remove();

				}

			}

		}

		return arr;

	}

}
