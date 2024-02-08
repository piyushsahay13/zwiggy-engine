/**
 * 
 */
package com.zwiggy.zwiggyengine.constant;

/**
 * @author hp
 *
 */
public final class RegexConstanst {

	private RegexConstanst() {
		throw new IllegalStateException("Constant class");
	}
	public static final String EMAILREGEX ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	public static final String ONLYNUMREGEX = "\\d+";
	public static final String CONTAINNUMANDSPCLCHAR = ".*[^a-zA-Z0-9].*[0-9].*|.*[0-9].*[^a-zA-Z0-9].*";
}
