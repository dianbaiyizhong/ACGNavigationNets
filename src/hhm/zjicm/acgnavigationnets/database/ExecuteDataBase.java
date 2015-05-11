package hhm.zjicm.acgnavigationnets.database;

import java.sql.*;

//�����̳���Open_DB��
public class ExecuteDataBase extends DBConnByMySql {
	// ���ݿ����Ӷ���
	private Connection dbConn;
	private Statement stmt;
	private ResultSet rs;
	// ���� ����� 0=�޴���-1�д���
	private int errNum;
	// error ���� ������Ϣ
	private String errDesc;

	// ��ʼ������
	public ExecuteDataBase() {
		dbConn = super.getConnection();
		stmt = null;
		rs = null;
		errNum = 0;
		errDesc = "";
	}

	// ִ��sql ִ����䣬��Ҫ��ִ�в����ɾ����SQL���
	public boolean exeSql(String strSql) {
		// System.out.println("��ʼִ�����ݿ����:" + strSql);
		try {
			stmt = dbConn.createStatement();
			stmt.executeUpdate(strSql);
			stmt.close();
			return true;
		} catch (Exception ex) {
			this.errNum = -1;
			this.errDesc = ex.toString();
			return false;
		}
	}

	/*
	 * Statement st=
	 * con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE
	 * ); ResultSet.TYPE_FORWARD_ONLY���ڽ��������ʱ�������ֻ����ǰ��
	 * ResultSet.TYPE_SCROLL_INSENSITIVE���ڽ��������ʱ����������������ƶ�
	 * ResultSet.TYPE_SCROLL_SENSITIVE���ڽ��������ʱ����������������ƶ���ͬʱ����Ҫ���в����޸ģ����������µ��������
	 * ͬʱҲ�����ֲ�������
	 * ��CONCUR_READ_ONLY��ֻ��CONCUR_UPDATABLE���ɸ��£�����ResultSet��������޸Ļᱻ���µ����ݿ⡣
	 */

	// ִ��sql ��ѯ���
	public ResultSet exeSqlQuery(String strSql) {
		 System.out.println("��ʼִ�����ݿ����:" + strSql);

		try {
			stmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(strSql);
		} catch (Exception ex) {

			this.errNum = -1;
			this.errDesc = ex.toString();
			rs = null;
		}
		return rs;
	}

	// ȡ�ô������
	public int getErrNum() {
		return errNum;
	}

	// ȡ�ô�����Ϣ
	public String getErrDesc() {
		return errDesc;
	}
}