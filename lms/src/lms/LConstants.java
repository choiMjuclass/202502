package lms;

public class LConstants {
	public final static int LFRAME_X = 400;
	public final static int LFRAME_Y = 100;
	public final static int LFRAME_W = 800;
	public final static int LFRAME_H = 400;
	
	public enum EGangjwa {
		eId("아이디"),
		eName("강좌명"),
		eTime("시간"),
		eLecturer("강사");;
		
		private String text;
		private EGangjwa(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
}
