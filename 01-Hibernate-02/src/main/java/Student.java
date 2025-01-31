import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //It is for create table automatically
public class Student {

	@Id  //It is for primary key
	private int rno;
	private String name;
	private float marks;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", marks=" + marks + ", getRno()=" + getRno() + ", getName()="
				+ getName() + ", getMarks()=" + getMarks() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
//hibernamete5.2.17
