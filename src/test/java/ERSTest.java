import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.revature.controllers.LoginController;
import com.revature.models.LoginDTO;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;
import com.revature.services.ReimbService;

public class ERSTest {
	
	public static LoginService ls = new LoginService();
	public static EmployeeService es = new EmployeeService();
	public static ReimbService ms = new ReimbService();
	public static LoginDTO lt = new LoginDTO();
	public static User user1;
	public static User user2;
	public static User admin;
	public static User emp;
	
	public static Reimb pending1;
	public static Reimb approved2;
	public static Reimb denied3;
	
	public static Reimb food3;
	public static Reimb travel2;
	public static Reimb lodging1;
	public static Reimb other4;
	
	public static UserRole man;
	public static UserRole empl;
	
	public static ReimbStatus pend;
	public static ReimbStatus deny;
	public static ReimbStatus approve;
	
	public static ReimbType lod;
	public static ReimbType trav;
	public static ReimbType food;
	public static ReimbType other;
	
	

	@BeforeClass
	public static void setTest() {
		System.out.println("In BeforeClass");
		ls = new LoginService();
		es = new EmployeeService();
		ms = new ReimbService();
		lt = new LoginDTO();
		
	}

	@Before
	public void setUsers() {
		System.out.println("In Before");
		
		
		user1 = new User('Chanry', );
		user2 = new User();
		admin= new User();
		emp = new User();	
	}
	
	@Before
	public void setReimbs() {
		pending1 = new Reimb();
		approved2 = new Reimb();
		denied3 = new Reimb();
		
		lodging1 = new Reimb();
		travel2 = new Reimb();
		food3 = new Reimb();
		other4 = new Reimb();
	}
	
	@After
	public void clearResult() {
		System.out.println("In After");
		
	}
	
	@AfterClass
	public static void clearTest() {
		System.out.println("In After");
		ls = null;
		es=null;
		ms = null;
	}
}
