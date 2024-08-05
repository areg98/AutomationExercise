package Constants;

public class ErrorMessages {
    private static String INCORRECT_LOGIN_DATA_ERROR_MESSAGE = "Your email or password is incorrect!";
    private static String EXITING_EMAIL_ERROR_MESSAGE = "Email Address already exist!";

    public static String getExitingEmailErrorMessage() {
        return EXITING_EMAIL_ERROR_MESSAGE;
    }

    public static String getIncorrectLoginDataErrorMessage() {
        return INCORRECT_LOGIN_DATA_ERROR_MESSAGE;
    }
}
