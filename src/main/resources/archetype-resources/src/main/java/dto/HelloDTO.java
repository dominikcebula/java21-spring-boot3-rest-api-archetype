#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

public class HelloDTO {

    private String message;

    @SuppressWarnings("unused")
    public HelloDTO() {
    }

    public HelloDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
