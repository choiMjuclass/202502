package lms;

public class LConstants {
	public final static int LFRAME_X = 400;
	public final static int LFRAME_Y = 100;
	public final static int LFRAME_W = 800;
	public final static int LFRAME_H = 400;
	

	public enum ETable {
		eCampus("캠퍼스", EIndexColumn.values()),
		eCollege("대학", EIndexColumn.values()),
		eDepartment("학과", EIndexColumn.values()),
		eSelection("선택", EGangjwaColumn.values()),
		eMiridamgi("미리담기", EGangjwaColumn.values()),
		eSincheong("수강신청", EGangjwaColumn.values());

		private String text;
		private EColumn[] eColumns;
		private ETable(String text, EColumn[] eColumns) {
			this.text = text;
			this.eColumns = eColumns;
		}
		public String getText() {
			return this.text;
		}
		public EColumn[] getEColumns() {
			return this.eColumns;
		}
	}
	
	public interface EColumn {
		public String getText();
	}
	
	public enum EIndexColumn implements EColumn {
		eId("아이디"),
		eName("이름"),
		eFileName("파일명");
		
		private String text;
		private EIndexColumn(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EGangjwaColumn implements EColumn {
		eId("아이디"),
		eName("강좌명"),
		eLecturer("강사"),
		eCredit("학점"),
		eTime("시간");
		
		private String text;
		private EGangjwaColumn(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
}
