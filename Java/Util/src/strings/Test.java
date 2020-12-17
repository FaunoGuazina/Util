package strings;


public class Test {

	public static void main(String[] args) {
		
		String [] exceptions = {"<<teSt<<", "teSt_tEst", "the"};
		
		String strTest = "   TEST tEsT, (TEST.TEST), <<teSt<<, teSt_tEst,   mc.beTh, hU-zIn-xun,   d'marcO'aires, tes!te, tESt.. tEsT!! TEST??? 'test' `test` 'test' \"test\"   ";
		String strTest2 = "the other words will be the words";
		
		System.out.println("STRINGS TEST:");
		System.out.println(strTest);
		System.out.println(strTest2);
		
		
		System.out.println("\n\nSTATIC METHOD TESTING");
		System.out.println(TitleCase.all(strTest));
		System.out.println(TitleCase.withExceptions(strTest, exceptions));
		System.out.println(TitleCase.withCAPITAL(strTest, "<<teSt<<", "teSt_tEst"));
		System.out.println(TitleCase.withExceptions(strTest2, exceptions));
		
		System.out.println("\nINSTANCE METHOD TESTING: ");
		TitleCase to = new TitleCase(exceptions);
		System.out.println(to.titleCase(strTest));
		System.out.println(to.titleCAPITAL(strTest));
		System.out.println(to.titleCase(strTest2));
		
		
//		OUTPUT SHOULD BE:
//			STRINGS TEST:
//			   TEST tEsT, (TEST.TEST), <<teSt<<, teSt_tEst,   mc.beTh, hU-zIn-xun,   d'marcO'aires, tes!te, tESt.. tEsT!! TEST??? 'test' `test` 'test' "test"   
//			the other words will be the words
//
//
//			STATIC METHOD TESTING
//			Test Test, (Test.Test), <<Test<<, Test_Test, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! Test??? 'Test' `Test` 'Test' "Test"
//			Test Test, (Test.Test), <<teSt<<, teSt_tEst, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! Test??? 'Test' `Test` 'Test' "Test"
//			TEST Test, (TEST.TEST), <<teSt<<, teSt_tEst, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! TEST??? 'Test' `Test` 'Test' "Test"
//			The Other Words Will Be the Words
//
//			INSTANCE METHOD TESTING: 
//			Test Test, (Test.Test), <<teSt<<, teSt_tEst, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! Test??? 'Test' `Test` 'Test' "Test"
//			TEST Test, (TEST.TEST), <<teSt<<, teSt_tEst, Mc.Beth, Hu-Zin-Xun, D'Marco'Aires, Tes!Te, Test.. Test!! TEST??? 'Test' `Test` 'Test' "Test"
//			The Other Words Will Be the Words		
	}
	
}
