package strings;


public class Test {

	public static void main(String[] args) {
		
		String [] exceptions = {"<<teSt<<", "teSt_tEst"};
		
		String strTest = "   TEST tEsT, (TEST.TEST), <<teSt<<, teSt_tEst,   mc.beTh, hU-zIn-xun,   d'marcO'aires, tes!te, tESt.. tEsT!! TEST??? 'test' `test` 'test' \"test\"   ";
		
		System.out.println(TitleCase.of(strTest));
		System.out.println(TitleCase.of(strTest, exceptions));
		System.out.println(TitleCase.of(strTest, true, exceptions));
		System.out.println(TitleCase.of(strTest, true, true, "<<teSt<<", "teSt_tEst"));
		
		/* OUTPUT SHOULD BE:
 		Test Test, (Test.Test), <<Test<<, Test_Test, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! Test??? 'Test' `Test` 'Test' "Test"
		Test Test, (Test.Test), <<Test<<, Test_Test, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! Test??? 'Test' `Test` 'Test' "Test"
		Test Test, (Test.Test), <<Test<<, teSt_tEst, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! Test??? 'Test' `Test` 'Test' "Test"
		TEST Test, (TEST.TEST), <<teSt<<, teSt_tEst, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! TEST??? 'Test' `Test` 'Test' "Test"
		 */
		
	}
	
}
