package cn.test.email.model;



import org.hibernate.validator.constraints.NotEmpty;

public class Users {
	
	/*
	 *  1 @NotEmpty :不能为null，且Size>0

		2  @NotNull:不能为null，但可以为empty,没有Size的约束

		3  @NotBlank:只用于String,不能为null且trim()之后size>0
	 * */
	
	
	@NotEmpty(message="{user.message.name}")
    private String name;

	@NotEmpty(message="{user.message.pass}")
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }
}