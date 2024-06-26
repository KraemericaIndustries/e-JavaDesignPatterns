package jdpSolid;

//Terminal expression
public class Permission implements PermissionExpression{

	private String permission;
	
	public Permission(String permission) {
		this.permission = permission.toLowerCase();
	}
	
	@Override
	public boolean interpret(UserInterpreter user) {
		return user.getPermissions().contains(permission);
	}

	@Override
	public String toString() {
		return permission;
	}	
}