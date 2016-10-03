package swd.presentation.DTO;

public class ErrorMessageDTO {
    private int type;
    private String message;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ErrorMessageDTO(int type, String message) {
        super();
        this.type = type;
        this.message = message;
    }
    public ErrorMessageDTO() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.type + " " +this.message;
    }
    
}
