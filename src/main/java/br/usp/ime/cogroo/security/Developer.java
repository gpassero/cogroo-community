package br.usp.ime.cogroo.security;

public class Developer extends Linguist {

	@Override
	public String getRoleName() {
		return "developer";
	}
	
	@Override
	public boolean getCanDeleteOtherUserCommment() {
		return true;
	}
	
	@Override
	public boolean canDeleteOtherUserErrorReport() {
		return true;
	}
	
}
