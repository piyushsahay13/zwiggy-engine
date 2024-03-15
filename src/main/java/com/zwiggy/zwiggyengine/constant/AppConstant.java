/**
 * 
 */
package com.zwiggy.zwiggyengine.constant;

/**
 * A final class containing constants used throughout the application.
 * This class includes various string constants such as delimiters, success/failure messages,
 * package names, and email-related messages.
 *
 * <p>Commonly used constants include:
 * - {@link #DASH}: A dash symbol ("-") used as a delimiter.
 * - {@link #USERADDED}: Success message indicating successful user addition.
 * - {@link #CONTROLLER_PACKAGE}: Package name for controllers in the application.
 * - {@link #SUCCESS}: Generic success message.
 * - {@link #FAILURE}: Generic failure message.
 * - {@link #COLANSEP}: A colon-separated string used as a delimiter.
 * - {@link #RESTADDED}: Success message indicating successful restaurant addition.
 * - {@link #EMAIL_VERIFY}: Message instructing users to check their inbox for email verification.
 * - {@link #EMAIL_VERIFICATION}: Subject for new user email verification.
 * - {@link #USER}: Key representing user information.
 * - {@link #EMAILBANNER}: Filename for the email banner attachment.
 *
 * <p>Uncommented constants (e.g., CONTENT_TYPE, APPLICATION_JSON, ACCEPT, TOKEN, POST_METHOD) are
 * currently commented out and not used in the code.
 *
 * @author Piyush
 * @version 1.0
 * @since 2024-03-07
 */
public final class AppConstant {
	public static final String DASH = "-";
	public static final String USERADDED = " added successfully!";
	public static final String CONTROLLER_PACKAGE = "com.zwiggy.zwiggyengine.controller";
	public static final String SUCCESS = "Sucess";
	public static final String FAILURE = "Failure";
	public static final String COLANSEP = " ::: ";
	public static final String RESTADDED = " restaurant added successfully!";
	public static final String EMAIL_VERIFY = "Please check your inbox to verify your email Id.";

//	public static final String CONTENT_TYPE = "Content-Type";
//	public static final String APPLICATION_JSON = "application/json";
//	public static final String ACCEPT = "Accept";
//	public static final String TOKEN = "Api-Token";
//	public static final String POST_METHOD = "POST";
	public static final String EMAIL_VERIFICATION ="Email verification.";
	public static final String USER = "user";
	public static final String EMAILBANNER = "EmailBanner";

}
