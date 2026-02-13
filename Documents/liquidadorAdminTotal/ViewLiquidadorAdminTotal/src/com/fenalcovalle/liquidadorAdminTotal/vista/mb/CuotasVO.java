package com.fenalcovalle.liquidadorAdminTotal.vista.mb;


public class CuotasVO {


	 private int noCuota;
	    private String valorCapital;
	    private String valorIntereses;
	    private String totalCuotas;
	    private String saldoCapital;
	    private String fechaVencimiento;
	    private String iva;
	    private String portesTelex;
	    private String otrasPlazas;
	    private String comisionFenalcheque;
	    private String ComisionTransferencia;

	    public CuotasVO() {
	    }

	    public void setNoCuota(int noCuota) {
	        this.noCuota = noCuota;
	    }

	    public int getNoCuota() {
	        return noCuota;
	    }

	    public void setValorCapital(String valorCapital) {
	        this.valorCapital = valorCapital;
	    }

	    public String getValorCapital() {
	        return valorCapital;
	    }

	    public void setValorIntereses(String valorIntereses) {
	        this.valorIntereses = valorIntereses;
	    }

	    public String getValorIntereses() {
	        return valorIntereses;
	    }

	    public void setTotalCuotas(String totalCuotas) {
	        this.totalCuotas = totalCuotas;
	    }

	    public String getTotalCuotas() {
	        return totalCuotas;
	    }

	    public void setSaldoCapital(String saldoCapital) {
	        this.saldoCapital = saldoCapital;
	    }

	    public String getSaldoCapital() {
	        return saldoCapital;
	    }

	    public void setFechaVencimiento(String fechaVencimiento) {
	        this.fechaVencimiento = fechaVencimiento;
	    }

	    public String getFechaVencimiento() {
	        return fechaVencimiento;
	    }

	    public void setIva(String iva) {
	        this.iva = iva;
	    }

	    public String getIva() {
	        return iva;
	    }

	    public void setPortesTelex(String portesTelex) {
	        this.portesTelex = portesTelex;
	    }

	    public String getPortesTelex() {
	        return portesTelex;
	    }

	    public void setOtrasPlazas(String otrasPlazas) {
	        this.otrasPlazas = otrasPlazas;
	    }

	    public String getOtrasPlazas() {
	        return otrasPlazas;
	    }

	    public void setComisionFenalcheque(String comisionFenalcheque) {
	        this.comisionFenalcheque = comisionFenalcheque;
	    }

	    public String getComisionFenalcheque() {
	        return comisionFenalcheque;
	    }

	    public void setComisionTransferencia(String comisionTransferencia) {
	        this.ComisionTransferencia = comisionTransferencia;
	    }

	    public String getComisionTransferencia() {
	        return ComisionTransferencia;
	    }

		@Override
		public String toString() {
			return "CuotasVO [noCuota=" + noCuota + ", valorCapital=" + valorCapital + ", valorIntereses="
					+ valorIntereses + ", totalCuotas=" + totalCuotas + ", saldoCapital=" + saldoCapital
					+ ", fechaVencimiento=" + fechaVencimiento + ", iva=" + iva + ", portesTelex=" + portesTelex
					+ ", otrasPlazas=" + otrasPlazas + ", comisionFenalcheque=" + comisionFenalcheque
					+ ", ComisionTransferencia=" + ComisionTransferencia + "]";
		}
    
    
	    
	    
    
}