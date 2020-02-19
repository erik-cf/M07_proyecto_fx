package tools;

import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;

import application.Main;
import bbdd_tools.ConnectionManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class ReportViewer extends JFrame {

	static JFrame reportViewer = new JFrame();

	public static void showTotalPorMesesReport(String report) throws JRException, ClassNotFoundException, SQLException {

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		JasperReport jasperReport;
		String reportSrcFile = null;
		
		switch (report) {
		case Main.PROVTOTALFACTPORMESES:
			reportSrcFile = "ProveedorTotalFacturadoMeses.jrxml";
			parameters.put("id_proveedor", Main.selectedProveedor.getId());
			break;
		case Main.CLIENTETOTALGASTADOMESES:
			reportSrcFile = "ClienteTotalGastadoPorMeses.jrxml";
			parameters.put("id_cliente", Main.selectedCliente.getId());
			break;
		}
		
		jasperReport = JasperCompileManager.compileReport(reportSrcFile);

		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, ConnectionManager.getConnection());
		JRViewer viewer = new JRViewer(print);
		viewer.setOpaque(true);
		viewer.setVisible(true);
		reportViewer.add(viewer);
		reportViewer.setSize(700, 500);
		reportViewer.setVisible(true);
		parameters.clear();
	}

}
