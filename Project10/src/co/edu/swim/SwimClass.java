package co.edu.swim;

public class SwimClass {
		private int cLv;
		private String cName;
		private String cDay;
		private String cTeacher;
		
		public SwimClass() {}
		
		public SwimClass(int cLv, String cName, String cDay, String cTeacher) {
			this.cLv = cLv;
			this.cName = cName;
			this.cDay = cDay;
			this.cTeacher = cTeacher;
		}

		public int getcLv() {
			return cLv;
		}

		public void setcLv(int cLv) {
			this.cLv = cLv;
		}

		public String getcName() {
			return cName;
		}

		public void setcName(String cName) {
			this.cName = cName;
		}

		public String getcDay() {
			return cDay;
		}

		public void setcDay(String cDay) {
			this.cDay = cDay;
		}

		public String getcTeacher() {
			return cTeacher;
		}

		public void setcTeacher(String cTeacher) {
			this.cTeacher = cTeacher;
		}
		
		@Override
		public String toString() {
		return "레벨: " + cLv + "급, 수업명: " + cName 
				+ ", 수업요일: " + cDay + ", 강사명: " +cTeacher;
		}
}
