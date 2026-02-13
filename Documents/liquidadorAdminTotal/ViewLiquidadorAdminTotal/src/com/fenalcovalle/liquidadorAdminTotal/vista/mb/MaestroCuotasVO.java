package com.fenalcovalle.liquidadorAdminTotal.vista.mb;

import java.util.Date;
import java.util.List;

public class MaestroCuotasVO {
	private String valorIntereses;
    private String valorComisionFCH;
    private String monto;
    private String valorOtrasPlazas;
    private String valorAval;
    private String valorComisionTransferencia;
    private Double tasaInteres;
    
    private Date fechaVencimiento;
    
    
    
    private List<CuotasVO> cuotas;

    public MaestroCuotasVO() {
    }





	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}





	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}





	public void setValorIntereses(String valorIntereses) {
        this.valorIntereses = valorIntereses;
    }

    public String getValorIntereses() {
        return valorIntereses;
    }

    public void setValorComisionFCH(String valorComisionFCH) {
        this.valorComisionFCH = valorComisionFCH;
    }

    public String getValorComisionFCH() {
        return valorComisionFCH;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto() {
        return monto;
    }

    public void setValorOtrasPlazas(String valorOtrasPlazas) {
        this.valorOtrasPlazas = valorOtrasPlazas;
    }

    public String getValorOtrasPlazas() {
        return valorOtrasPlazas;
    }

    public void setCuotas(List<CuotasVO> cuotas) {
        this.cuotas = cuotas;
    }

    public List<CuotasVO> getCuotas() {
        return cuotas;
    }

    public void setValorAval(String valorAval) {
        this.valorAval = valorAval;
    }

    public String getValorAval() {
        return valorAval;
    }

    public void setValorComisionTransferencia(String valorComisionTransferencia) {
        this.valorComisionTransferencia = valorComisionTransferencia;
    }

    public String getValorComisionTransferencia() {
        return valorComisionTransferencia;
    }

    public void setTasaInteres(Double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Double getTasaInteres() {
        return tasaInteres;
    }


	@Override
	public String toString() {
		return "MaestroCuotasVO [valorIntereses=" + valorIntereses + ", valorComisionFCH=" + valorComisionFCH
				+ ", monto=" + monto + ", valorOtrasPlazas=" + valorOtrasPlazas + ", valorAval=" + valorAval
				+ ", valorComisionTransferencia=" + valorComisionTransferencia + ", tasaInteres=" + tasaInteres
				+ ", cuotas=" + cuotas + "]";
	}
    
    
    
    
    
    
}