package co.syeon.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException;

}
