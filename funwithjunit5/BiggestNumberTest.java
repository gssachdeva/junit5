package funwithjunit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.Test;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing with JUnit 5")
class BiggestNumberTest {

	private static final Logger log = Logger.getLogger(
			BiggestNumberTest.class.getName());
	
	private BiggestNumber biggestNumber;
	
	@BeforeAll
	public static void init() {
		// Initialization before any test is run 
		log.info("@BeforeAll: init()");
	}
	
	@AfterAll
	public static void done() {
		// Cleanup after all the tests are run 
		log.info("@AfterAll: done()");
	}

	@BeforeEach
	public void setUp() throws Exception {
		// Set up before test execution 
		log.info("@BeforeEach: setUp()");
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		// Clean up after test execution 
		log.info("@AfterEach: tearDown()");
	}
	
	@Test
	@Disabled
	@DisplayName("Disabled Test")
	void testNoRun() {
		log.info("Oops ! This test will not run.");
	}
	
	@Test
	@DisplayName("Dummy Test")
	void testDummy() {
		log.info("This test will always pass!");
		assertEquals(1, 1);
	}
	
	@Test
	@DisplayName("When numbers are > 0")
	public void testAdd() {
		log.info("@Test: testAdd()");
		
		assertNotNull(biggestNumber);
		
		assertAll(
			() -> {
				//Test # 1
				long[] numbers = { 20, 10, 50, 40, 30 };
				long expectedMaxNum = 50;
				long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
				assertEquals(expectedMaxNum, actualMaxNum);
			},
			() -> {
				//Test # 2
				long[] numbers = { 99, 69, 89 };
				long expectedMaxNum = 99;
				long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
				assertEquals(expectedMaxNum, actualMaxNum);
			},
			() -> {
				//Test # 3
				long[] numbers = { 201, 333, 102 };
				long expectedMaxNum = 333;
				long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
				assertEquals(expectedMaxNum, actualMaxNum);
			});
	}
	
	@Nested
	@DisplayName("When numbers are < 0")
	class NegativeNumbersTest {
		private BiggestNumber bigNumber;
		
		@BeforeEach
		public void setUp() throws Exception {
			// Set up before test execution 
			log.info("@BeforeEach: setUp()");
		}
		
		@AfterEach
		public void tearDown() throws Exception {
			// Clean up after test execution 
			log.info("@AfterEach: tearDown()");
		}
	
		@Test
		@DisplayName("Test with numbers < 0")
		void testAdd() {
			log.info("@Test: testAdd()");
		
			assertNotNull(bigNumber);
		
			assertAll(
				() -> {
					//Test # 1
					long[] numbers = { -20, -10, -50, -40, -30 };
					long expectedMaxNum = -10;
					long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
					assertEquals(expectedMaxNum, actualMaxNum);
				},
				() -> {
					//Test # 2
					long[] numbers = { -99, -69, -89 };
					long expectedMaxNum = -69;
					long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
					assertEquals(expectedMaxNum, actualMaxNum);
				},
				() -> {
					//Test # 3
					long[] numbers = { -201, -333, -102 };
					long expectedMaxNum = -102;
					long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
					assertEquals(expectedMaxNum, actualMaxNum);
			});
		}
	}
	
	@Nested
	@DisplayName("With both positive and negative numbers")
	class PositiveAndNegativeNumbersTest {
		private BiggestNumber bigNumber;
		
		@BeforeEach
		public void setUp() throws Exception {
			// Set up before test execution 
			log.info("@BeforeEach: setUp()");
		}
		
		@AfterEach
		public void tearDown() throws Exception {
			// Clean up after test execution 
			log.info("@AfterEach: tearDown()");
		}
	
		@Test
		@DisplayName("Test with positive and negative numbers")
		void testAdd() {
			log.info("@Test: testAdd()");
		
			assertNotNull(bigNumber);
		
			assertAll(
				() -> {
					//Test # 1
					long[] numbers = { 20, -10, -50, 40, -30 };
					long expectedMaxNum = 40;
					long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
					assertEquals(expectedMaxNum, actualMaxNum);
				},
				() -> {
					//Test # 2
					long[] numbers = { -99, 69, -89 };
					long expectedMaxNum = 69;
					long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
					assertEquals(expectedMaxNum, actualMaxNum);
				},
				() -> {
					//Test # 3
					long[] numbers = { 201, 333, -102 };
					long expectedMaxNum = 333;
					long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
					assertEquals(expectedMaxNum, actualMaxNum);
			});
		}
	}
	
	@Test
	@DisplayName("Using a single number")
	public void testSingleNumber() {
		log.info("@Test: testSingleNumber()");
		
		assertNotNull(biggestNumber);
		
		assertAll(
			() -> {
				//Test # 1
				long[] numbers = { 20 };
				long expectedMaxNum = 20;
				long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
				assertEquals(expectedMaxNum, actualMaxNum);
			},
			() -> {
				//Test # 2
				long[] numbers = { 0 };
				long expectedMaxNum = 0;
				long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
				assertEquals(expectedMaxNum, actualMaxNum);
			},
			() -> {
				//Test # 3
				long[] numbers = { -102 };
				long expectedMaxNum = -102;
				long actualMaxNum = biggestNumber.findBiggestNumber(numbers);
				assertEquals(expectedMaxNum, actualMaxNum);
			});
	}
	
	@Nested
	@DisplayName("With no numbers")
	class NoNumbersTest {
		private BiggestNumber bigNumber;
		
		@BeforeEach
		public void setUp() throws Exception {
			// Set up before test execution 
			log.info("@BeforeEach: setUp()");
		}
		
		@AfterEach
		public void tearDown() throws Exception {
			// Clean up after test execution 
			log.info("@AfterEach: tearDown()");
		}
	
		@Test
		@DisplayName("Test with empty arguments")
		void testMissingNumbers() {
			log.info("@Test: testMissingNumbers()");
		
			assertNotNull(bigNumber);
			
			long[] emptyNumArray = {};
			
			assertThrows(IllegalArgumentException.class,
					() -> bigNumber.findBiggestNumber(emptyNumArray));
		}
		
		@Test
		@DisplayName("Test with Null argument")
		void testNullArgument() {
			log.info("@Test: testNullArgument()");
		
			assertNotNull(bigNumber);
			
			long[] nullArray = null;
			
			Throwable expectedException = assertThrows(IllegalArgumentException.class,
					() -> bigNumber.findBiggestNumber(nullArray));
			
			assertEquals("Operands argument cannot be null",
					expectedException.getLocalizedMessage());
		}
	}
}
