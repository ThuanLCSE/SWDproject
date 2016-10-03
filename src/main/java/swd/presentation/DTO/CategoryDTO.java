package swd.presentation.DTO; 

public class CategoryDTO {

    private int categoryID;

    private String name;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public CategoryDTO() {
        // TODO Auto-generated constructor stub
    }

    public CategoryDTO(int categoryID, String name) {
        super();
        this.categoryID = categoryID;
        this.name = name;
    }
    
    
}
