package Constants;

public class Messages {
    private static String INCORRECT_LOGIN_DATA_ERROR_MESSAGE = "Your email or password is incorrect!";
    private static String EXITING_EMAIL_ERROR_MESSAGE = "Email Address already exist!";
    private static String CONTACT_US_SUCCESS_MESSAGE = "Success! Your details have been submitted successfully.";

    public static String getContactUsSuccessMessage() {
        return CONTACT_US_SUCCESS_MESSAGE;
    }

    public static String getExitingEmailErrorMessage() {
        return EXITING_EMAIL_ERROR_MESSAGE;
    }

    public static String getIncorrectLoginDataErrorMessage() {
        return INCORRECT_LOGIN_DATA_ERROR_MESSAGE;
    }
}
