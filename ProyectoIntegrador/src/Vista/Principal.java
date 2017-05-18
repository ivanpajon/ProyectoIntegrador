package Vista;

import Controlador.*;
import OracleAccess.*;

public class Principal {

	public static void main(String[] args) {
		VInicio vInicio = new VInicio();
		OracleAccess bbdd = new OracleAccess();
		CInicio cInicio = new CInicio(vInicio, bbdd);
		
		vInicio.setControlador(cInicio);
		vInicio.setVisible(true);
	}

}
