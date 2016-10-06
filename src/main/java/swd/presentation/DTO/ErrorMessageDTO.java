package swd.presentation.DTO;

public class ErrorMessageDTO {
    private int state;
    private String message;
    public int getstate() {
        return state;
    }
    public void setstate(int state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ErrorMessageDTO(int state, String message) {
        super();
        this.state = state;
        this.message = message;
    }
    public ErrorMessageDTO() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.state + " " +this.message;
    }
    
}
