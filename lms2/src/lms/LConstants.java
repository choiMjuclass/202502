package lms;

import java.util.Vector;

public class LConstants {
	public final static String FILENAME_ROOT = "root";
	
	public enum EFrame {
		eX(400),
		eY(100),
		eW(1200),
		eH(600);
		private int value;
		private EFrame(int value) {
			this.value = value;
		}
		public int value() {
			return this.value;
		}		
	}
	
	public enum ETable {
		eCampus("캠퍼스", EIndex.values()),
		eCollege("대학", EIndex.values()),
		eDepartment("학과", EIndex.values()),
		eGangjwa("강좌", EGangjwa.values()),
		eMiridamgi("미리담기", EGangjwa.values()),
		eSincheong("수강신청", EGangjwa.values());
		
		private String text;
		private IColumn[] iColumns;
		private ETable(String text, IColumn[] iColumns) {
			this.text = text;
			this.iColumns = iColumns;
		}
		public String getText() {
			return this.text;
		}
		public Vector<IColumn> getIColumns() {
			Vector<IColumn> projectedColumns = new Vector<IColumn>();
			for (IColumn iColumn: this.iColumns) {
				if (iColumn.isProjected()) {
					projectedColumns.add(iColumn);
				}
			}
			return projectedColumns;
		}
	}
	
	public interface IColumn {
		public String getText();
		public boolean isProjected();
		public int getPreferredWidth();
		public int getOrdianl();
	}	
	
	public enum EIndex implements IColumn {
		eId("아이디", false, 0),
		eName("이름", true, 50),
		eFileName("파일명", false, 0);
		
		private String text;
		private boolean bProjected;
		private int preferredWidth;
		
		private EIndex(String text, boolean bProjected, int preferredWidth) {
			this.text = text;
			this.bProjected = bProjected;
			this.preferredWidth = preferredWidth;
		}
		public String getText() {
			return this.text;
		}
		public boolean isProjected() {
			return this.bProjected;
		}
		public int getPreferredWidth() {
			return this.preferredWidth;
		}
		public int getOrdianl() {
			return this.ordinal();
		}
	}
	
	public enum EGangjwa implements IColumn {
		eId("아이디", true, 50),
		eName("강좌명", true, 100),
		eLecturer("강사", true, 100),
		eCredit("학점", true, 50),
		eTime("시간", true, 150);
		
		private String text;
		private boolean bProjected;
		private int preferredWidth;
		
		private EGangjwa(String text, boolean bProjected, int preferredWidth) {
			this.text = text;
			this.bProjected = bProjected;
			this.preferredWidth = preferredWidth;
		}
		public String getText() {
			return this.text;
		}
		public boolean isProjected() {
			return this.bProjected;
		}
		public int getPreferredWidth() {
			return this.preferredWidth;
		}
		public int getOrdianl() {
			return this.ordinal();
		}
	}
}
