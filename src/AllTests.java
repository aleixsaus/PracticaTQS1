import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   PlayerTest.class, 
   ClueTest.class,
   MastermindTest.class,
   CodeTest.class,
   SecretCodeTest.class,
})

public class AllTests {  

} 