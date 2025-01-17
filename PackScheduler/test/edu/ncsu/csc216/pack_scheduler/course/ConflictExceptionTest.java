/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for ConflictException
 * @author - Sam McDonald
 */
class ConflictExceptionTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.ConflictException.course.ConflictException#ConflictException()}.
	 */
	@Test
	public void testConflictException() {
	    ConflictException ce = new ConflictException();
	    assertEquals("Schedule conflict.", ce.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.ConflictException.course.ConflictException#ConflictException(java.lang.String)}.
	 */
	@Test
	public void testConflictExceptionString() {
	    ConflictException ce = new ConflictException("Custom exception message");
	    assertEquals("Custom exception message", ce.getMessage());
	}

}
